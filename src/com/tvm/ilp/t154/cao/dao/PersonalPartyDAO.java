package com.tvm.ilp.t154.cao.dao;

import java.util.List;

import com.tvm.ilp.t154.cao.exceptions.CommercialCustRegException;
import com.tvm.ilp.t154.cao.model.NonPersonalCustomer;
import com.tvm.ilp.t154.cao.model.PersonalParty;
import com.tvm.ilp.t154.cao.model.PersonalPartyAddress;
import com.tvm.ilp.t154.cao.model.PersonalPartyCoreAddressContactDetails;
import com.tvm.ilp.t154.cao.model.PersonnalPartyContactDetails;

public interface PersonalPartyDAO {

	public List<PersonalParty> viewParties(PersonalParty pParty) throws CommercialCustRegException;
	public boolean addPersonalParty(PersonalParty personalPartyObject,PersonalPartyAddress PartyPresentAddressObject,PersonalPartyAddress PartyPreviousAddressObject,PersonnalPartyContactDetails pPartyContactDetails) throws CommercialCustRegException;
	public PersonalPartyCoreAddressContactDetails viewSelectedParty(long PartyId) throws CommercialCustRegException;
	public boolean deleteSelectedParty(long PartyId) throws CommercialCustRegException;
	public boolean updatePersonalParty(PersonalPartyCoreAddressContactDetails partyDetails) throws CommercialCustRegException;
	public PersonalPartyCoreAddressContactDetails getAccountDetails(long accountNumber, String branchName) throws CommercialCustRegException;
}
