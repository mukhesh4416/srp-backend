package com.example.demo.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "task_tracker")
public class TaskTrackerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@Transient
	private String actionMode;
	
	private String taskCode;
	@Transient
	private String uniqueCode;
	private String project;
	private String module;
	private String component;
	private String description;
	private Integer testerId;
	private Integer createdId;
	private String status;
	private Integer submitStatus;
	private String trackerStatus;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Timestamp createdDate;
	private String priority;
	
	public TaskTrackerEntity() {
		
	}
	
	public TaskTrackerEntity(
			Long taskId,
			String actionMode,
			String taskCode,
			String uniqueCode,
			String project,
			String module,
			String component,
			String description,
			Integer testerId,
			Integer createdId,
			String status,
			Integer submitStatus,
			Timestamp createdDate,
			String priority,
			String trackerStatus
	) {
		this.taskId = taskId;
		this.actionMode = actionMode;
		this.taskCode = taskCode;
		this.uniqueCode = uniqueCode;
		this.project = project;
		this.module = module;
		this.component = component;
		this.description = description;
		this.testerId = testerId;
		this.createdId = createdId;
		this.status = status;
		this.submitStatus = submitStatus;
		this.createdDate = createdDate;
		this.priority = priority;
		this.trackerStatus = trackerStatus;
	}
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public String getActionMode() {
		return actionMode;
	}
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	public String getUniqueCode() {
		return taskCode;
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
