package com.example.demo.dto;

import java.sql.Timestamp;


public class TaskTrackerDto {

	private Long taskId;
	private String taskCode;
	private String project;
	private String module;
	private String component;
	private String description;
	private Integer testerId;
	private Integer createdId;
	private String status;
	private Integer submitStatus;
	private Timestamp createdDate;
	private String createdBy;
	private String uniqueCode;
	private String testerName;
	private String type = "Task";
	private String priority;
	private String trackerStatus;
	
	public TaskTrackerDto() {
	}
	
	public TaskTrackerDto(
			Long taskId,
			String taskCode,
			String project,
			String module,
			String component,
			String description,
			Integer testerId,
			Integer createdId,
			String status,
			Integer submitStatus,
			Timestamp createdDate,
			String createdBy,
			String uniqueCode,
			String testerName,
			String priority,
			String trackerStatus
	) {
		this.taskId = taskId;
		this.taskCode = taskCode;
		this.project = project;
		this.module = module;
		this.component = component;
		this.description = description;
		this.testerId = testerId;
		this.createdId = createdId;
		this.status = status;
		this.submitStatus = submitStatus;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.uniqueCode = uniqueCode;
		this.testerName = testerName;
		this.priority = priority;
		this.trackerStatus = trackerStatus;
	}
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
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
	
	public Integer getTesterId() {
		return testerId;
	}
	public void setTesterId(Integer testerId) {
		this.testerId = testerId;
	}
	
	public Integer getCreatedId() {
		return createdId;
	}
	public void setCreatedId(Integer createdId) {
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

	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
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
