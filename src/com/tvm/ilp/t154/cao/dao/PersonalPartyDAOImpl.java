package com.tvm.ilp.t154.cao.dao;

import static com.tvm.ilp.t154.cao.utils.ConnectionUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.model.PersonalParty;
import com.tvm.ilp.t154.cao.model.PersonalPartyAddress;
import com.tvm.ilp.t154.cao.model.PersonalPartyCoreAddressContactDetails;
import com.tvm.ilp.t154.cao.model.PersonnalPartyContactDetails;

public class PersonalPartyDAOImpl implements PersonalPartyDAO {

	@Override
	public ArrayList<PersonalParty> viewParties(PersonalParty pParty) throws CommercialCustRegException {
	
			ArrayList<PersonalParty> pPartyList = new ArrayList<PersonalParty>();
			Connection con = null;
			PreparedStatement ps = null;
	
			try {
				con = getConnection();
					
				ps = con.prepareStatement("select * from PERSONAL_PARTY WHERE NP_ID=?");
				ps.setLong(1, pParty.getBusinessId());
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					PersonalParty ppParty=new PersonalParty();
					ppParty.setPartyId(rs.getLong(1));
					ppParty.setBusinessId(rs.getLong(2));
					ppParty.setTitle(rs.getString(3));
					ppParty.setFirstName(rs.getString(4));
					ppParty.setMiddleName(rs.getString(5));
					ppParty.setSurName(rs.getString(6));
					ppParty.setRelationshipType(rs.getString(7));
					ppParty.setKeyParty(rs.getString(8));
					ppParty.setIsExistingCustomer(rs.getString(9));
					ppParty.setAccountNumber(rs.getLong(10));
					ppParty.setBranchId(rs.getString(11));
					ppParty.setDateOfBirth((rs.getDate(12).toString().replace('-', '/')));
					pPartyList.add(ppParty);
					
				}
			} catch (SQLException se) {
				throw new CommercialCustRegException("Connection problem");
			} catch (ClassNotFoundException cnfe) {
				throw new CommercialCustRegException("Connection problem");
			}finally{try{
			closeConnection(con);
			closePreparedStatement(ps);
			}catch (SQLException sqe) {
				throw new CommercialCustRegException("Connection problem");
			}
			}
			
			return pPartyList;
			
	}

	@Override
	public boolean addPersonalParty(PersonalParty personalPartyObject,
			PersonalPartyAddress PartyPresentAddressObject,
			PersonalPartyAddress PartyPreviousAddressObject,
			PersonnalPartyContactDetails pPartyContactDetails) throws CommercialCustRegException {
			boolean flag=false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			
			int curPartyId=0;
			con = getConnection();
					
			ps = con.prepareStatement("SELECT PERSONAL_PARTY_ID_GENERATION.NEXTVAL FROM DUAL");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				curPartyId=rs.getInt(1);
			}
		
			PreparedStatement psAdd = null;
			psAdd = con.prepareStatement("INSERT INTO PERSONAL_PARTY VALUES(?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'yyyy/mm/dd'))");
			psAdd.setLong(1, curPartyId);
			psAdd.setLong(2,personalPartyObject.getBusinessId());
			psAdd.setString(3, personalPartyObject.getTitle());
			psAdd.setString(4, personalPartyObject.getFirstName());
			psAdd.setString(5, personalPartyObject.getMiddleName());
			psAdd.setString(6, personalPartyObject.getSurName());
			psAdd.setString(7, personalPartyObject.getRelationshipType());
			psAdd.setString(8, personalPartyObject.getKeyParty());
			psAdd.setString(9, personalPartyObject.getIsExistingCustomer());
			psAdd.setLong(10, personalPartyObject.getAccountNumber());
			psAdd.setString(11, personalPartyObject.getBranchId());
			psAdd.setString(12, personalPartyObject.getDateOfBirth());
			
			int i=psAdd.executeUpdate();
	
			if(i>0)
			{
				flag=true;
				psAdd = null;
				psAdd = con.prepareStatement("INSERT INTO PERSONAL_PARTY_ADDRESS VALUES(?,?,?,?,?,?,?,?,?,?)");
				psAdd.setLong(1, curPartyId);
				psAdd.setString(2, PartyPresentAddressObject.getHouseNo());
				psAdd.setString(3, PartyPresentAddressObject.getHouseName());
				psAdd.setString(4, PartyPresentAddressObject.getBuildingNo());
				psAdd.setString(5, PartyPresentAddressObject.getStreetName());
				psAdd.setString(6, PartyPresentAddressObject.getCityName());
				psAdd.setString(7, PartyPresentAddressObject.getTownName());
				psAdd.setString(8, PartyPresentAddressObject.getCountryName());
				psAdd.setString(9, PartyPresentAddressObject.getPostalCode());
				psAdd.setString(10, "Present");
				int j=psAdd.executeUpdate();
				
				psAdd = null;
				psAdd = con.prepareStatement("INSERT INTO PERSONAL_PARTY_ADDRESS VALUES(?,?,?,?,?,?,?,?,?,?)");
				psAdd.setLong(1, curPartyId);
				psAdd.setString(2, PartyPreviousAddressObject.getHouseNo());
				psAdd.setString(3, PartyPreviousAddressObject.getHouseName());
				psAdd.setString(4, PartyPreviousAddressObject.getBuildingNo());
				psAdd.setString(5, PartyPreviousAddressObject.getStreetName());
				psAdd.setString(6, PartyPreviousAddressObject.getCityName());
				psAdd.setString(7, PartyPreviousAddressObject.getTownName());
				psAdd.setString(8, PartyPreviousAddressObject.getCountryName());
				psAdd.setString(9, PartyPreviousAddressObject.getPostalCode());
				psAdd.setString(10, "Previous");
				int k=psAdd.executeUpdate();
				
				psAdd = null;

				psAdd = con.prepareStatement("INSERT INTO PERSONAL_PARTY_CONTACT_DETAILS VALUES(?,?,?,?,?,?,?,?,?)");
				psAdd.setLong(1, curPartyId);
				psAdd.setString(2, pPartyContactDetails.geteMailAddress());
				psAdd.setString(3, pPartyContactDetails.getMobileNumber());
				psAdd.setString(4, pPartyContactDetails.getHomeNumber());
				psAdd.setString(5, pPartyContactDetails.getOfficeNumber());
				psAdd.setString(6, pPartyContactDetails.getIdProofType());
				psAdd.setString(7, pPartyContactDetails.getIdProofFile());
				psAdd.setString(8, pPartyContactDetails.getAddressProofType());
				psAdd.setString(9, pPartyContactDetails.getAddressProofFile());
			int l=psAdd.executeUpdate();
				
				
			}
		
		} catch (SQLException se) {
			throw new CommercialCustRegException("Connection problem");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Connection problem");
		}finally{try{
		closeConnection(con);
		closePreparedStatement(ps);
		}catch (SQLException sqe) {
			throw new CommercialCustRegException("Connection problem");
		}
		}
		    return flag;
	}
	
	public PersonalPartyCoreAddressContactDetails viewSelectedParty(long PartyId) throws CommercialCustRegException
	{
		PersonalPartyCoreAddressContactDetails partyDetails=new PersonalPartyCoreAddressContactDetails();
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
				
			ps = con.prepareStatement("select * from PERSONAL_PARTY WHERE PARTY_ID=?");
			ps.setLong(1, PartyId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				partyDetails.getpPartyCoreDetails().setPartyId(rs.getLong(1));
				partyDetails.getpPartyCoreDetails().setBusinessId(rs.getLong(2));
				partyDetails.getpPartyCoreDetails().setTitle(rs.getString(3));
				partyDetails.getpPartyCoreDetails().setFirstName(rs.getString(4));
				partyDetails.getpPartyCoreDetails().setMiddleName(rs.getString(5));
				partyDetails.getpPartyCoreDetails().setSurName(rs.getString(6));
				partyDetails.getpPartyCoreDetails().setRelationshipType(rs.getString(7));
				partyDetails.getpPartyCoreDetails().setKeyParty(rs.getString(8));
				partyDetails.getpPartyCoreDetails().setIsExistingCustomer(rs.getString(9));
				partyDetails.getpPartyCoreDetails().setAccountNumber(rs.getLong(10));
				partyDetails.getpPartyCoreDetails().setBranchId(rs.getString(11));
				partyDetails.getpPartyCoreDetails().setDateOfBirth(rs.getString(12).substring(0, 10).replace('-', '/'));
			}

				ps=null;
				ps = con.prepareStatement("select * from PERSONAL_PARTY_ADDRESS WHERE PARTY_ID=? AND ADDRESS_TYPE=?");
				ps.setLong(1, PartyId);
				ps.setString(2, "Present");
				rs = ps.executeQuery();

				while (rs.next()) {
					
					partyDetails.getpPartyPresentAddress().setHouseNo(rs.getString(2));
					partyDetails.getpPartyPresentAddress().setHouseName(rs.getString(3));
					partyDetails.getpPartyPresentAddress().setBuildingNo(rs.getString(4));
					partyDetails.getpPartyPresentAddress().setStreetName(rs.getString(5));
					partyDetails.getpPartyPresentAddress().setCityName(rs.getString(6));
					partyDetails.getpPartyPresentAddress().setTownName(rs.getString(7));
					partyDetails.getpPartyPresentAddress().setCountryName(rs.getString(8));
					partyDetails.getpPartyPresentAddress().setPostalCode(rs.getString(9));
			}
				ps=null;
				ps = con.prepareStatement("select * from PERSONAL_PARTY_ADDRESS WHERE PARTY_ID=? AND ADDRESS_TYPE=?");
				ps.setLong(1, PartyId);
				ps.setString(2, "Previous");
				rs = ps.executeQuery();

				while (rs.next()) {
					
					partyDetails.getpPartyPreviousAddress().setHouseNo(rs.getString(2));
					partyDetails.getpPartyPreviousAddress().setHouseName(rs.getString(3));
					partyDetails.getpPartyPreviousAddress().setBuildingNo(rs.getString(4));
					partyDetails.getpPartyPreviousAddress().setStreetName(rs.getString(5));
					partyDetails.getpPartyPreviousAddress().setCityName(rs.getString(6));
					partyDetails.getpPartyPreviousAddress().setTownName(rs.getString(7));
					partyDetails.getpPartyPreviousAddress().setCountryName(rs.getString(8));
					partyDetails.getpPartyPreviousAddress().setPostalCode(rs.getString(9));
			}
				ps=null;
				ps = con.prepareStatement("select * from PERSONAL_PARTY_CONTACT_DETAILS WHERE PARTY_ID=?");
				ps.setLong(1, PartyId);
				rs = ps.executeQuery();

				while (rs.next()) {
					partyDetails.getpPartyContactDetails().seteMailAddress(rs.getString(2));
					partyDetails.getpPartyContactDetails().setMobileNumber(rs.getString(3));
					partyDetails.getpPartyContactDetails().setHomeNumber(rs.getString(4));
					partyDetails.getpPartyContactDetails().setOfficeNumber(rs.getString(5));
					partyDetails.getpPartyContactDetails().setIdProofType(rs.getString(6));
					partyDetails.getpPartyContactDetails().setIdProofFile(rs.getString(7));
					partyDetails.getpPartyContactDetails().setAddressProofType(rs.getString(8));
					partyDetails.getpPartyContactDetails().setAddressProofFile(rs.getString(9));
			}
				
		} catch (SQLException se) {
			throw new CommercialCustRegException("Connection problem");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Connection problem");
		}finally{try{
		closeConnection(con);
		closePreparedStatement(ps);
		}catch (SQLException sqe) {
			throw new CommercialCustRegException("Connection problem");		}
		}
		
		return partyDetails;
		
	}
	
	
	public boolean deleteSelectedParty(long PartyId) throws CommercialCustRegException
	{
//		PersonalPartyCoreAddressContactDetails partyDetails=new PersonalPartyCoreAddressContactDetails();
		Connection con = null;
		PreparedStatement ps = null;
		boolean deleteFlag=false;
		
		try {
			con = getConnection();
			
			ps = con.prepareStatement("delete from PERSONAL_PARTY WHERE PARTY_ID=?");
			ps.setLong(1, PartyId);
			int i= ps.executeUpdate();

			if(i>0)
			{
				deleteFlag=true;
			}
				
		} catch (SQLException se) {
			throw new CommercialCustRegException("Connection problem");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Connection problem");
		}finally{try{
		closeConnection(con);
		closePreparedStatement(ps);
		}catch (SQLException sqe) {
			throw new CommercialCustRegException("Connection problem");		}
		}
		
		return deleteFlag;
		
	}
	
	
	public boolean updatePersonalParty(PersonalPartyCoreAddressContactDetails partyDetails) throws CommercialCustRegException
	{
		long pid=partyDetails.getpPartyCoreDetails().getPartyId();
		Connection con = null;
		PreparedStatement ps = null;
		boolean updateFlag=false;
		
		try {
			
			con = getConnection();
		
			ps = con.prepareStatement("UPDATE PERSONAL_PARTY SET TITLE=?,FIRST_NAME=?,MIDDLE_NAME=?,SURNAME=?,RELATIONSHIP_TYPE=?,IS_KEY_PARTY=?,IS_EXISTING_CUSTOMER=? WHERE PARTY_ID=?");
			ps.setString(1, partyDetails.getpPartyCoreDetails().getTitle());
			ps.setString(2, partyDetails.getpPartyCoreDetails().getFirstName() );
			ps.setString(3, partyDetails.getpPartyCoreDetails().getMiddleName() );
			ps.setString(4, partyDetails.getpPartyCoreDetails().getSurName() );
			ps.setString(5, partyDetails.getpPartyCoreDetails().getRelationshipType());
			ps.setString(6, partyDetails.getpPartyCoreDetails().getKeyParty());
			ps.setString(7, partyDetails.getpPartyCoreDetails().getIsExistingCustomer());
			ps.setLong(8, pid);
			int i= ps.executeUpdate();

				ps = null;
				ps = con.prepareStatement("UPDATE PERSONAL_PARTY_ADDRESS SET HOUSE_NO=?,HOUSE_NAME=?,BUILDING_NO=?,STREET_NAME=?,CITY_NAME=?,TOWN_NAME=?,COUNTRY=?,POSTAL_CODE=? WHERE PARTY_ID=? AND ADDRESS_TYPE=?");
				ps.setString(1,partyDetails.getpPartyPresentAddress().getHouseNo());
				ps.setString(2,partyDetails.getpPartyPresentAddress().getHouseName());
				ps.setString(3,partyDetails.getpPartyPresentAddress().getBuildingNo());
				ps.setString(4,partyDetails.getpPartyPresentAddress().getStreetName());
				ps.setString(5,partyDetails.getpPartyPresentAddress().getCityName());
				ps.setString(6,partyDetails.getpPartyPresentAddress().getTownName());
				ps.setString(7,partyDetails.getpPartyPresentAddress().getCountryName());
				ps.setString(8,partyDetails.getpPartyPresentAddress().getPostalCode());
				ps.setLong(9,pid);
				ps.setString(10,"Present");
			i= ps.executeUpdate();
				
				ps = null;
				ps = con.prepareStatement("UPDATE PERSONAL_PARTY_ADDRESS SET HOUSE_NO=?,HOUSE_NAME=?,BUILDING_NO=?,STREET_NAME=?,CITY_NAME=?,TOWN_NAME=?,COUNTRY=?,POSTAL_CODE=? WHERE PARTY_ID=? AND ADDRESS_TYPE=?");
				ps.setString(1,partyDetails.getpPartyPreviousAddress().getHouseNo());
				ps.setString(2,partyDetails.getpPartyPreviousAddress().getHouseName());
				ps.setString(3,partyDetails.getpPartyPreviousAddress().getBuildingNo());
				ps.setString(4,partyDetails.getpPartyPreviousAddress().getStreetName());
				ps.setString(5,partyDetails.getpPartyPreviousAddress().getCityName());
				ps.setString(6,partyDetails.getpPartyPreviousAddress().getTownName());
				ps.setString(7,partyDetails.getpPartyPreviousAddress().getCountryName());
				ps.setString(8,partyDetails.getpPartyPreviousAddress().getPostalCode());
				ps.setLong(9,pid);
				ps.setString(10,"Previous");
				i= ps.executeUpdate();
				
				ps = null;
				ps = con.prepareStatement("UPDATE PERSONAL_PARTY_CONTACT_DETAILS SET EMAIL_ADDRESS=?,MOBILE_NO=?,HOME_CONTACT_NO=?,OFFICE_CONTACT_NO=?,ID_PROOF_TYPE=?,ID_PROOF_FILE=?,ADDRESS_PROOF_TYPE=?,ADDRESS_PROOF_FILE=? WHERE PARTY_ID=?");
				ps.setString(1,partyDetails.getpPartyContactDetails().geteMailAddress());
				ps.setString(2,partyDetails.getpPartyContactDetails().getMobileNumber());
				ps.setString(3,partyDetails.getpPartyContactDetails().getHomeNumber());
				ps.setString(4,partyDetails.getpPartyContactDetails().getOfficeNumber());
				ps.setString(5,partyDetails.getpPartyContactDetails().getIdProofType());
				ps.setString(6,partyDetails.getpPartyContactDetails().getIdProofFile());
				ps.setString(7,partyDetails.getpPartyContactDetails().getAddressProofType());
				ps.setString(8,partyDetails.getpPartyContactDetails().getAddressProofFile());
				ps.setLong(9,pid);
		
				i= ps.executeUpdate();
				
		} catch (SQLException se) {
			se.printStackTrace();
			throw new CommercialCustRegException("sdadsadasdas");
		} catch (ClassNotFoundException cnfe) {
			throw new CommercialCustRegException("Connection problem");
		}finally{try{
		closeConnection(con);
		closePreparedStatement(ps);
		}catch (SQLException sqe) {
			throw new CommercialCustRegException("Connection problem");
		}
		}
		
		return updateFlag;
		
	}

	//@SuppressWarnings("null")
	@Override
	public PersonalPartyCoreAddressContactDetails getAccountDetails(long accountNumber, String branchName) throws CommercialCustRegException 
	{
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				
				ps = con.prepareStatement("SELECT * FROM PERSONAL_ACCOUNTS WHERE ACCOUNT_NO=? AND BRANCH_NAME=?");
				ps.setLong(1, accountNumber);
				ps.setString(2, branchName);
				ResultSet rs = ps.executeQuery();
				partyDetails.getpPartyCoreDetails().setAccountNumber(0);
				while(rs.next())
				{
					partyDetails.getpPartyCoreDetails().setAccountNumber(accountNumber);
					partyDetails.getpPartyPresentAddress().setHouseNo(rs.getString(3));
					partyDetails.getpPartyPresentAddress().setHouseName(rs.getString(4));
					partyDetails.getpPartyPresentAddress().setBuildingNo(rs.getString(5));
					partyDetails.getpPartyPresentAddress().setStreetName(rs.getString(6));
					partyDetails.getpPartyPresentAddress().setCityName(rs.getString(7));
					partyDetails.getpPartyPresentAddress().setTownName(rs.getString(8));
					partyDetails.getpPartyPresentAddress().setCountryName(rs.getString(9));
					partyDetails.getpPartyPresentAddress().setPostalCode(rs.getString(10));
					partyDetails.getpPartyPreviousAddress().setHouseNo(rs.getString(11));
					partyDetails.getpPartyPreviousAddress().setHouseName(rs.getString(12));
					partyDetails.getpPartyPreviousAddress().setBuildingNo(rs.getString(13));
					partyDetails.getpPartyPreviousAddress().setStreetName(rs.getString(14));
					partyDetails.getpPartyPreviousAddress().setCityName(rs.getString(15));
					partyDetails.getpPartyPreviousAddress().setTownName(rs.getString(16));
					partyDetails.getpPartyPreviousAddress().setCountryName(rs.getString(17));
					partyDetails.getpPartyPreviousAddress().setPostalCode(rs.getString(18));
					partyDetails.getpPartyContactDetails().seteMailAddress(rs.getString(19));
					partyDetails.getpPartyContactDetails().setMobileNumber(rs.getString(20));
					partyDetails.getpPartyContactDetails().setHomeNumber(rs.getString(21));
					partyDetails.getpPartyContactDetails().setOfficeNumber(rs.getString(22));
					partyDetails.getpPartyContactDetails().setIdProofType(rs.getString(23));
					partyDetails.getpPartyContactDetails().setIdProofFile(rs.getString(24));
					partyDetails.getpPartyContactDetails().setAddressProofType(rs.getString(25));
					partyDetails.getpPartyContactDetails().setAddressProofFile(rs.getString(26));
				}
				
			} catch (SQLException se) {
				throw new CommercialCustRegException("Connection problem");
			} catch (ClassNotFoundException cnfe) {
				throw new CommercialCustRegException("Connection problem");
			}finally{try{
			closeConnection(con);
			closePreparedStatement(ps);
			}catch (SQLException sqe) {
				throw new CommercialCustRegException("Connection problem");			}
			}
			
		return partyDetails;
	}


}
