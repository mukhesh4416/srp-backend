package com.example.demo.dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectsDto {
	
	private Long projId;
	private String projName;
	private int createdId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Date createdDate;
	private String createdBy;
	
	public ProjectsDto() {
		
	}
	
	public ProjectsDto(Long projId, String projName, int createdId, Date createdDate, String createdBy) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.createdId = createdId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
