/**
 * 
 */
package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.*;
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;

/**
 * @author 589768
 * 
 */
public class SearchRelationshipManagerDao {


	public List<NonPersonalParty> searchBusinessDetails(String businessName)
			throws  AccountCreationException {
		List<NonPersonalParty> nlist = new ArrayList<NonPersonalParty>();
		NonPersonalParty nonpersonal;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();

			ps = con.prepareStatement("select np_id,business_name,trading_name,business_type,rm_assigned from non_personal_party where business_name LIKE ?");
			


			ps.setString(1, businessName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				nonpersonal = new NonPersonalParty();
				nonpersonal.setNonPersonalId(rs.getInt(1));
				nonpersonal.setBusinessName(rs.getString(2));
				nonpersonal.setTradingName(rs.getString(3));
				nonpersonal.setBusinessType(rs.getString(4));
				nonpersonal.setRmAssigned(rs.getLong(5));
				nlist.add(nonpersonal);
			}

	
			
		} catch (SQLException e) {
			throw new AccountCreationException("Business Details not found");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Business Details not found");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			}
				
			 catch (SQLException e) {
				 throw new AccountCreationException("Error in database connection");
			 }
		}

		return nlist;
	}

	public List<NonPersonalParty> search(String tradingName) throws AccountCreationException
			{
		List<NonPersonalParty> npplist = new ArrayList<NonPersonalParty>();
		NonPersonalParty nonpersonal;
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			con = ConnectionUtil.getConnection();
			ps = con

					.prepareStatement("select np_id,business_name,trading_name,business_type,rm_assigned from non_personal_party where trading_name LIKE ?");
			ps.setString(1,tradingName);


			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nonpersonal = new NonPersonalParty();
				nonpersonal.setNonPersonalId(rs.getInt(1));
				nonpersonal.setBusinessName(rs.getString(2));
				nonpersonal.setTradingName(rs.getString(3));
				nonpersonal.setBusinessType(rs.getString(4));
				nonpersonal.setRmAssigned(rs.getLong(5));
				npplist.add(nonpersonal);
			}

		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Trading Name not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Trading Name not found");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				throw new AccountCreationException("Error in database connection");
			}
			
		}

		return npplist;

	}

	public NonPersonalParty searchNPParty(String businessName, int npId)
			throws  AccountCreationException {
		NonPersonalParty npp = new NonPersonalParty();
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select np_id,business_name,trading_name,branch_id,rm_assigned from non_personal_party where business_name=? and np_id=?");
			ps.setString(1, businessName);
			ps.setInt(2, npId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				npp.setNonPersonalId(rs.getInt(1));
				npp.setBusinessName(rs.getString(2));
				npp.setTradingName(rs.getString(3));
				npp.setBranchId(rs.getString(4));
				npp.setRmAssigned(rs.getInt(5));

			}

		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Business Details not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Business Details not found");
		} finally {
			try {
				ConnectionUtil.closeConnection(con);
				ConnectionUtil.closePreparedStatement(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new AccountCreationException("Error in database connection");
			}
			
		}

		return npp;
	}

	public NonPersonalParty searchNP( int npId)
			throws  AccountCreationException {
		NonPersonalParty npp = new NonPersonalParty();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select np_id,business_name,trading_name,branch_id,rm_assigned from non_personal_party where  np_id=?");
			//ps.setString(1, tradingName);
			ps.setInt(1, npId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				npp.setNonPersonalId(rs.getInt(1));
				npp.setBusinessName(rs.getString(2));
				npp.setTradingName(rs.getString(3));
				npp.setBranchId(rs.getString(4));
				npp.setRmAssigned(rs.getInt(5));

			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Business details not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Business details not found");
		} finally {
			try{
		
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return npp;

	}
	
	
	
	
    public NonPersonalParty searchTrading(String businessName) throws  AccountCreationException{
	NonPersonalParty npp=new NonPersonalParty();
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con = ConnectionUtil.getConnection();
		ps = con
				.prepareStatement("select trading_name from non_personal_party where business_name= ?");
		ps.setString(1, businessName);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{npp.setTradingName(rs.getString(1));
		}
	}

	 catch (SQLException e) {
		 throw new AccountCreationException("Trading Name not found");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		throw new AccountCreationException("Trading Name not found");
	} finally { try{
		ConnectionUtil.closeConnection(con);
		ConnectionUtil.closePreparedStatement(ps);
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountCreationException("Error in database connection");
	}
	}
	return npp;
}




	public NonPersonalParty searchNPersonal(int npId) throws  AccountCreationException {
		NonPersonalParty npp = new NonPersonalParty();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select np_id,business_name,trading_name,branch_id,rm_assigned from non_personal_party where  np_id=?");

			ps.setInt(1, npId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				npp.setNonPersonalId(rs.getInt(1));
				npp.setBusinessName(rs.getString(2));
				npp.setTradingName(rs.getString(3));
				npp.setBranchId(rs.getString(4));
				npp.setRmAssigned(rs.getInt(5));

			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Business customer not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Business customer not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}

		return npp;

	}

	public Branch searchBranchName(String branchId)
			throws  AccountCreationException {
		Branch b = new Branch();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select branch_name from branch where branch_id=?");
			ps.setString(1, branchId);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				b.setBranchName(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Branch name not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Branch name not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return b;

	}

	public Branch searchBranchID(String branchName)
			throws  AccountCreationException {
		Branch b = new Branch();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select branch_id from branch where branch_name=?");
			ps.setString(1, branchName);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				b.setBranchId(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Branch ID not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Branch ID not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return b;

	}

	public RelationshipManager getEmployeeId(String lastName)
			throws  AccountCreationException {
		RelationshipManager rm = new RelationshipManager();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select emp_id from EMPLOYEE ");

			ps.setString(1, lastName);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				rm.setRmId(rs.getInt(1));
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Relationship Manager not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Relationship Manager not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return rm;

	}

	// Retrieve list of Relationship Manager for particular branch
	public ArrayList<RelationshipManager> listOfManager(String designation,
			String branchId) throws AccountCreationException  {
		ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select EMP_ID,TITLE,FIRST_NAME,LAST_NAME from EMPLOYEE where DESIGNATION=? and BRANCH_ID=?");
			ps.setString(1, designation);
			ps.setString(2, branchId);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				RelationshipManager rm = new RelationshipManager();
				rm.setRmId(rs.getInt(1));
				rm.setTitle(rs.getString(2));
				rm.setFirstName(rs.getString(3));
				rm.setLastName(rs.getString(4));

				rmList.add(rm);
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Relationship Manager not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Relationship Manager not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return rmList;
	}

	public boolean update(NonPersonalParty npp) throws  AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("update  non_personal_party set rm_assigned=? where np_id =?");
			ps.setLong(1, npp.getRmAssigned());
			ps.setInt(2, npp.getNonPersonalId());

			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;

			}

		}

		catch (ClassNotFoundException e) {
			throw new AccountCreationException("Relationship Manager not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Relationship Manager not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}

		return flag;
	}

	public boolean addEntries(int rmassigned, int npid, String branchID)
			throws  AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
		NonPersonalParty npp = new NonPersonalParty();
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("update NON_PERSONAL_PARTY set rm_assigned=? where np_id=? and branch_id=?");
			ps.setLong(1, rmassigned);
			ps.setInt(2, npid);
			ps.setString(3, branchID);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;

			}

		}

		catch (ClassNotFoundException e) {
			throw new AccountCreationException("Employee not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Employee not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return flag;
	}

	// Retrieving Branch
	public List<Branch> getBranch() throws  AccountCreationException {
		List<Branch> blist = new ArrayList<Branch>();
		Branch b;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select branch_id,branch_name from branch");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Branch();
				b.setBranchId(rs.getString(1));
				b.setBranchName(rs.getString(2));
				blist.add(b);

			}

		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Branch not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Branch not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return blist;
	}

	public RelationshipManager searchName(long rmassigned) throws  AccountCreationException {
		RelationshipManager rm = new RelationshipManager();
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select emp_id,branch_id,title,first_name,last_name from EMPLOYEE where emp_id=?");
			ps.setLong(1, rmassigned);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rm.setRmId(rs.getInt(1));
				rm.setBranchId(rs.getString(2));
				rm.setTitle(rs.getString(3));
				rm.setFirstName(rs.getString(4));
				rm.setLastName(rs.getString(5));
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Name of Manager not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Name of Manager not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}

		return rm;

	}

	public Branch searchId(String branchName) throws AccountCreationException  {
		Branch b = new Branch();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("Select branch_id from branch where branch_name=?");
			ps.setString(1, branchName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				b.setBranchId(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Branch Name not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Branch Name not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return b;
	}
	

	public boolean addEntry(long rmassigned, int npid) throws  AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<RelationshipManager> rmList = new ArrayList<RelationshipManager>();
		NonPersonalParty npp = new NonPersonalParty();
		boolean flag = false;
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("update NON_PERSONAL_PARTY set rm_assigned=? where np_id=?");
			ps.setLong(1, rmassigned);
			ps.setInt(2, npid);

			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;

			}

		}

		catch (ClassNotFoundException e) {
			throw new AccountCreationException("Employee not found");
		} catch (SQLException e) {
			throw new AccountCreationException("Employee not found");
		} finally {try{
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountCreationException("Error in database connection");
		}
		}
		return flag;
	}


	
public NonPersonalParty getBusinessDetails(int npid) throws  AccountCreationException{
	NonPersonalParty npp=new NonPersonalParty();
	Connection con=null;
	PreparedStatement ps=null;
	try{con = ConnectionUtil.getConnection();
	ps = con
	.prepareStatement("select business_name,trading_name from NON_Personal_Party where np_id=?");
	
	ps.setInt(1,npid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		npp.setBusinessName(rs.getString(1));
		npp.setTradingName(rs.getString(2));
		}
	
	}catch (ClassNotFoundException e) {
		throw new AccountCreationException("Business details not found");
	} catch (SQLException e) {
		throw new AccountCreationException("Business details not found");
	} finally {try{
		ConnectionUtil.closeConnection(con);
		ConnectionUtil.closePreparedStatement(ps);
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountCreationException("Error in database connection");
	}
	}
	
	return npp;
} 

}
