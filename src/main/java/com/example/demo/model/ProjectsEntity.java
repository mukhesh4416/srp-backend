package com.example.demo.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class ProjectsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projId;
	
	private String projName;
	private int createdId;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Date createdDate;
	
	public ProjectsEntity() {
		
	}
	
	public ProjectsEntity(Long projId, String projName, int createdId, Date createdDate) {
		this.projId = projId;
		this.projName = projName;
		this.createdId = createdId;
		this.createdDate = createdDate;
	}
	
	public Long getProjId() {
		return projId;
	}
	
	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
	public String getProjName() {
		return projName;
	}
	
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	public int getCreatedId() {
		return createdId;
	}
	
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
