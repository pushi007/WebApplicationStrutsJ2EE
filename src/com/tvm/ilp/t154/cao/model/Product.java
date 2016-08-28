/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

import java.util.Date;

/**
 * @author 664972
 * 
 */
public class Product {

	private long productID;
	private String productName;
	private String productDescription;
	private String accountType;
	private String productStatus;
	private String productValidFrom;

	public Product(long productID, String productName,
			String productDescription, String accountType,
			String productStatus, String productValidFrom) {

		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.accountType = accountType;
		this.productStatus = productStatus;
		this.productValidFrom = productValidFrom;
	}

	public Product() {

	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductValidFrom() {
		return productValidFrom;
	}

	public void setProductValidFrom(String productValidFrom) {
		this.productValidFrom = productValidFrom;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
