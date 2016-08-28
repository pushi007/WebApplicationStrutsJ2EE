/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 597142
 *
 */
public class FileDetails
{

	private String contenttype;
	private byte[] image;
	private byte[] image1;
	
	public byte[] getImage1() {
		return image1;
	}
	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

}
