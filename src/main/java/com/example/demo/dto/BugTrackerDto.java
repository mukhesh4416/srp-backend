package com.example.demo.dto;

import java.sql.Timestamp;

public class BugTrackerDto {
	private Long bugId;
	private Long taskId;
	private String bugCode;
	private String project;
	private String module;
	private String component;
	private String description;
	private Integer developerId;
	private int createdId;
	private String status;
	private Integer submitStatus;
	private Timestamp createdDate;
	private String createdBy;
	private String uniqueCode;
	private String developerName;
	private String type = "Bug";
	private String priority;
	private String trackerStatus;
	
	public BugTrackerDto(
			Long bugId,
			Long taskId,
			String bugCode,
			String project,
			String module,
			String component,
			String description,
			Integer developerId,
			int createdId,
			String status,
			Integer submitStatus,
			Timestamp createdDate,
			String createdBy,
			String uniqueCode,
			String developerName,
			String priority,
			String trackerStatus
	) {
		this.bugId = bugId;
		this.taskId = taskId;
		this.bugCode = bugCode;
		this.project = project;
		this.module = module;
		this.component = component;
		this.description = description;
		this.developerId = developerId;
		this.createdId = createdId;
		this.status = status;
		this.submitStatus = submitStatus;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.uniqueCode = uniqueCode;
		this.developerName = developerName;
		this.priority = priority;
		this.trackerStatus = trackerStatus;
	}
	
	public Long getBugId() {
		return bugId;
	}
	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public String getBugCode() {
		return bugCode;
	}
	public void setBugCode(String bugCode) {
		this.bugCode = bugCode;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
	
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getSubmitStatus() {
		return submitStatus;
	}
	public void setSubmitStatus(Integer submitStatus) {
		this.submitStatus = submitStatus;
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
	
	public String getUniqueCode() {
		return uniqueCode;
	}
	
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	
	public String getType() {
        return type;
    }

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTrackerStatus() {
		return trackerStatus;
	}

	public void setTrackerStatus(String trackerStatus) {
		this.trackerStatus = trackerStatus;
	}
	
	
	
	
}
