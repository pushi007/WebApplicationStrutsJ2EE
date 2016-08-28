package com.tvm.ilp.t154.cao.model;

public class PersonalPartyCoreAddressContactDetails {
	
	PersonalParty pPartyCoreDetails=new PersonalParty();
	PersonalPartyAddress pPartyPresentAddress=new PersonalPartyAddress();
	PersonalPartyAddress pPartyPreviousAddress=new PersonalPartyAddress();
	PersonnalPartyContactDetails pPartyContactDetails=new PersonnalPartyContactDetails();
	public PersonalParty getpPartyCoreDetails() {
		return pPartyCoreDetails;
	}
	public void setpPartyCoreDetails(PersonalParty pPartyCoreDetails) {
		this.pPartyCoreDetails = pPartyCoreDetails;
	}
	public PersonalPartyAddress getpPartyPresentAddress() {
		return pPartyPresentAddress;
	}
	public void setpPartyPresentAddress(PersonalPartyAddress pPartyPresentAddress) {
		this.pPartyPresentAddress = pPartyPresentAddress;
	}
	public PersonalPartyAddress getpPartyPreviousAddress() {
		return pPartyPreviousAddress;
	}
	public void setpPartyPreviousAddress(PersonalPartyAddress pPartyPreviousAddress) {
		this.pPartyPreviousAddress = pPartyPreviousAddress;
	}
	public PersonnalPartyContactDetails getpPartyContactDetails() {
		return pPartyContactDetails;
	}
	public void setpPartyContactDetails(
			PersonnalPartyContactDetails pPartyContactDetails) {
		this.pPartyContactDetails = pPartyContactDetails;
	}
}

