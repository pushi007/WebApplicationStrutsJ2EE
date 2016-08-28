package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.itextpdf.text.log.SysoLogger;
import com.tvm.ilp.t154.cao.encdec.SecurePassword;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	int i;
	boolean flag = false;
	public int empId;
	String branchId;
	String branch_Nm;

	public int addEmployee(Employee emp) throws CommercialCustRegException {
		try {
			logger.info("Entry into add Employee DAO layer");
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("Select BRANCH_ID from BRANCH where BRANCH_NAME=?");
			ps.setString(1, emp.getBranchName());
			rs = ps.executeQuery();

			while (rs.next()) {
				branchId = rs.getString(1);
			}

			ps = con
					.prepareStatement("insert into Employee(EMP_ID,TITLE,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DATE_OF_BIRTH,ADDRESS,CONTACTNO,ALT_CONTACTNO,EMAIL,DESIGNATION,DATE_OF_JOINING,STATUS,BRANCH_ID) values(emp_seq.nextval,?,?,?,?,to_date(?,'yyyy/mm/dd'),?,?,?,?,?,to_date(?,'yyyy/mm/dd'),?,?)");

			ps.setString(1, emp.getTitle());
			ps.setString(2, emp.getFirstNm());
			if (!emp.getMiddleNm().equals(null)) {
				ps.setString(3, emp.getMiddleNm());
			} else {
				ps.setString(3, null);
			}
			ps.setString(4, emp.getLastNm());
			ps.setString(5, emp.getDateOfBirth());
			ps.setString(6, emp.getAddress());
			ps.setLong(7, emp.getContactno());

			if (emp.getAltContactNo() == 0) {
				ps.setString(8, null);
			} else {
				ps.setLong(8, emp.getAltContactNo());
			}

			ps.setString(9, emp.getEmailId());
			ps.setString(10, emp.getDesignation());
			ps.setString(11, emp.getDateOfJoin());
			ps.setString(12, emp.getStatus());
			ps.setString(13, branchId);

			i = ps.executeUpdate();
			if (i > 0) {

				ps = con.prepareStatement("Select emp_seq.currval from dual");
				rs = ps.executeQuery();
				while (rs.next()) {
					empId = rs.getInt(1);
				}
				for (String groupNm : emp.getGroups()) {

					ps = con
							.prepareStatement("Insert into EMP_GROUPS values(?,?)");
					ps.setInt(1, empId);
					ps.setString(2, groupNm);
					i = ps.executeUpdate();
					if (i > 0) {
						flag = true;
					} else
						flag = false;
				}
			} else
				flag = false;

		} catch (ClassNotFoundException e) {
			logger.error("Connection problem in Register Employee DAO");
			throw new CommercialCustRegException("Connection Problem");

		} catch (SQLException e) {
			logger.error("Database query problem in Register Employee DAO");
			throw new CommercialCustRegException("Employee Registration Failed");

		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection problem");

			}

		}
		if (flag == true) {
			return empId;
		} else
			return 0;
	}

	public boolean setEmpPassword(Employee emp) throws CommercialCustRegException {
		String password=emp.getPassword();
		
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into LOGIN(EMP_ID,PASSWORD)values(?,?)");
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, SecurePassword.encrypt(password));
			i = ps.executeUpdate();
			if (i > 0)
				flag = true;
			else
				flag = false;
		} catch (ClassNotFoundException e) {

			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {

			throw new CommercialCustRegException("Employee Registation Failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
		}
		return flag;
	}

	public List<Employee> viewEmployee() throws CommercialCustRegException {
		List<Employee> empList = new ArrayList<Employee>();

		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("Select * from EMPLOYEE");

			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setFirstNm(rs.getString(3));
				emp.setLastNm(rs.getString(5));
				emp.setDesignation(rs.getString(11));

				empList.add(emp);

			}
		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee Details not found");
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
		}
		return empList;
	}

	public Employee searchDetails(int empId) throws CommercialCustRegException {

		Employee emp = new Employee();
		try {
			con = ConnectionUtil.getConnection();

			ps=con.prepareStatement("Select EMPLOYEE.EMP_ID,TITLE,FIRST_NAME,MIDDLE_NAME,LAST_NAME,TO_CHAR(DATE_OF_BIRTH,'yyyy/mm/dd'),ADDRESS,CONTACTNO,ALT_CONTACTNO,EMAIL,DESIGNATION,TO_CHAR(DATE_OF_JOINING,'yyyy/mm/dd'),STATUS,BRANCH_NAME FROM EMPLOYEE INNER JOIN BRANCH ON BRANCH.BRANCH_ID=EMPLOYEE.BRANCH_ID WHERE EMP_ID=?");
			ps.setInt(1, empId);

			rs = ps.executeQuery();
			while (rs.next()) {

				emp.setEmpId(rs.getInt(1));
				emp.setTitle(rs.getString(2));
				emp.setFirstNm(rs.getString(3));
				if (rs.getString(4) != null) {
					emp.setMiddleNm(rs.getString(4));
				} else {
					emp.setMiddleNm("");
				}
				emp.setLastNm(rs.getString(5));
				emp.setDateOfBirth(rs.getString(6));
				emp.setAddress(rs.getString(7));
				emp.setContactno((rs.getLong(8)));
				emp.setAltContactNo((rs.getLong(9)));
				emp.setEmailId(rs.getString(10));
				emp.setDesignation(rs.getString(11));
				emp.setDateOfJoin(rs.getString(12));
				emp.setStatus(rs.getString(13));
				emp.setBranchName(rs.getString(14));

			}

			ps = con
					.prepareStatement("Select GROUP_NAME from EMP_GROUPS where EMP_ID=?");
			ps.setInt(1, empId);

			rs = ps.executeQuery();
			List<String> groupNames = new ArrayList<String>();
			while (rs.next()) {
				groupNames.add(rs.getString(1));
			}
			emp.setGroups(groupNames);

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee not found");
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
		}
		return emp;
	}

	public List<String> getDesigFromDB() throws CommercialCustRegException {
		List<String> desigList = new ArrayList<String>();

		try {
			try {
				con = ConnectionUtil.getConnection();
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

			try {
				ps = con
						.prepareStatement("Select * from Designation order by DESIGNATION.Designation");
				rs = ps.executeQuery();

				while (rs.next()) {
					desigList.add(rs.getString(1));

				}
			} catch (SQLException e) {
				throw new CommercialCustRegException(
						"Designation not available");
			}

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");

		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

		}
		return desigList;
	}

	// Update Employee
	public boolean updateEmpInDB(Employee emp)
			throws CommercialCustRegException {
		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("Select BRANCH_ID from BRANCH where BRANCH_NAME=?");
			ps.setString(1, emp.getBranchName());
			rs = ps.executeQuery();

			while (rs.next()) {
				branchId = rs.getString(1);
			}

			ps = con
					.prepareStatement("Update Employee set TITLE=?,FIRST_NAME=?,MIDDLE_NAME=?,LAST_NAME=?,DATE_OF_BIRTH=(to_date(?,'yyyy/mm/dd')),ADDRESS=?,CONTACTNO=?,ALT_CONTACTNO=?,EMAIL=?,DESIGNATION=?,DATE_OF_JOINING=(to_date(?,'yyyy/mm/dd')),BRANCH_ID=? where EMP_ID=?");

			ps.setString(1, emp.getTitle());
			ps.setString(2, emp.getFirstNm());
			if (!emp.getMiddleNm().equals(null)) {
				ps.setString(3, emp.getMiddleNm());
			} else {
				ps.setString(3, null);
			}
			ps.setString(4, emp.getLastNm());
			ps.setString(5, emp.getDateOfBirth());
			ps.setString(6, emp.getAddress());
			ps.setLong(7, emp.getContactno());
			if (emp.getAltContactNo() == 0) {
				ps.setString(8, null);
			} else {
				ps.setLong(8, emp.getAltContactNo());
			}
			//ps.setLong(8, emp.getAltContactNo());
			ps.setString(9, emp.getEmailId());
			ps.setString(10, emp.getDesignation());
			ps.setString(11, emp.getDateOfJoin());
			ps.setString(12, branchId);
			ps.setInt(13, emp.getEmpId());

			i = ps.executeUpdate();
			if (i > 0) {

				ps = con
						.prepareStatement("Delete from EMP_GROUPS where EMP_ID=?");
				ps.setInt(1, emp.getEmpId());
				i = ps.executeUpdate();
				if (i > 0) {
					for (String groupNm : emp.getGroups()) {
						ps = con
								.prepareStatement("Insert into EMP_GROUPS values(?,?)");
						ps.setInt(1, emp.getEmpId());
						ps.setString(2, groupNm);
						i = ps.executeUpdate();
						if (i > 0) {
							flag = true;
						} else
							flag = false;
					}
				} else
					flag = false;
			} else
				flag = false;

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee Details not updated");
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

		}
		return flag;
	}

	// get Branch Name from database
	public List<String> getBranchFromDB() throws CommercialCustRegException {
		List<String> branchList = new ArrayList<String>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement("Select * from Branch");
			rs = ps.executeQuery();

			while (rs.next()) {
				branchList.add(rs.getString(2));
			}

		} catch (ClassNotFoundException e) {

			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Bank branches not available");
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
		}
		return branchList;

	}

	public boolean deactivateEmpDB(Employee emp)
			throws CommercialCustRegException {
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("Update EMPLOYEE set DATE_OF_LEAVING=sysdate,REASON_FOR_LEAVING=?,STATUS=? where EMP_ID=?");
			//ps.setString(1, emp.getDateOfLeave());
			ps.setString(1, emp.getReasonOfLeave());
			ps.setString(2, emp.getStatus());
			ps.setInt(3, emp.getEmpId());

			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (ClassNotFoundException e) {

			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {

			throw new CommercialCustRegException("Employee Deactivation failed");
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
		}
		return flag;
	}

	@Override
	public boolean activate(int empId) throws CommercialCustRegException {
		try {
			con = ConnectionUtil.getConnection();
		} catch (ClassNotFoundException e) {

			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee activation Problem");

		}
		try {
			ps = con
					.prepareStatement("Update EMPLOYEE set DATE_OF_LEAVING=to_date(?,'yyyy/mm/dd'),REASON_FOR_LEAVING=?,STATUS=? where EMP_ID=?");
			ps.setString(1, null);
			ps.setString(2, null);
			ps.setString(3, "working");
			ps.setInt(4, empId);
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new CommercialCustRegException("Connection Problem");
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
		}
		return flag;
	}

	/*// Search Employee By Name
	public List<Employee> searchByNameDB(String name)
			throws CommercialCustRegException {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("Select * from EMPLOYEE where FIRST_NAME LIKE '%"
							+ name + "%' OR LAST_NAME=? OR FIRST_NAME=?");
			ps.setString(1, name);
			ps.setString(2, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setFirstNm(rs.getString(3));
				emp.setLastNm(rs.getString(5));
				emp.setDesignation(rs.getString(11));

				empList.add(emp);
			}

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee details not found");
		}

		return empList;
	}

	// Search Employee By Id
	public List<Employee> searchByIdDB(int empId)
			throws CommercialCustRegException {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("Select * from EMPLOYEE where EMP_ID=?");
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setFirstNm(rs.getString(3));
				emp.setLastNm(rs.getString(5));
				emp.setDesignation(rs.getString(11));

				empList.add(emp);
			}

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee details not found");
		}

		return empList;
	}*/

	public Employee getEmpDetailsDB(int empId)
			throws CommercialCustRegException {
		Employee emp = new Employee();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("Select EMPLOYEE.EMP_ID,FIRST_NAME,DESIGNATION,PASSWORD FROM EMPLOYEE LEFT JOIN LOGIN ON EMPLOYEE.EMP_ID=LOGIN.EMP_ID WHERE EMPLOYEE.EMP_ID=? AND EMPLOYEE.STATUS IN('working','Leave')");

			ps.setInt(1, empId);
			rs = ps.executeQuery();

			while (rs.next()) {

				emp.setEmpId(rs.getInt(1));
				emp.setFirstNm(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				emp.setPassword(SecurePassword.decrypt(rs.getString(4)));
				System.out.println("P"+emp.getEmpId());
				System.out.println(emp.getPassword());
				
			}

		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee details not found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	// Change password
	public boolean changePasswd(Employee emp) throws CommercialCustRegException {
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("Update Login set password=?,SECURITY_QUESTION=?,SECURITY_ANSWER=? where EMP_ID=?");
			ps.setString(1, SecurePassword.encrypt(emp.getPassword()));
			ps.setString(2, emp.getSecurityQues());
			ps.setString(3, emp.getAnswer());
			ps.setInt(4, emp.getEmpId());

			i = ps.executeUpdate();

			if (i > 0)
				flag = true;
			else
				flag = false;
		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Problem in password change");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

		}

		return flag;

	}

	public Employee accessSecuQuesDB(int empId)
			throws CommercialCustRegException {
		Employee emp =null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("Select LOGIN.*,TO_CHAR(EMPLOYEE.DATE_OF_BIRTH,'yyyy/mm/dd') from LOGIN INNER JOIN EMPLOYEE ON EMPLOYEE.EMP_ID=LOGIN.EMP_ID where LOGIN.EMP_ID=?");
			ps.setInt(1, empId);

			rs = ps.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setSecurityQues(rs.getString(3));
				emp.setAnswer(rs.getString(4));
				emp.setDateOfBirth(rs.getString(5));
				
			}
			
		} catch (ClassNotFoundException e) {
			throw new CommercialCustRegException("Connection Problem");
		} catch (SQLException e) {
			throw new CommercialCustRegException("Employee does not exist");
		}
		finally {
			try {
				ConnectionUtil.closePreparedStatement(ps);
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				throw new CommercialCustRegException("Connection Problem");
			}

		}

		return emp;
	}

	@Override
	public boolean resetEmpPassword(Employee emp) throws CommercialCustRegException {
	
			try {
				con = ConnectionUtil.getConnection();
			ps=con.prepareStatement("UPDATE LOGIN SET PASSWORD=?,SECURITY_QUESTION=?,SECURITY_ANSWER=? WHERE EMP_ID=?");
				
				ps.setString(1, SecurePassword.encrypt(emp.getPassword()));
				ps.setString(2, "");
				ps.setString(3, "");
				ps.setInt(4, emp.getEmpId());
				i = ps.executeUpdate();
				if (i > 0)
					flag = true;
				else
					flag = false;
				
			} catch (SQLException e) {
				throw new CommercialCustRegException("Password reset failed");
			}
			catch (ClassNotFoundException e) {
				throw new CommercialCustRegException("Connection Problem");
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					ConnectionUtil.closePreparedStatement(ps);
					ConnectionUtil.closeConnection(con);
				} catch (SQLException e) {
					throw new CommercialCustRegException("Connection Problem");
				}

			}
			return flag;
		
	}

}
