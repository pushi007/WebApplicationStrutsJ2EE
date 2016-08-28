/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 597142
 *
 */
public class Customers 
{
	private long customerID;
	private String proofOfAddress;
	private FileDetails image;
	private String proofOfId;
	private FileDetails image1;
	private String status;
	
	
	public Customers(long customerID, String proofOfAddress,
			String proofOfId) {
	
		this.customerID = customerID;
		this.proofOfAddress = proofOfAddress;
		this.proofOfId = proofOfId;

	}

	
	
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}




	public long getCustomerID() {
		return customerID;
	}


	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}


	public String getProofOfAddress() {
		return proofOfAddress;
	}


	public void setProofOfAddress(String proofOfAddress) {
		this.proofOfAddress = proofOfAddress;
	}


	public FileDetails getImage() {
		return image;
	}


	public void setImage(FileDetails image) {
		this.image = image;
	}


	public String getProofOfId() {
		return proofOfId;
	}


	public void setProofOfId(String proofOfId) {
		this.proofOfId = proofOfId;
	}


	public FileDetails getImage1() {
		return image1;
	}


	public void setImage1(FileDetails image1) {
		this.image1 = image1;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

}
