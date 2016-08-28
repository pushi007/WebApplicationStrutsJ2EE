package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.AddressDetails;
import com.tvm.ilp.t154.cao.model.NonPersonalAccount;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.model.Product;
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;

public class AccountCreationDAO {

	public boolean addBusinessCustAccount(NonPersonalAccount npa)
			throws AccountCreationException {
		int j = 1;
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		// ps=con.prepareStatement("insert into non_personal_account(account_number,np_id,product_Id,status,account_open_date,account_close_date) values(?,?,?,?,?,'2013-02-03','2012-03-04')");
		try {

			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("insert into NON_PERSONAL_ACCOUNT values(?,?,?,?,?, sysdate, null,?)");

			ps.setLong(1, npa.getAccNumber());
			ps.setInt(2, npa.getNpId());
			ps.setString(3, npa.getAccountType());
			ps.setLong(4, npa.getProductId());
			ps.setString(5, npa.getStatus());
			ps.setString(6, npa.getBranch());
			int i = ps.executeUpdate();

			if (i > 0)
				flag = true;
			else
				flag = false;
			j++;
		} catch (SQLException e) {
			throw new AccountCreationException(
					"Record not inserted into the database");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Record not inserted into the database");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}
		return flag;
	}

	public Product getProductName(long pid) throws AccountCreationException {

		Connection con = null;
		PreparedStatement ps = null;

		Product p = new Product();
		p.setProductID(pid);
		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select product_name from product where product_id=?");

			ps.setLong(1, pid);

			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {

				p.setProductName(rs.getString(1));

			}

		} catch (SQLException e) {
			throw new AccountCreationException(
					"Products are not retrived from database");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Products are not retrived from database");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}

		return p;
	}

	public int getAccounts(String AccountType, long npid)
			throws AccountCreationException {

		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		List<NonPersonalAccount> aList = new ArrayList<NonPersonalAccount>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select * from NON_PERSONAL_ACCOUNT where np_id=? and accounttype_name=?");

			ps.setLong(1, npid);
			ps.setString(2, AccountType);

			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				NonPersonalAccount np = new NonPersonalAccount();

				np.setAccNumber(rs.getLong(1));
				np.setAccountType(rs.getString(3));
				aList.add(np);

			}
			count = aList.size();

		} catch (SQLException e) {
			throw new AccountCreationException(
					"Products are not retrived from database");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Products are not retrived from database");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}

		return count;
	}

	/*
	 * public String get businessName(int npid) {
	 * 
	 * 
	 * Connection con=null; PreparedStatement ps=null; NonPersonalAccount
	 * npa=new NonPersonalAccount(); String name;
	 * 
	 * 
	 * try { con=ConnectionUtil.getConnection();
	 * 
	 * ps=con.prepareStatement(
	 * "select business_name from NON_PERSONAL_PARTY where np_id=?");
	 * ps.setInt(1, npid);
	 * 
	 * ResultSet rs=ps.executeQuery();
	 * 
	 * while(rs.next()) {
	 * 
	 * 
	 * }
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }finally{
	 * 
	 * 
	 * 
	 * ConnectionUtil.closeConnection(con); ConnectionUtil.closeStatement(ps); }
	 * 
	 * 
	 * return name;
	 * 
	 * }
	 */

	public List<Product> sortProductPem(String AccountType, String BusinessName)
			throws AccountCreationException {

		Connection con = null;
		PreparedStatement ps = null;
		List<Product> pList = new ArrayList<Product>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select p.product_id,p.product_name from PRODUCT p inner join PRODUCT_BUSINESS pb on p.product_id=pb.product_id where p.account_type=? and pb.businesstype_name=?");
			ps.setString(1, AccountType);
			ps.setString(2, BusinessName);

			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				Product p = new Product();
				p.setProductID(rs.getLong(1));
				p.setProductName(rs.getString(2));
				pList.add(p);
			}

		} catch (SQLException e) {
			throw new AccountCreationException(
					"Product are not get sorted error from database tables");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Product are not get sorted error from database tables");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}

		return pList;
	}

	public int getProductID(String name) throws AccountCreationException {
		int pid = 0;
		Connection con = null;
		PreparedStatement ps = null;
		Product p = new Product();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select PRODUCT_ID from PRODUCT where PRODUCT_NAME=?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next())

				pid = rs.getInt(1);

		} catch (SQLException e) {
			throw new AccountCreationException(
					"Product ID not selected properly");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Product ID not selected properly");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}
		return pid;
	}

	public NonPersonalAccount getSummary(long accNo)
			throws AccountCreationException {

		Connection con = null;
		PreparedStatement ps = null;
		NonPersonalAccount npa = new NonPersonalAccount();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select * from NON_PERSONAL_ACCOUNT where ACCOUNT_NUMBER=?");
			ps.setLong(1, accNo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				npa.setAccNumber(rs.getLong(1));
				npa.setNpId(rs.getInt(2));
				npa.setAccountType(rs.getNString(3));
				npa.setProductId(rs.getInt(4));
				npa.setStatus(rs.getString(5));

			}

		} catch (SQLException e) {
			throw new AccountCreationException(
					"Non personal party details not found in the database");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Non personal party details not found in the database");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}
		return npa;
	}

	public List<Product> getProduct() throws AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;

		List<Product> pList = new ArrayList<Product>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select product_id,product_name from Product");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setProductID(rs.getLong(1));

				p.setProductName(rs.getString(2));

				pList.add(p);
			}

		} catch (SQLException e) {
			throw new AccountCreationException(
					"Error in retriving the product from database");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException(
					"Error in retriving the product from database");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}
		return pList;

	}

	public long getAccountNumber() throws AccountCreationException {

		Connection con = null;
		// PreparedStatement ps=null;
		PreparedStatement ps1 = null;
		long accNo = 220000000;

		try {
			con = ConnectionUtil.getConnection();

			/*
			 * ps=con.prepareStatement("CREATE sequence SEQUENCE start with 25000000000000 INCREMENT BY 427 CACHE 10;"
			 * ); ps.executeUpdate();
			 */

			ps1 = con.prepareStatement("select sequence2.nextval from dual");
			ResultSet rs = ps1.executeQuery();

			if (rs.next())
				accNo = rs.getLong(1);

		} catch (SQLException e) {
			throw new AccountCreationException("Account Number not generated");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Account Number not generated");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps1);
			} catch (SQLException e) {
				throw new AccountCreationException("Connection problem.");
			}

		}

		return 1 + accNo;
	}

	public NonPersonalCustomer genarateReportbyBuisName(int npId) {
		Connection con = null;
		PreparedStatement ps = null;
		NonPersonalAccount npAccount = null;
		NonPersonalCustomer npCustomer = new NonPersonalCustomer();
		npCustomer.setBusinessId(npId);
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select NP_ID, ACCOUNTTYPE_NAME, STATUS FROM NON_PERSONAL_ACCOUNT  WHERE NP_ID=?");
			ps.setInt(1, npId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				npAccount = new NonPersonalAccount();

				npAccount.setAccountType(rs.getString(2));
				npAccount.setStatus(rs.getString(3));
				npCustomer.getAccountList().add(npAccount);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return npCustomer;
	}
	public NonPersonalCustomer genarateReportbyMonthAndBuisName(String month) {
		Connection con = null;
		PreparedStatement ps = null;
		NonPersonalAccount npAccount = null;
		NonPersonalCustomer npCustomer = new NonPersonalCustomer();
	
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select NP_ID, ACCOUNTTYPE_NAME, STATUS FROM NON_PERSONAL_ACCOUNT  WHERE TO_CHAR(ACCOUNT_OPEN_DATE,'yyyy')='"+month +"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				npAccount = new NonPersonalAccount();

				npAccount.setAccountType(rs.getString(2));
				npAccount.setStatus(rs.getString(3));
				npCustomer.getAccountList().add(npAccount);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return npCustomer;
	}
	public NonPersonalCustomer genarateReportbyBuisNameAndYear(String month, String year) {
		Connection con = null;
		PreparedStatement ps = null;
		NonPersonalAccount npAccount = null;
		NonPersonalCustomer npCustomer = new NonPersonalCustomer();
	
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select NP_ID, ACCOUNTTYPE_NAME, STATUS FROM NON_PERSONAL_ACCOUNT  WHERE TO_CHAR(ACCOUNT_OPEN_DATE,'mm')='"+month +"'AND TO_CHAR(ACCOUNT_OPEN_DATE,'yyyy')='"+year+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				npAccount = new NonPersonalAccount();

				npAccount.setAccountType(rs.getString(2));
				npAccount.setStatus(rs.getString(3));
				npCustomer.getAccountList().add(npAccount);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return npCustomer;
	}
	
	public List<NonPersonalCustomer> getCustomerNameAndId(){
		Connection con=null;
		PreparedStatement ps=null;
		List<NonPersonalCustomer> npCustomerList=new ArrayList<NonPersonalCustomer>();
		NonPersonalCustomer npCustomer=null;
		try {
			
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement("select  DISTINCT(NON_PERSONAL_PARTY.NP_ID), BUSINESS_NAME from NON_PERSONAL_PARTY inner join NON_PERSONAL_ACCOUNT on NON_PERSONAL_PARTY.NP_ID=NON_PERSONAL_ACCOUNT.NP_ID");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				npCustomer=new NonPersonalCustomer();
				npCustomer.setBusinessName(rs.getString(2));
				npCustomer.setBusinessId(rs.getLong(1));
				npCustomerList.add(npCustomer);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return npCustomerList;
		
	}
}
