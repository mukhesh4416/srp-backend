package com.example.demo.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "bug_tracker")
public class BugTrackerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bugId;
	
	@Transient
	private String actionMode;
	
	private String bugCode;
	@Transient
	private String uniqueCode;
	private Long taskId;
	private String project;
	private String module;
	private String component;
	private String description;
	private Integer developerId;
	private int createdId;
	private String status;
	private Integer submitStatus;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Timestamp createdDate;
	private String priority;
	private String trackerStatus;
	
	public BugTrackerEntity() {
		
	}
	
	public BugTrackerEntity(
			Long bugId,
			Long taskId,
			String actionMode,
			String bugCode,
			String uniqueCode,
			String project,
			String module,
			String component,
			String description,
			Integer developerId,
			int createdId,
			String status,
			Integer submitStatus,
			Timestamp createdDate,
			String priority,
			String trackerStatus
	) {
		this.bugId = bugId;
		this.taskId = taskId;
		this.actionMode = actionMode;
		this.bugCode = bugCode;
		this.uniqueCode = uniqueCode;
		this.project = project;
		this.module = module;
		this.component = component;
		this.description = description;
		this.developerId = developerId;
		this.createdId = createdId;
		this.status = status;
		this.submitStatus = submitStatus;
		this.createdDate = createdDate;
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
	
	public String getActionMode() {
		return actionMode;
	}
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	
	public String getBugCode() {
		return bugCode;
	}
	public void setBugCode(String bugCode) {
		this.bugCode = bugCode;
	}
	
	public String getUniqueCode() {
		return bugCode;
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
