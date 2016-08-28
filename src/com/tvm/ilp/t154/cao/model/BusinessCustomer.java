package com.tvm.ilp.t154.cao.model;

public class BusinessCustomer {

	private long npId;
	private String businessName;
	private String tradingName;
	private String businessType;
	private String country;

	private String branchName;
	private String email;

	public BusinessCustomer() {

	}

	public long getNpId() {
		return npId;
	}

	public void setNpId(long npId) {
		this.npId = npId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BusinessCustomer(long npId, String businessName, String tradingName,
			String businessType, String country, String branchName, String email) {

		this.npId = npId;
		this.businessName = businessName;
		this.tradingName = tradingName;
		this.businessType = businessType;
		this.country = country;
		this.branchName = branchName;
		this.email = email;
	}

}