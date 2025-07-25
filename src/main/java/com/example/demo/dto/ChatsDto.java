package com.example.demo.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChatsDto {
	private Long chatId;
	private Integer uId;
	private int refId;
	private String message;
	private int createdId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy  HH:mm:ss", timezone = "Asia/Kolkata")
	private Timestamp createdDate;
	private String createdBy;
	
	public ChatsDto(){
	}

	public ChatsDto(Long chatId, Integer uId, int refId, String message, int createdId, Timestamp createdDate,
			String createdBy) {
		super();
		this.chatId = chatId;
		this.uId = uId;
		this.refId = refId;
		this.message = message;
		this.createdId = createdId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
