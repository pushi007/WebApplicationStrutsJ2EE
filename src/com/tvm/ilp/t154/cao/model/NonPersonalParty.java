/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 741226
 * 
 */
public class NonPersonalParty {
	private int nonPersonalId;
	private String businessName;
	private String tradingName;
	private String businessType;
	private String branchId;
	private long rmAssigned;

	public NonPersonalParty() {
		// TODO Auto-generated constructor stub
	}

	public NonPersonalParty(int nonPersonalId, String businessName,
			String tradingName, String businessType, String branchId,
			long rmAssigned) {
		super();
		this.nonPersonalId = nonPersonalId;
		this.businessName = businessName;
		this.tradingName = tradingName;
		this.businessType = businessType;
		this.branchId = branchId;
		this.rmAssigned = rmAssigned;
	}

	public int getNonPersonalId() {
		return nonPersonalId;
	}

	public void setNonPersonalId(int nonPersonalId) {
		this.nonPersonalId = nonPersonalId;
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

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchName) {
		this.branchId = branchName;
	}

	public long getRmAssigned() {
		return rmAssigned;
	}

	public void setRmAssigned(long rmAssigned) {
		this.rmAssigned = rmAssigned;
	}

}
