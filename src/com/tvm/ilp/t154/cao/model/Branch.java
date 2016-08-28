package com.tvm.ilp.t154.cao.model;

public class Branch {
	String branchId;
	String branchName;
	String branchAddress;
	
	public Branch() {

	}

	public Branch(String branchId, String branchName) {
		
		this.branchId = branchId;
		this.branchName = branchName;
	}
	
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
}
