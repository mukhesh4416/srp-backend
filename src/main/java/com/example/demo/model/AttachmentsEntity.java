package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "attachments")
public class AttachmentsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attachId;
	
	private Integer uId;
	private Integer refId;
	private String documentName;
	private int createdId;
	private Timestamp createdDate;
	
//	@Lob
	@Column(name = "attach_file")
	private byte[] attachFile;
	
	public AttachmentsEntity() {
		
	}
	
	public AttachmentsEntity(
			Long attachId,
			Integer uId,
			Integer refId,
			String documentName,
			int createdId,
			Timestamp createdDate,
			byte[] attachFile
	) {
		this.attachId = attachId;
		this.uId = uId;
		this.refId = refId;
		this.documentName = documentName;
		this.createdId = createdId;
		this.createdDate = createdDate;
		this.attachFile = attachFile;
	}
	
	public Long getAttachId(){
		return attachId;
	}
	public void setAttachId(Long attachId){
		this.attachId = attachId;
	}
	
	public Integer getUId(){
		return uId;
	}
	public void setUId(Integer uId){
		this.uId = uId;
	}
	
	public Integer getRefId(){
		return refId;
	}
	public void setRefId(Integer refId){
		this.refId = refId;
	}
	
	public String getDocumentName(){
		return documentName;
	}
	public void setDocumentName(String documentName){
		this.documentName = documentName;
	}
	
	public int getCreatedId(){
		return createdId;
	}
	public void setCreatedId(int createdId){
		this.createdId = createdId;
	}
	
	public Timestamp getCreatedDate(){
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate){
		this.createdDate = createdDate;
	}
	
	public byte[] getAttachFile(){
		return attachFile;
	}
	public void setAttachFile(byte[] attachFile){
		this.attachFile = attachFile;
	}
}
