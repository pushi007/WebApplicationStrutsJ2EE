/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

import java.util.Date;

/**
 * @author 597142
 *
 */
public class AdditionalProduct {

	private long additionalProductId;
	private String name;
	
    public AdditionalProduct() 
    {
		
	}
	public AdditionalProduct(long additionalProductId, String name) 
	{
		this.additionalProductId = additionalProductId;
		this.name = name;
	}
	
	public long getAdditionalProductId() {
		return additionalProductId;
	}
	public void setAdditionalProductId(long additionalProductId) {
		this.additionalProductId = additionalProductId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
