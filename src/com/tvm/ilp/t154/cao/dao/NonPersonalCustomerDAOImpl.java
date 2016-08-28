/**
 * 
 */
package com.tvm.ilp.t154.cao.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.tvm.ilp.t154.cao.utils.ConnectionUtil.getConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.Branch;
import com.tvm.ilp.t154.cao.model.BusinessType;
import com.tvm.ilp.t154.cao.model.Country;
import com.tvm.ilp.t154.cao.model.Customers;
import com.tvm.ilp.t154.cao.model.FileDetails;
import com.tvm.ilp.t154.cao.model.NPAddress;
import com.tvm.ilp.t154.cao.model.NPContacts;
import com.tvm.ilp.t154.cao.model.NPProofOfDocument;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import static com.tvm.ilp.t154.cao.utils.ConnectionUtil.*;

/**
 * @author 677791
 * 
 */
public class NonPersonalCustomerDAOImpl implements NonPersonalCustomerDAO
{
	long npID=0;

	@Override
	public boolean updateCustomer(NonPersonalCustomer customer)
			throws CommercialCustRegException {
		PreparedStatement psCustomer = null;
		PreparedStatement psAddresss = null;
		PreparedStatement psContact = null;
		PreparedStatement psProof = null;
		Connection con = null;
		boolean flag = false;

		int numRowsNPAddresss = 0;
		int numRowsNPContact = 0;

		int numRowsNPProof = 0;

		try {
			con = getConnection();

			psCustomer = con
					.prepareStatement("update NON_PERSONAL_PARTY set BUSINESS_NAME=?,TRADING_NAME=?,BUSINESS_TYPE=?,BRANCH_ID=?,IS_STARTUP_BUSINESS=?,COUNTRY_OF_REGISTRATION=? ,EXPECTED_ANNUAL_TURNOVER=?, CAPITAL_FUND=?,STATUS=? , NO_OF_EMPLOYEES=? , ABOUT_BUSINESS=?,FUNDING_REQUIRED=?, EMAIL_ADDRESS=?, FUND_AMOUNT=?, INDUSTRY_SECTOR=?, MAIN_ACTIVITY=?, PRECISE_ACTIVITY=?, IMPORT_EXPORT_GOODS=?, PART_GROUP_FRANCHISE=?, GROUP_FRANCHISE_DETAILS=?,DATE_ESTABLISHED=(to_date(?,'yyyy/mm/dd')), DATE_OF_REGISTRATION=(to_date(?,'yyyy/mm/dd')) where NP_ID=?");

			psCustomer.setString(1, customer.getBusinessName());
			psCustomer.setString(2, customer.getTradingName());
			psCustomer.setString(3, customer.getBusinessType());
			// psCustomer.setString(, customer.getBankBranchName());
			psCustomer.setString(4, customer.getBranch().getBranchId());
			// psCustomer.setString(, customer.getBankBranchAddress());
			psCustomer.setString(5, customer.getIsStartUpBusiness());
			// psCustomer.setString(, customer.getDateEstablished());
			// psCustomer.setString(, customer.getDateOfRegistration());
			psCustomer.setString(6, customer.getCountryOfRegistration());
			psCustomer.setDouble(7, customer.getExpectedAnnualTurnover());
			psCustomer.setDouble(8, customer.getTotalBusinessCapital());
			psCustomer.setString(9, customer.getBusinessStatus());
			psCustomer.setInt(10, customer.getNoOfEmployees());
			psCustomer.setString(11, customer.getTellMoreAboutYourBusiness());
			// psCustomer.setLong(12, npID);
			psCustomer.setString(12, customer.getRequireFunding());
			psCustomer.setString(13, customer.getEmail());
			psCustomer.setDouble(14, customer.getFundAmount());
			psCustomer.setString(15, customer.getIndustrySector());
			psCustomer.setString(16, customer.getMainActivity());
			psCustomer.setString(17, customer.getPreciseActivity());
			psCustomer.setString(18, customer.getImportExport());
			psCustomer.setString(19, customer.getPartOfGroup());
			psCustomer.setString(20, customer.getFranchiseDetails());

			psCustomer.setString(21, customer.getDateEstablished());
			psCustomer.setString(22, customer.getDateOfRegistration());
			psCustomer.setLong(23, customer.getBusinessId());

			int numRowsNonPersonalPArty = psCustomer.executeUpdate();

			for (NPAddress npAddress : customer.getNpAddressList()) {
				psAddresss = con
						.prepareStatement("update NP_ADDRESS set BUILDING_NO=?, BUILDING_NAME=?, STREET_NAME=?,CITY_NAME=?, TOWN_NAME=?, COUNTRY=?, POSTAL_CODE=? where NP_PARTY_ID=? and ADDRESS_TYPE=?");
				psAddresss.setString(1, npAddress.getBuildingNo());
				psAddresss.setString(2, npAddress.getBuildingName());
				psAddresss.setString(3, npAddress.getStreetName());
				psAddresss.setString(4, npAddress.getCity());
				psAddresss.setString(5, npAddress.getTown());
				psAddresss.setString(6, npAddress.getCountry());
				psAddresss.setString(7, npAddress.getPostalCode());

				psAddresss.setLong(8, customer.getBusinessId());
				psAddresss.setString(9, npAddress.getAddressType());
				numRowsNPAddresss = psAddresss.executeUpdate();
			}

			for (NPContacts npContacts : customer.getNpContactList()) {
				psContact = con
						.prepareStatement("update NP_CONTACTS set COUNTRY_CODE=?, AREA_CODE=?, CONTACT_NUMBER=? where NP_PARTY_ID=? and CONTACT_TYPE=?");
				psContact.setString(1, npContacts.getCountryCode());
				psContact.setString(2, npContacts.getAreaCode());
				psContact.setString(3, npContacts.getContactNo());

				psContact.setLong(4, customer.getBusinessId());
				psContact.setString(5, npContacts.getContactType());
				numRowsNPContact = psContact.executeUpdate();

			}
			
			if (numRowsNonPersonalPArty > 0 && numRowsNPAddresss > 0
					&& numRowsNPContact > 0 ) {

				flag = true;
			}
		} catch (SQLException sqe) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException ce) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}

		return flag;

	}

	public boolean addCustomer(NonPersonalCustomer customer)
			throws CommercialCustRegException {
		PreparedStatement psCustomer = null;
		PreparedStatement psAddresss = null;
		PreparedStatement psContact = null;
		PreparedStatement psProof = null;
		Connection con = null;
		boolean flag = false;
		ResultSet rs = null;
		int numRowsNPAddresss = 0;
		int numRowsNPContact = 0;

		int numRowsNPProof = 0;

		try {

			con = getConnection();

			psCustomer = con
					.prepareStatement("insert into NON_PERSONAL_PARTY(BUSINESS_NAME,TRADING_NAME,BUSINESS_TYPE,BRANCH_ID,IS_STARTUP_BUSINESS,COUNTRY_OF_REGISTRATION,EXPECTED_ANNUAL_TURNOVER,CAPITAL_FUND,STATUS,NO_OF_EMPLOYEES,ABOUT_BUSINESS,NP_ID,FUNDING_REQUIRED,EMAIL_ADDRESS,FUND_AMOUNT,INDUSTRY_SECTOR,MAIN_ACTIVITY,PRECISE_ACTIVITY,IMPORT_EXPORT_GOODS,PART_GROUP_FRANCHISE,GROUP_FRANCHISE_DETAILS,DATE_ESTABLISHED,DATE_OF_REGISTRATION) values(?,?,?,?,?,?,?,?,?,?,?,NP_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy/mm/dd'),to_date(?,'yyyy/mm/dd'))");

			psCustomer.setString(1, customer.getBusinessName());
			psCustomer.setString(2, customer.getTradingName());
			psCustomer.setString(3, customer.getBusinessType());
			// psCustomer.setString(, customer.getBankBranchName());
			psCustomer.setString(4, customer.getBranch().getBranchId());
			// psCustomer.setString(, customer.getBankBranchAddress());
			psCustomer.setString(5, customer.getIsStartUpBusiness());
			// psCustomer.setString(, customer.getDateEstablished());
			// psCustomer.setString(, customer.getDateOfRegistration());
			psCustomer.setString(6, customer.getCountryOfRegistration());
			psCustomer.setDouble(7, customer.getExpectedAnnualTurnover());
			psCustomer.setDouble(8, customer.getTotalBusinessCapital());
			psCustomer.setString(9, customer.getBusinessStatus());
			psCustomer.setInt(10, customer.getNoOfEmployees());
			psCustomer.setString(11, customer.getTellMoreAboutYourBusiness());
			// psCustomer.setLong(12, npID);
			psCustomer.setString(12, customer.getRequireFunding());
			psCustomer.setString(13, customer.getEmail());
			psCustomer.setDouble(14, customer.getFundAmount());
			psCustomer.setString(15, customer.getIndustrySector());
			psCustomer.setString(16, customer.getMainActivity());
			psCustomer.setString(17, customer.getPreciseActivity());
			psCustomer.setString(18, customer.getImportExport());
			psCustomer.setString(19, customer.getPartOfGroup());
			psCustomer.setString(20, customer.getFranchiseDetails());
			psCustomer.setString(21, customer.getDateEstablished());
			psCustomer.setString(22, customer.getDateOfRegistration());

			int numRowsNonPersonalPArty = psCustomer.executeUpdate();

			if (numRowsNonPersonalPArty > 0) {
				psCustomer = con
						.prepareStatement("Select NP_SEQUENCE.currval from dual");
				rs = psCustomer.executeQuery();
				while (rs.next()) {
					customer.setBusinessId((long) rs.getInt(1));
					npID=(long)rs.getInt(1);
				}

			}
			for (NPAddress npAddress : customer.getNpAddressList()) {
				psAddresss = con
						.prepareStatement("insert into NP_ADDRESS (BUILDING_NO, BUILDING_NAME, STREET_NAME,CITY_NAME, TOWN_NAME, COUNTRY, POSTAL_CODE, ADDRESS_TYPE, NP_PARTY_ID) values (?,?,?,?,?,?,?,?,?)");
				psAddresss.setString(1, npAddress.getBuildingNo());
				psAddresss.setString(2, npAddress.getBuildingName());
				psAddresss.setString(3, npAddress.getStreetName());
				psAddresss.setString(4, npAddress.getCity());
				psAddresss.setString(5, npAddress.getTown());
				psAddresss.setString(6, npAddress.getCountry());
				psAddresss.setString(7, npAddress.getPostalCode());
				psAddresss.setString(8, npAddress.getAddressType());
				psAddresss.setLong(9, customer.getBusinessId());

				numRowsNPAddresss = psAddresss.executeUpdate();
			}

			for (NPContacts npContacts : customer.getNpContactList()) {
				psContact = con
						.prepareStatement("insert into NP_CONTACTS (COUNTRY_CODE, AREA_CODE, CONTACT_NUMBER, CONTACT_TYPE, NP_PARTY_ID) values(?,?,?,?,?)");
				psContact.setString(1, npContacts.getCountryCode());
				psContact.setString(2, npContacts.getAreaCode());
				psContact.setString(3, npContacts.getContactNo());
				psContact.setString(4, npContacts.getContactType());
				psContact.setLong(5, customer.getBusinessId());
				numRowsNPContact = psContact.executeUpdate();

			}
			if (numRowsNonPersonalPArty > 0 && numRowsNPAddresss > 0
					&& numRowsNPContact > 0) {

				flag = true;
			}
		} catch (SQLException e) {

			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException ce) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}

		return flag;

	}

	@Override
	public boolean deleteCustomer(long customerId)
			throws CommercialCustRegException {

		PreparedStatement psCustomer = null;
		PreparedStatement psAddresss = null;
		PreparedStatement psContact = null;
		PreparedStatement psProof = null;
		Connection con = null;
		boolean flag = false;

		int numRowsNPAddresss = 0;
		int numRowsNPContact = 0;

		int numRowsNPProof = 0;

		try {

			con = getConnection();

			psAddresss = con
					.prepareStatement("delete from NP_ADDRESS where NP_PARTY_ID=?");
			psAddresss.setLong(1, customerId);
			numRowsNPAddresss = psAddresss.executeUpdate();

			psContact = con
					.prepareStatement("delete  from NP_CONTACTS where NP_PARTY_ID=?");
			psContact.setLong(1, customerId);

			numRowsNPContact = psContact.executeUpdate();

			psProof = con
					.prepareStatement("delete from NP_PROOF_OF_DOCUMENTS where NP_PARTY_ID=?");
			psProof.setLong(1, customerId);
			numRowsNPProof = psProof.executeUpdate();

			psCustomer = con
					.prepareStatement("delete from NON_PERSONAL_PARTY where NP_ID=?");
			psCustomer.setLong(1, customerId);

			int numRowsNonPersonalPArty = psCustomer.executeUpdate();

			if (numRowsNonPersonalPArty > 0 && numRowsNPAddresss > 0
					&& numRowsNPContact > 0 && numRowsNPProof > 0) {

				flag = true;
			}

		} catch (SQLException sqe) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException ce) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}

		return flag;

	}

	@Override
	public NonPersonalCustomer searchCustomer(int customerId)
			throws CommercialCustRegException {
		NonPersonalCustomer npCustomer = null;
		Connection con = null;
		PreparedStatement psCustomer = null;
		PreparedStatement psAddress = null;
		PreparedStatement psContacts = null;
		PreparedStatement psAccount = null;
		try {
			con = getConnection();
			psCustomer = con
					.prepareStatement("select * from NON_PERSONAL_PARTY where NP_ID=?");
			psAddress = con
					.prepareStatement("select * from NP_ADDRESS where  NP_PARTY_ID=?");
			psContacts = con
					.prepareStatement("select * from NP_CONTACTS where  NP_PARTY_ID=?");
			psAccount = con
					.prepareStatement("select ACCOUNT_NUMBER from NON_PERSONAL_ACCOUNT where NP_ID=?");
			psAccount.setLong(1, customerId);
			psContacts.setLong(1, customerId);
			psAddress.setLong(1, customerId);
			psCustomer.setLong(1, customerId);
			ResultSet rsCustomer = psCustomer.executeQuery();
			ResultSet rsAddress = psAddress.executeQuery();
			ResultSet rsContacts = psContacts.executeQuery();
			ResultSet rsAccount = psAccount.executeQuery();
			while (rsCustomer.next()) {
				npCustomer = new NonPersonalCustomer();
				npCustomer.setBusinessId(customerId);
				npCustomer.setBusinessName(rsCustomer.getString(2));
				npCustomer.setTradingName(rsCustomer.getString(3));
				npCustomer.setBusinessType(rsCustomer.getString(4));
				npCustomer.getBranch().setBranchId((rsCustomer.getString(5)));
				npCustomer.setIsStartUpBusiness(rsCustomer.getString(6));
				if (rsCustomer.getDate(7) != null) {
					npCustomer.setDateEstablished(rsCustomer.getDate(7)
							.toString().replace('-', '/'));
				} else {
					npCustomer.setDateEstablished("");

				}
				if (rsCustomer.getDate(8) != null) {
					npCustomer.setDateOfRegistration(rsCustomer.getDate(8)
							.toString().replace('-', '/'));
				} else {
					npCustomer.setDateOfRegistration("");
				}
				npCustomer.setExpectedAnnualTurnover(rsCustomer.getDouble(9));
				npCustomer.setTotalBusinessCapital(rsCustomer.getDouble(10));
				npCustomer.setBusinessStatus(rsCustomer.getString(11));

				npCustomer.setTellMoreAboutYourBusiness(rsCustomer
						.getString(12));
				npCustomer.setRequireFunding(rsCustomer.getString(13));
				if (rsCustomer.getString(14) != null) {
					npCustomer.setFundAmount(Double.parseDouble(rsCustomer
							.getString(14)));
				}
				npCustomer.setNoOfEmployees(rsCustomer.getInt(15));
				npCustomer.setCountryOfRegistration(rsCustomer.getString(16));
				npCustomer.setEmail(rsCustomer.getString(17));
				npCustomer.setIndustrySector(rsCustomer.getString(18));
				npCustomer.setMainActivity(rsCustomer.getString(19));
				npCustomer.setPreciseActivity(rsCustomer.getString(20));
				npCustomer.setImportExport(rsCustomer.getString(21));
				npCustomer.setPartOfGroup(rsCustomer.getString(22));
				npCustomer.setFranchiseDetails(rsCustomer.getString(23));
				while (rsAddress.next()) {
					NPAddress npAddress = new NPAddress();
					npAddress.setBuildingNo(rsAddress.getString(2));
					npAddress.setBuildingName(rsAddress.getString(3));
					npAddress.setStreetName(rsAddress.getString(4));
					npAddress.setCity(rsAddress.getString(5));
					npAddress.setTown(rsAddress.getString(6));
					npAddress.setCountry(rsAddress.getString(7));
					npAddress.setPostalCode(rsAddress.getString(8));
					npAddress.setAddressType(rsAddress.getString(9));

					npCustomer.getNpAddressList().add(npAddress);

				}
				while (rsContacts.next()) {
					NPContacts npContacts = new NPContacts();
					npContacts.setCountryCode(rsContacts.getString(2));
					npContacts.setAreaCode(rsContacts.getString(3));
					npContacts.setContactNo(rsContacts.getString(4));
					npContacts.setContactType(rsContacts.getString(5));
					npCustomer.getNpContactList().add(npContacts);

				}
			
				if (rsAccount.next()) {
					npCustomer.setHasAccount(true);
				}

			}
		} catch (SQLException e) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException ce) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
				closePreparedStatement(psContacts);
				closePreparedStatement(psAddress);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}
		return npCustomer;
	}

	@Override
	public List<NonPersonalCustomer> viewCustomer()
			throws CommercialCustRegException {
		List<NonPersonalCustomer> npList = new ArrayList<NonPersonalCustomer>();
		Connection con = null;
		PreparedStatement psCustomer = null;
		try {
			con = getConnection();
			psCustomer = con
					.prepareStatement("select NP_ID, BUSINESS_NAME,TRADING_NAME,BUSINESS_TYPE,NP.BRANCH_ID,B.BRANCH_NAME,B.BRANCH_ADDRESS,IS_STARTUP_BUSINESS,DATE_ESTABLISHED,DATE_OF_REGISTRATION,EXPECTED_ANNUAL_TURNOVER,CAPITAL_FUND,STATUS,ABOUT_BUSINESS,NO_OF_EMPLOYEES from NON_PERSONAL_PARTY NP left join BRANCH B on NP.BRANCH_ID=B.BRANCH_ID");
			ResultSet rs = psCustomer.executeQuery();

			while (rs.next()) {
				NonPersonalCustomer np = new NonPersonalCustomer();
				np.setBusinessId(rs.getLong("NP_ID"));
				np.setBusinessName(rs.getString("BUSINESS_NAME"));
				np.setTradingName(rs.getString("TRADING_NAME"));
				np.setBusinessType(rs.getString("BUSINESS_TYPE"));
				np.setIsStartUpBusiness(rs.getString("IS_STARTUP_BUSINESS"));
				np.setDateEstablished(rs.getString("DATE_ESTABLISHED"));
				np.setDateOfRegistration(rs.getString("DATE_OF_REGISTRATION"));
				np.setExpectedAnnualTurnover(rs
						.getInt("EXPECTED_ANNUAL_TURNOVER"));
				np.setTotalBusinessCapital(rs.getInt("CAPITAL_FUND"));
				np.setBusinessStatus(rs.getString("STATUS"));
				np.setNoOfEmployees(rs.getInt("NO_OF_EMPLOYEES"));
				np.getBranch().setBranchId((rs.getString("BRANCH_ID")));
				np.setMoreAboutBusiness(rs.getString("ABOUT_BUSINESS"));
				npList.add(np);

			}
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);

			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}
		return npList;

	}

	@Override
	public NonPersonalCustomer searchBusinessIdName(Long Bid, String Bname,
			String Bbranch) {

		NonPersonalCustomer np = new NonPersonalCustomer();
		Connection con = null;
		PreparedStatement psCustomer = null;
		np = null;
		try {

			con = getConnection();
			psCustomer = con
					.prepareStatement("select NP_ID,BUSINESS_NAME,TRADING_NAME,BUSINESS_TYPE,EXPECTED_ANNUAL_TURNOVER,STATUS,NO_OF_EMPLOYEES,COUNTRY_OF_REGISTRATION,EMAIL_ADDRESS,BRANCH_NAME from NON_PERSONAL_PARTY NP left join BRANCH B on NP.BRANCH_ID=B.BRANCH_ID WHERE NP_ID=? OR (BUSINESS_NAME=? AND BRANCH_NAME=?)");
			psCustomer.setLong(1, Bid);
			psCustomer.setString(2, Bname);
			psCustomer.setString(3, Bbranch);

			ResultSet rs = psCustomer.executeQuery();

			while (rs.next()) {
				np = new NonPersonalCustomer();
				np.setBusinessId(rs.getInt(1));
				np.setBusinessName(rs.getString(2));
				np.setTradingName(rs.getString(3));
				np.setBusinessType(rs.getString(4));
				np.setExpectedAnnualTurnover(rs.getInt(5));
				np.setBusinessStatus(rs.getString(6));
				np.setNoOfEmployees(rs.getInt(7));
				np.setCountryOfRegistration(rs.getString(8));
				np.setBusinessEmailAddress(rs.getString(9));
				np.getBranch().setBranchName(rs.getString(10));

			}
		} catch (SQLException se) {

		} catch (ClassNotFoundException cnfe) {

		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {

			}
		}

		return np;
	}

	@Override
	public List<Branch> getBranch() throws CommercialCustRegException {
		List<Branch> branchList = new ArrayList<Branch>();

		Connection con = null;
		PreparedStatement psCustomer = null;
		try {

			con = getConnection();

			psCustomer = con.prepareStatement("select * from BRANCH");

			ResultSet rs = psCustomer.executeQuery();

			while (rs.next()) {
				Branch branch = new Branch();
				branch.setBranchId(rs.getString(1));
				branch.setBranchName(rs.getString(2));
				branch.setBranchAddress(rs.getString(3));
				branchList.add(branch);

			}
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}

		return branchList;
	}

	@Override
	public List<BusinessType> getBusinessType()
			throws CommercialCustRegException {
		List<BusinessType> businessList = new ArrayList<BusinessType>();

		Connection con = null;
		PreparedStatement psCustomer = null;
		try {

			con = getConnection();

			psCustomer = con.prepareStatement("select * from BUSINESS_TYPES");

			ResultSet rs = psCustomer.executeQuery();

			while (rs.next()) {
				BusinessType businessType = new BusinessType();
				businessType.setBusinessType(rs.getString(1));
				businessList.add(businessType);

			}
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}
		return businessList;
	}

	@Override
	public List<Country> getCountry() throws CommercialCustRegException {
		List<Country> countryList = new ArrayList<Country>();

		Connection con = null;
		PreparedStatement psCustomer = null;
		try {

			con = getConnection();

			psCustomer = con.prepareStatement("select COUNTRY from COUNTRY");

			ResultSet rs = psCustomer.executeQuery();

			while (rs.next()) {
				Country country = new Country();
				country.setCountryName(rs.getString(1));
				countryList.add(country);

			}
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}
		return countryList;
	}

	@Override
	public long searchBusinessByAccountNo(long accountNo)
			throws CommercialCustRegException {
		PreparedStatement psCustomer = null;

		Connection con = null;

		long customerId = 0;

		try {

			con = getConnection();

			psCustomer = con
					.prepareStatement("select NP_ID from NON_PERSONAL_ACCOUNT where ACCOUNT_NUMBER=?");
			psCustomer.setLong(1, accountNo);

			ResultSet rs = psCustomer.executeQuery();

			while (rs.next()) {
				customerId = rs.getLong(1);
			}

		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(psCustomer);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}

		return customerId;
	}

	@Override
	public boolean uploaddocuments(Customers customers,NonPersonalCustomer customer) throws CommercialCustRegException 
	{
		boolean flag=false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			System.out.println("hi"+npID);

			con = getConnection();

			ps = con.prepareStatement("insert into non_personal_id values(?,?,?,?,?,?)");

			 ByteArrayInputStream bas = new ByteArrayInputStream(customers.getImage().getImage());
			 ByteArrayInputStream bas1 = new ByteArrayInputStream(customers.getImage1().getImage());
				
			 ps.setBinaryStream(1, bas, customers.getImage().getImage().length);
			 ps.setBinaryStream(2, bas1, customers.getImage1().getImage().length);
			 ps.setString(3, customers.getProofOfAddress());
			 ps.setString(4, customers.getProofOfId());
			 ps.setString(5,"Valid");
			 ps.setLong(6,customer.getBusinessId());
			 
			
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Problem in connection");
		} finally {
			try {
				closeConnection(con);
				closePreparedStatement(ps);
			} catch (SQLException se) {
				throw new CommercialCustRegException("Page not found");
			}
		}

					

		return flag;
	
	}

	@Override
	public Customers searchCustomerByNpId(int id) throws CommercialCustRegException 
	{		
		Connection con = null;
		PreparedStatement psCustomer = null;
		Customers customers=new Customers();
		System.out.println(id);
	
		try {

			System.out.println(id);
		con = getConnection();
		psCustomer = con
				.prepareStatement("select idproof,addressproof,npid  from non_personal_id where npid=?");
		psCustomer.setInt(1,id);
		
		ResultSet rs = psCustomer.executeQuery();

		while (rs.next()) {
			
			customers.setProofOfId(rs.getString(1));
			customers.setProofOfAddress(rs.getString(2));
			customers.setCustomerID(rs.getLong(3));
			
			}
		System.out.println("id"+customers.getCustomerID());
	} catch (SQLException se) {
		throw new CommercialCustRegException("Page not found");

	} catch (ClassNotFoundException cnfe) {

		throw new CommercialCustRegException("Problem in connection");
	} finally {
		try {
			closeConnection(con);
			closePreparedStatement(psCustomer);
		} catch (SQLException se) {

			throw new CommercialCustRegException("Page not found");
		}
	}

	return customers;
	}

	@Override
	public Customers viewImageBYID(long customerId) throws CommercialCustRegException
	{
		Connection con=null;
		PreparedStatement ps=null;
		Customers cust=null;
	try
	{
		con = getConnection();
		ps=con.prepareStatement("select image from non_personal_id where  npid=?");
		ps.setLong(1,customerId);
		
		ResultSet rs=ps.executeQuery();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		if(rs.next())
		{
			cust=new Customers();
			InputStream img = rs.getBinaryStream(1);
			BufferedImage bf =ImageIO.read(img);
			ImageIO.write(bf,"jpeg", bos);
			
			byte[] data = bos.toByteArray();
			FileDetails fd = new FileDetails();
			fd.setImage(data);
			
			cust.setImage(fd);	
			System.out.println("in dao");
		}
		
		
		
	}catch (SQLException e) {
		
		throw new CommercialCustRegException("Problem in connection");
	}
	catch (IOException e) {
		
		throw new CommercialCustRegException("Problem in connection");
	}catch (ClassNotFoundException cnfe) {
		throw new CommercialCustRegException("Problem in connection");
	}
	finally {
		try {
			closeConnection(con);
			closePreparedStatement(ps);
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		}
	}
	return cust;
		}

	@Override
	public Customers viewImageBYCustomerID(long customerId)throws CommercialCustRegException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		Customers cust=null;
		System.out.println("hi"+customerId);
		try
		{
		con = getConnection();
		ps=con.prepareStatement("select image1 from non_personal_id where  npid=?");
		ps.setLong(1,customerId);
		
		ResultSet rs=ps.executeQuery();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		if(rs.next())
		{
			cust=new Customers();
			InputStream img = rs.getBinaryStream(1);
			BufferedImage bf =ImageIO.read(img);
			ImageIO.write(bf,"jpeg", bos);
			
			byte[] data = bos.toByteArray();
			FileDetails fd = new FileDetails();
			fd.setImage1(data);
			
			cust.setImage1(fd);	
			System.out.println("in dao");
		}
		
		System.out.println("hhi"+cust.getImage1());
		
	}catch (SQLException e) {
		
		throw new CommercialCustRegException("Problem in connection");
	}
	catch (IOException e) {
		
		throw new CommercialCustRegException("Problem in connection");
	}catch (ClassNotFoundException cnfe) {
		throw new CommercialCustRegException("Problem in connection");
	}
	finally {
		try {
			closeConnection(con);
			closePreparedStatement(ps);
		} catch (SQLException se) {
			throw new CommercialCustRegException("Page not found");
		}
	}
	return cust;	
	}

}
