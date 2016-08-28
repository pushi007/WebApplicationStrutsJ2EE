/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 741226
 * 
 */
public class RelationshipManager {
	private long rmId;
	private int npId;
	private String branchId;
	private String title;
	private String firstName;
	private String lastName;

	public RelationshipManager() {

	}

	public RelationshipManager(long rmId, int npId, String branchId,
			String title, String firstName, String lastName) {

		this.rmId = rmId;
		this.npId = npId;
		this.branchId = branchId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}

	public long getRmId() {
		return rmId;
	}

	public void setRmId(long rmId) {
		this.rmId = rmId;
	}

	public int getNpId() {
		return npId;
	}

	public void setNpId(int npId) {
		this.npId = npId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
