/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 597207
 *
 */
public class PersonnalPartyContactDetails {

	private String eMailAddress;
	private String mobileNumber;
	private String homeNumber;
	private String officeNumber;
	private String idProofType;
	private String idProofFile;
	private String addressProofType;
	private String addressProofFile;
	public String geteMailAddress() {
		return eMailAddress;
	}
	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getIdProofType() {
		return idProofType;
	}
	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}
	public String getIdProofFile() {
		return idProofFile;
	}
	public void setIdProofFile(String idProofFile) {
		this.idProofFile = idProofFile;
	}
	public String getAddressProofType() {
		return addressProofType;
	}
	public void setAddressProofType(String addressProofType) {
		this.addressProofType = addressProofType;
	}
	public String getAddressProofFile() {
		return addressProofFile;
	}
	public void setAddressProofFile(String addressProofFile) {
		this.addressProofFile = addressProofFile;
	}
	public PersonnalPartyContactDetails() {
		
	}
	public PersonnalPartyContactDetails(String eMailAddress,
			String mobileNumber, String homeNumber, String officeNumber,
			String idProofType, String idProofFile, String addressProofType,
			String addressProofFile) {
		super();
		this.eMailAddress = eMailAddress;
		this.mobileNumber = mobileNumber;
		this.homeNumber = homeNumber;
		this.officeNumber = officeNumber;
		this.idProofType = idProofType;
		this.idProofFile = idProofFile;
		this.addressProofType = addressProofType;
		this.addressProofFile = addressProofFile;
	}
	
	
}
