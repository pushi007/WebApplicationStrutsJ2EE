package com.tvm.ilp.t154.cao.model;

import java.util.Date;

public class NonPersonalAccount {

	private long accNumber;
	private int npId;
	private String accountType;
	private long productId;
	private String status;
	private String branch;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public int getNpId() {
		return npId;
	}

	public void setNpId(int npId) {
		this.npId = npId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public NonPersonalAccount(long accNumber, int npId, String accountType,
			long productId, String status, String branch) {
	
		this.accNumber = accNumber;
		this.npId = npId;
		this.accountType = accountType;
		this.productId = productId;
		this.status = status;
		this.branch = branch;
	}

	public NonPersonalAccount() {
	
		
	}
	

}
