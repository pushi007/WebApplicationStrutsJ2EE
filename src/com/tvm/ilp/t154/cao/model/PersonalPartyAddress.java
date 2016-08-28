package com.tvm.ilp.t154.cao.model;

public class PersonalPartyAddress {
	
	private String houseNo;
	private String houseName;
	private String buildingNo;
	private String streetName;
	private String cityName;
	private String townName;
	private String countryName;
	private String postalCode;
	private String presentAddressDate;
	private String AddressType;
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPresentAddressDate() {
		return presentAddressDate;
	}
	public void setPresentAddressDate(String presentAddressDate) {
		this.presentAddressDate = presentAddressDate;
	}
	public String getAddressType() {
		return AddressType;
	}
	public void setAddressType(String addressType) {
		AddressType = addressType;
	}
	public PersonalPartyAddress(String houseNo, String houseName,
			String buildingNo, String streetName, String cityName,
			String townName, String countryName, String postalCode,
			String presentAddressDate, String addressType) {
		super();
		this.houseNo = houseNo;
		this.houseName = houseName;
		this.buildingNo = buildingNo;
		this.streetName = streetName;
		this.cityName = cityName;
		this.townName = townName;
		this.countryName = countryName;
		this.postalCode = postalCode;
		this.presentAddressDate = presentAddressDate;
		AddressType = addressType;
	}
	public PersonalPartyAddress() {
	
	}
}
	