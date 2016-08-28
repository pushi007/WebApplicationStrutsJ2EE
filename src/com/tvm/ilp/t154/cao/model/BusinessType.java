/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 582976
 *
 */
public class BusinessType {
private String businessType;

private String businessType_name;

public BusinessType() {

}

public BusinessType(String businessTypeName) {

	businessType_name = businessTypeName;
}

public String getBusinessType_name() {
	return businessType_name;
}

public void setBusinessType_name(String businessTypeName) {
	businessType_name = businessTypeName;
}

public String getBusinessType() {
	return businessType;
}

public void setBusinessType(String businessType) {
	this.businessType = businessType;
}

}
