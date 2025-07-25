package com.example.demo.model;


import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "chats")
public class ChatsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chatId;
	private Integer uId;
	private int refId;
	private String message;
	private int createdId;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy  HH:mm:ss", timezone = "Asia/Kolkata")
	private Timestamp createdDate;
	
	public ChatsEntity() {
		
	}
	
	public ChatsEntity(
			Long chatId,
			Integer uId,
			int refId,
			String message,
			int createdId,
			Timestamp createdDate	
	) {
		this.chatId = chatId;
		this.uId = uId;
		this.refId = refId;
		this.message = message;
		this.createdId = createdId;
		this.createdDate = createdDate;
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
	
}
