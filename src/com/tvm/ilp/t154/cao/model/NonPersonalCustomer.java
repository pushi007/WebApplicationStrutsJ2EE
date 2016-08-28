/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 668552
 * 
 */
public class NonPersonalCustomer {
	private long businessId;
	private String businessName;
	private String branchName;
	private boolean hasAccount;

	/*
	 * private long accountNo;
	 * 
	 * public long getAccountNo() { return accountNo; }
	 * 
	 * public void setAccountNo(long accountNo) { this.accountNo = accountNo; }
	 */

	public boolean isHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	private String tradingName;
	private String businessType;
	// private String bankBranchName;
	// private String bankBranchId;
	// private String bankBranchAddress;
	private String isStartUpBusiness;
	private String dateEstablished;
	private String dateOfRegistration;
	private String countryOfRegistration;
	private double expectedAnnualTurnover;
	private double totalBusinessCapital;

	private String businessStatus;
	private int noOfEmployees;
	private String tellMoreAboutYourBusiness;

	private String moreAboutBusiness;
	private String requireFunding;

	private String businessEmailAddress;

	private String industrySector;
	private String mainActivity;
	private String preciseActivity;
	private String importExport;

	private double fundAmount;
	private String partOfGroup;
	private String franchiseDetails;
	private String email;

	private List<NPAddress> npAddressList;
	private List<NPContacts> npContactList;
	private List<NPProofOfDocument> npProofOfDocuments;
	private Branch branch;
	private List<NonPersonalAccount> accountList;
	

	public List<NonPersonalAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<NonPersonalAccount> accountList) {
		this.accountList = accountList;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<NPProofOfDocument> getNpProofOfDocuments() {
		return npProofOfDocuments;
	}

	public void setNpProofOfDocuments(List<NPProofOfDocument> npProofOfDocuments) {
		this.npProofOfDocuments = npProofOfDocuments;
	}

	public List<NPContacts> getNpContactList() {
		return npContactList;
	}

	public void setNpContactList(List<NPContacts> npContactList) {
		this.npContactList = npContactList;
	}

	public NonPersonalCustomer() {
		this.branch = new Branch();
		this.npContactList = new ArrayList<NPContacts>();
		this.npAddressList = new ArrayList<NPAddress>();
		this.npProofOfDocuments = new ArrayList<NPProofOfDocument>();
		this.accountList=new ArrayList<NonPersonalAccount>();
	}

	public List<NPAddress> getNpAddressList() {
		return npAddressList;
	}

	public void setNpAddressList(List<NPAddress> npAddressList) {
		this.npAddressList = npAddressList;
	}

	public String getIndustrySector() {
		return industrySector;
	}

	public void setIndustrySector(String industrySector) {
		this.industrySector = industrySector;
	}

	public String getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(String mainActivity) {
		this.mainActivity = mainActivity;
	}

	public String getPreciseActivity() {
		return preciseActivity;
	}

	public void setPreciseActivity(String preciseActivity) {
		this.preciseActivity = preciseActivity;
	}

	public String getImportExport() {
		return importExport;
	}

	public void setImportExport(String importExport) {
		this.importExport = importExport;
	}

	public double getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(double fundAmount) {
		this.fundAmount = fundAmount;
	}

	public String getPartOfGroup() {
		return partOfGroup;
	}

	public void setPartOfGroup(String partOfGroup) {
		this.partOfGroup = partOfGroup;
	}

	public String getFranchiseDetails() {
		return franchiseDetails;
	}

	public void setFranchiseDetails(String franchiseDetails) {
		this.franchiseDetails = franchiseDetails;
	}

	public String getMoreAboutBusiness() {
		return moreAboutBusiness;
	}

	public void setMoreAboutBusiness(String moreAboutBusiness) {
		this.moreAboutBusiness = moreAboutBusiness;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
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

	public String getIsStartUpBusiness() {
		return isStartUpBusiness;
	}

	public void setIsStartUpBusiness(String isStartUpBusiness) {
		this.isStartUpBusiness = isStartUpBusiness;
	}

	public String getDateEstablished() {
		return dateEstablished;
	}

	public void setDateEstablished(String dateEstablished) {
		this.dateEstablished = dateEstablished;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public double getExpectedAnnualTurnover() {
		return expectedAnnualTurnover;
	}

	public void setExpectedAnnualTurnover(double expectedAnnualTurnover) {
		this.expectedAnnualTurnover = expectedAnnualTurnover;
	}

	public double getTotalBusinessCapital() {
		return totalBusinessCapital;
	}

	public void setTotalBusinessCapital(double totalBusinessCapital) {
		this.totalBusinessCapital = totalBusinessCapital;
	}

	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getTellMoreAboutYourBusiness() {
		return tellMoreAboutYourBusiness;
	}

	public void setTellMoreAboutYourBusiness(String tellMoreAboutYourBusiness) {
		this.tellMoreAboutYourBusiness = tellMoreAboutYourBusiness;
	}

	public String getRequireFunding() {
		return requireFunding;
	}

	public void setRequireFunding(String requireFunding) {
		this.requireFunding = requireFunding;
	}

	public String getCountryOfRegistration() {
		return countryOfRegistration;
	}

	public void setCountryOfRegistration(String countryOfRegistration) {
		this.countryOfRegistration = countryOfRegistration;
	}

	public String getBusinessEmailAddress() {
		return businessEmailAddress;
	}

	public void setBusinessEmailAddress(String businessEmailAddress) {
		this.businessEmailAddress = businessEmailAddress;
	}

}
