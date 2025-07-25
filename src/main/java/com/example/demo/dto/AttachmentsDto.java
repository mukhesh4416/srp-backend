package com.example.demo.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AttachmentsDto {
	
	private Long attachId;
	private Integer uId;
	private Integer refId;
	private String documentName;
	private byte[] attachFile;
	private int createdId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Timestamp createdDate;
	private String createdBy;
	
	public AttachmentsDto(Long attachId, Integer uId, Integer refId, String documentName, byte[] attachFile, int createdId,
			Timestamp createdDate, String createdBy) {
		super();
		this.attachId = attachId;
		this.uId = uId;
		this.refId = refId;
		this.documentName = documentName;
		this.attachFile = attachFile;
		this.createdId = createdId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Long getAttachId() {
		return attachId;
	}

	public void setAttachId(Long attachId) {
		this.attachId = attachId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	public byte[] getAttachFile() {
		return attachFile;
	}
 
	public void setAttachFile(byte[] attachFile) {
		this.attachFile = attachFile;
	}
	
	public int getCreatedId() {
		return createdId;
	}

	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
