
	package com.tvm.ilp.t154.cao.services;

	import java.util.ArrayList;

import com.tvm.ilp.t154.cao.dao.NonPersonalCustomerDAOImpl;
import com.tvm.ilp.t154.cao.dao.PersonalPartyDAO;
import com.tvm.ilp.t154.cao.dao.PersonalPartyDAOImpl;
import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.model.PersonalParty;
import com.tvm.ilp.t154.cao.model.PersonalPartyAddress;
import com.tvm.ilp.t154.cao.model.PersonalPartyCoreAddressContactDetails;
import com.tvm.ilp.t154.cao.model.PersonnalPartyContactDetails;

	public class AccountPartyManagementService
	{
		NonPersonalCustomer np=new NonPersonalCustomer();

		public NonPersonalCustomer searchBusinessIdName(Long Bid,String Bname,String Bbranch) {
			NonPersonalCustomerDAOImpl npCustomerDao=new NonPersonalCustomerDAOImpl();
			np=npCustomerDao.searchBusinessIdName(Bid, Bname, Bbranch);
			return np;
		}
		
		public ArrayList<PersonalParty> ViewPersonalParties(PersonalParty pp) throws CommercialCustRegException{
		    ArrayList<PersonalParty> app=new ArrayList<PersonalParty>();
		    PersonalPartyDAO ppDao=new PersonalPartyDAOImpl();
		    app=(ArrayList<PersonalParty>) ppDao.viewParties(pp);		
			return app;
		}
		
		public boolean addPersonalParty(PersonalParty personalPartyObject,PersonalPartyAddress PartyPresentAddressObject,PersonalPartyAddress PartyPreviousAddressObject,PersonnalPartyContactDetails pPartyContactDetails) throws CommercialCustRegException
		{
			PersonalPartyDAO ppDao=new PersonalPartyDAOImpl();
			boolean flag=ppDao.addPersonalParty(personalPartyObject, PartyPresentAddressObject, PartyPreviousAddressObject, pPartyContactDetails);
			return flag;
		}
		
		public PersonalPartyCoreAddressContactDetails viewSelectedParty(long PartyId) throws CommercialCustRegException
		{
			PersonalPartyCoreAddressContactDetails partyDetails=new PersonalPartyCoreAddressContactDetails();
			PersonalPartyDAO ppDao=new PersonalPartyDAOImpl();
			partyDetails=ppDao.viewSelectedParty(PartyId);
			return partyDetails;
		}
		
		public boolean deleteSelectedParty(long PartyId) throws CommercialCustRegException
		{
			PersonalPartyDAO ppDao=new PersonalPartyDAOImpl();
			boolean flagDelete=ppDao.deleteSelectedParty(PartyId);
			return flagDelete;
		}
		
		public boolean updatePersonalParty(PersonalPartyCoreAddressContactDetails partyDetails) throws CommercialCustRegException
		{
			PersonalPartyDAO ppDao=new PersonalPartyDAOImpl();
			boolean flagDelete=ppDao.updatePersonalParty(partyDetails);
			return flagDelete;
		}

		public PersonalPartyCoreAddressContactDetails getAccountDetails(long accountNumber, String branchName) throws CommercialCustRegException
		{
			PersonalPartyDAO ppDao=new PersonalPartyDAOImpl();
			PersonalPartyCoreAddressContactDetails partyDetails = new PersonalPartyCoreAddressContactDetails();
			partyDetails=ppDao.getAccountDetails(accountNumber,branchName);
			return partyDetails;
		}
		

	}


