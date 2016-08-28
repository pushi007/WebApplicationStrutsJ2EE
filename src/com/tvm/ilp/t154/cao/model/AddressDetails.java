package com.tvm.ilp.t154.cao.model;

public class AddressDetails {
private long np_id;
private String buildingNo;
private String buildingName;
private String streetName;
private String cityName;
private String townName;
private String country;
private String postalCode;
private String countryCode;
private String areaCode;
private long contactNumber;
public long getNp_id() {
	return np_id;
}
public void setNp_id(long npId) {
	np_id = npId;
}
public String getBuildingNo() {
	return buildingNo;
}
public void setBuildingNo(String buildingNo) {
	this.buildingNo = buildingNo;
}
public String getBuildingName() {
	return buildingName;
}
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}
public String getStreetName() {
	return streetName;
}
public void setStreetName(String streetName) {
	this.streetName = streetName;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public String getTownName() {
	return townName;
}
public void setTownName(String townName) {
	this.townName = townName;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
public String getAreaCode() {
	return areaCode;
}
public void setAreaCode(String areaCode) {
	this.areaCode = areaCode;
}
public long getContactNumber() {
	return contactNumber;
}
public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
}
public AddressDetails(long npId, String buildingNo, String buildingName,
		String streetName, String cityName, String townName, String country,
		String postalCode, String countryCode, String areaCode,
		long contactNumber) {
	
	np_id = npId;
	this.buildingNo = buildingNo;
	this.buildingName = buildingName;
	this.streetName = streetName;
	this.cityName = cityName;
	this.townName = townName;
	this.country = country;
	this.postalCode = postalCode;
	this.countryCode = countryCode;
	this.areaCode = areaCode;
	this.contactNumber = contactNumber;
}

public AddressDetails() {
	
}
	
}
