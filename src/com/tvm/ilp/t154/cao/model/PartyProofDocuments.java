/**
 * 
 */
package com.tvm.ilp.t154.cao.model;

/**
 * @author 583036
 *
 */
public class PartyProofDocuments {
	private long partyId;
	private String documentType;
	private String document;
	private String submitDate;
	private String status;
	public long getPartyId() {
		return partyId;
	}
	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PartyProofDocuments() {
		
	}
	public PartyProofDocuments(long partyId, String documentType,
			String document, String submitDate, String status) {
		super();
		this.partyId = partyId;
		this.documentType = documentType;
		this.document = document;
		this.submitDate = submitDate;
		this.status = status;
	}


}
