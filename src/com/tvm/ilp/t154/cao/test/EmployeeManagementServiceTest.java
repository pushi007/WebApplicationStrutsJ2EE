/**
 * 
 */
package com.tvm.ilp.t154.cao.test;

import java.util.ArrayList;
import java.util.List;

import com.tvm.ilp.t154.cao.dao.EmployeeDAO;
import com.tvm.ilp.t154.cao.dao.EmployeeDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Employee;

import junit.framework.TestCase;

/**
 * @author 589964
 * 
 */
public class EmployeeManagementServiceTest extends TestCase {
	boolean flag = true;
	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#registerEmployee(com.tvm.ilp.t154.cao.model.Employee)}
	 * .
	 */
	public void testRegisterEmployee() {
		Employee emp=new Employee();
		EmployeeDAO empDao = new EmployeeDAOImpl();
		
		emp.setTitle("Mr");
		emp.setFirstNm("Shradha");
		emp.setMiddleNm("");
		emp.setLastNm("Pote");
		emp.setDateOfBirth("1989/03/02");
		emp.setAddress("Nagpur");
		emp.setContactno(Long.parseLong("7458768948"));
		emp.setAltContactNo(Long.parseLong("5684588859"));
		emp.setEmailId("shradh.pote@gmail.com");
		emp.setDateOfJoin("2012/04/24");
		emp.setDesignation("Help Desk Employee");
		emp.setStatus("working");
		emp.setBranchName("Wales");

		List<String> group = new ArrayList<String>();
		group.add("CAOHDesk");
		emp.setGroups(group);
		
		try {
			assertNotSame(0,empDao.addEmployee(emp));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#viewEmployees()}
	 * .
	 */
	public void testViewEmployees() {
		EmployeeDAO empDao = new EmployeeDAOImpl();
		try {
			assertNotNull(empDao.viewEmployee());
		} catch (CommercialCustRegException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#searchEmpDetails(int)}
	 * .
	 */
	public void testSearchEmpDetails() {
		EmployeeDAOImpl empDaoImpl = new EmployeeDAOImpl();
		int empId = 100017;
		try {
			assertNotNull(empDaoImpl.searchDetails(empId));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#getDesignation()}
	 * .
	 */
	public void testGetDesignation() {
		EmployeeDAOImpl empDaoImpl = new EmployeeDAOImpl();

		try {
			assertNotNull(empDaoImpl.getDesigFromDB());

		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#updateEmployee(com.tvm.ilp.t154.cao.model.Employee)}
	 * .
	 */
	public void testUpdateEmployee() {
		Employee emp = new Employee();
		EmployeeDAO empDao = new EmployeeDAOImpl();
	
		emp.setEmpId(100017);

		emp.setTitle("Ms");
		emp.setFirstNm("Priyanka");
		emp.setMiddleNm("Arun");
		emp.setLastNm("Pawar");
		emp.setDateOfBirth("1989/02/09");
		emp.setAddress("Karad");
		emp.setContactno(Long.parseLong("3654767883"));
		emp.setAltContactNo(Long.parseLong("6578575785"));

		emp.setEmailId("priyanka@gmail.com");
		emp.setDateOfJoin("2012/12/12");
		emp.setDesignation("Admin");
		emp.setStatus("working");
		emp.setBranchName("Derby");

		List<String> group = new ArrayList<String>();
		group.add("Admin");
		group.add("CAOProd");
		emp.setGroups(group);

		try {
			assertEquals(flag, empDao.updateEmpInDB(emp));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#getBranchNames()}
	 * .
	 */
	public void testGetBranchNames() {
		EmployeeDAOImpl empDaoImpl = new EmployeeDAOImpl();

		try {
			assertNotNull(empDaoImpl.getBranchFromDB());

		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#deactivateEmp(com.tvm.ilp.t154.cao.model.Employee)}
	 * .
	 */
	public void testDeactivateEmp() {
		Employee emp = new Employee();
		EmployeeDAO empDao = new EmployeeDAOImpl();
		
		emp.setEmpId(100018);
		emp.setDateOfLeave("2013/01/02");
		emp.setReasonOfLeave("holiday");
		emp.setStatus("Leave");
		try {
			assertEquals(flag,empDao.deactivateEmpDB(emp));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#activateEmp(int)}
	 * .
	 */
	public void testActivateEmp() {
		int empId=100018;
		EmployeeDAO empDao = new EmployeeDAOImpl();
		try {
			assertEquals(flag,empDao.activate(empId));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#changePwd(com.tvm.ilp.t154.cao.model.Employee)}
	 * .
	 */
	public void testChangePwd() {
		EmployeeDAOImpl empDaoImpl = new EmployeeDAOImpl();
		Employee emp=new Employee();
		
		emp.setEmpId(100018);
		emp.setPassword("Sunita@12");
		emp.setSecurityQues("What was the last name of your third grade teacher?");
		emp.setAnswer("Ms Minakshi");
		
		try {
			assertEquals(flag,empDaoImpl.changePasswd(emp));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.tvm.ilp.t154.cao.services.EmployeeManagementService#resetPassword(com.tvm.ilp.t154.cao.model.Employee)}
	 * .
	 */
	public void testResetPassword() {
		Employee emp=new Employee();
		EmployeeDAO empDao = new EmployeeDAOImpl();
		emp.setPassword("100018_1989/03/12");
		emp.setEmpId(100018);
		try {
			assertEquals(flag,empDao.resetEmpPassword(emp));
		} catch (CommercialCustRegException e) {
			e.printStackTrace();
		}
	}

}
