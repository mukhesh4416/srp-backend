package com.example.demo.dto;

import java.util.List;

public class TaskBugDto {
	
	String key;
	TaskTrackerDto data;
	List<BugDto> children;
	String type = "Task";
	
	public TaskBugDto() {
		
	}
	
	public TaskBugDto(String key,TaskTrackerDto data,List<BugDto> children, String type){
		this.key = key;
		this.data = data;
		this.children = children;
		this.type = type;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public TaskTrackerDto getData() {
		return data;
	}
	public void setData(TaskTrackerDto data) {
		this.data = data;
	}
	
	public List<BugDto> getChildren() {
		return children;
	}
	public void setChildren(List<BugDto> children) {
		this.children = children;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
