package com.tvm.ilp.t154.cao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tvm.ilp.t154.cao.exceptions.AccountCreationException;
import com.tvm.ilp.t154.cao.model.AddressDetails;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessCustomer;
import com.tvm.ilp.t154.cao.utils.ConnectionUtil;

public class SearchCustomerDAO {

	ArrayList<BusinessCustomer> custList = new ArrayList<BusinessCustomer>();
	ArrayList<String> brList = new ArrayList<String>();

	
public AddressDetails getAddressDetails(long npid) throws AccountCreationException {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		AddressDetails ad=new AddressDetails();
		
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select * from NP_ADDRESS ad join np_contacts cont on ad.np_party_id=cont.np_party_id where ad.np_party_id=? and ad.address_type='Business' and cont.contact_type='Work'");
			ps.setLong(1, npid);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				ad.setNp_id(rs.getLong(1));
				ad.setBuildingNo(rs.getString(2));
				ad.setBuildingName(rs.getString(3));
				ad.setStreetName(rs.getString(4));
				ad.setCityName(rs.getString(5));
				ad.setTownName(rs.getString(6));
				ad.setCountry(rs.getString(7));
				ad.setPostalCode(rs.getString(8));
				ad.setCountryCode(rs.getString(11));
				ad.setAreaCode(rs.getString(12));
				ad.setContactNumber(rs.getLong(13));
				
				
				
			}
		} catch (SQLException e) {
			throw new AccountCreationException("Address details not present");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Address details not present");
		}finally{	try {
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem.");
		}
			

		}

	
		return ad;
	}

	
	
	public ArrayList<Branch> getBranchList() throws AccountCreationException {

		Connection con = null;
		PreparedStatement ps = null;

		ArrayList<Branch> bList = new ArrayList<Branch>();

		try {
			con = ConnectionUtil.getConnection();

			ps = con
					.prepareStatement("select branch_id,branch_name from branch");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Branch b = new Branch();
				b.setBranchId(rs.getString(1));
				b.setBranchName(rs.getString(2));
				bList.add(b);
			}

		} catch (SQLException e) {
			throw new AccountCreationException("Address details not present");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Address details not present");
		}finally{	try {
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem.");
		}
			

		}

		return bList;

	}

	public ArrayList<BusinessCustomer> searchByBusiness(String businessName,
			String branch) throws AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;

		ArrayList<BusinessCustomer> bclist = new ArrayList<BusinessCustomer>();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select np.business_name,np.trading_name,b.branch_name,np.email_address,np.business_type,np.np_id,np.country_of_registration from non_personal_party np join branch b on np.branch_id=b.branch_id where np.business_name LIKE ? and b.branch_name=?");
			ps.setString(1, businessName);
			ps.setString(2, branch);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				BusinessCustomer bc = new BusinessCustomer();

				bc.setBusinessName(rs.getString(1));
				bc.setTradingName(rs.getString(2));
				bc.setBranchName(rs.getString(3));
				bc.setEmail(rs.getString(4));
				bc.setBusinessType(rs.getString(5));
				bc.setNpId(rs.getLong(6));
				bc.setCountry(rs.getString(7));
				bclist.add(bc);

			}
		} catch (SQLException e) {
			throw new AccountCreationException("Address details not present");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Address details not present");
		}finally{	try {
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem.");
		}
			

		}
		
		return bclist;
	}

	public ArrayList<BusinessCustomer> searchByTrading(String tradingName,
			String branch) throws AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;

		ArrayList<BusinessCustomer> bclist = new ArrayList<BusinessCustomer>();
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select np.business_name,np.trading_name,b.branch_name,np.email_address,np.business_type,np.np_id,np.country_of_registration from non_personal_party np join branch b on np.branch_id=b.branch_id where np.trading_name LIKE ? and b.branch_name=?");
			ps.setString(1, tradingName);
			ps.setString(2, branch);
			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				BusinessCustomer bc = new BusinessCustomer();

				bc.setBusinessName(rs.getString(1));
				bc.setTradingName(rs.getString(2));
				bc.setBranchName(rs.getString(3));
				bc.setEmail(rs.getString(4));
				bc.setBusinessType(rs.getString(5));
				bc.setNpId(rs.getLong(6));
				bc.setCountry(rs.getString(7));
				bclist.add(bc);

			}
		} catch (SQLException e) {
			throw new AccountCreationException("Address details not present");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Address details not present");
		}finally{	try {
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem.");
		}
			

		}
		return bclist;

	}

	public BusinessCustomer searchByAccountNo(long accountNo)
			throws AccountCreationException {
		Connection con = null;
		PreparedStatement ps = null;
		BusinessCustomer bc = new BusinessCustomer();
		
		try {
			con = ConnectionUtil.getConnection();
			ps = con
					.prepareStatement("select np.business_name,np.trading_name,b.branch_name,np.email_address,np.business_type,np.np_id,np.country_of_registration from non_personal_party np join branch b on np.branch_id=b.branch_id join non_personal_account npa on np.np_id=npa.np_id where npa.account_number=?");
			ps.setLong(1, accountNo);

			ResultSet rs = ps.executeQuery();

			while (rs.next() != false) {
				

				bc.setBusinessName(rs.getString(1));
				bc.setTradingName(rs.getString(2));
				bc.setBranchName(rs.getString(3));
				bc.setEmail(rs.getString(4));
				bc.setBusinessType(rs.getString(5));
				bc.setNpId(rs.getLong(6));
				bc.setCountry(rs.getString(7));
			

			}
		} catch (SQLException e) {
			throw new AccountCreationException("Address details not present");
		} catch (ClassNotFoundException e) {
			throw new AccountCreationException("Address details not present");
		}finally{	try {
			ConnectionUtil.closeConnection(con);
			ConnectionUtil.closePreparedStatement(ps);
		} catch (SQLException e) {
			throw new AccountCreationException("Connection Problem.");
		}
			

		}
		return bc;

	}
}
