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
public class Employee {
private int empId;
private String title;
private String firstNm;
private String middleNm;
private String lastNm;
private String dateOfBirth;
private String address;
private long contactno;
private long altContactNo;
private String emailId;
private String dateOfJoin;
private String designation;
private List<String> groups=new ArrayList<String>();

private String password;
private String securityQues;
private String answer;


String dateOfLeave;
String reasonOfLeave;
String status;

String branchName;

public Employee() {
	
	}

public Employee(int empId, String title, String firstNm, String middleNm,
			String lastNm, String designation, String password) {
		this.empId = empId;
		this.title = title;
		this.firstNm = firstNm;
		this.middleNm = middleNm;
		this.lastNm = lastNm;
		this.designation = designation;
		this.password = password;
	}

/**
 * Getters and Setters
 * 
 */

public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getFirstNm() {
	return firstNm;
}
public void setFirstNm(String firstNm) {
	this.firstNm = firstNm;
}
public String getMiddleNm() {
	return middleNm;
}
public void setMiddleNm(String middleNm) {
	this.middleNm = middleNm;
}
public String getLastNm() {
	return lastNm;
}
public void setLastNm(String lastNm) {
	this.lastNm = lastNm;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getContactno() {
	return contactno;
}
public void setContactno(long contactno) {
	this.contactno = contactno;
}
public long getAltContactNo() {
	return altContactNo;
}
public void setAltContactNo(long altContactNo) {
	this.altContactNo = altContactNo;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getDateOfJoin() {
	return dateOfJoin;
}
public void setDateOfJoin(String dateOfJoin) {
	this.dateOfJoin = dateOfJoin;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public List<String> getGroups() {
	return groups;
}
public void setGroups(List<String> groups) {
	this.groups = groups;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public void setSecurityQues(String securityQues) {
	this.securityQues = securityQues;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getDateOfLeave() {
	return dateOfLeave;
}
public void setDateOfLeave(String dateOfLeave) {
	this.dateOfLeave = dateOfLeave;
}
public String getReasonOfLeave() {
	return reasonOfLeave;
}
public void setReasonOfLeave(String reasonOfLeave) {
	this.reasonOfLeave = reasonOfLeave;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}

public String getSecurityQues() {
	return securityQues;
}



}
