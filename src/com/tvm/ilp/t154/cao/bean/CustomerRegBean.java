/**
 * 
 */
package com.tvm.ilp.t154.cao.bean;

import com.tvm.ilp.t154.cao.model.FileDetails;

/**
 * @author 597142
 *
 */
public class CustomerRegBean 
{
	private Long custid;
	private FileDetails image;
	private FileDetails image1;
	private String idproof;
	private String addproof;




	public String getIdproof() {
		return idproof;
	}
	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}
	public String getAddproof() {
		return addproof;
	}
	public void setAddproof(String addproof) {
		this.addproof = addproof;
	}
	public long getCustid() {
		return custid;
	}
	public FileDetails getImage1() {
		return image1;
	}
	public void setImage1(FileDetails image1) {
		this.image1 = image1;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	public FileDetails getImage() {
		return image;
	}
	public void setImage(FileDetails image) {
		this.image = image;
	}


}
