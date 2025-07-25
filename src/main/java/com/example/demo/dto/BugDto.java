package com.example.demo.dto;

import java.util.List;

public class BugDto {
	String key;
	BugTrackerDto data;
	List<BugTrackerDto> children;
	String type = "Bug";
	
	public BugDto() {
		
	}
	
	public BugDto(String key,BugTrackerDto data,List<BugTrackerDto> children,String type){
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

	public BugTrackerDto getData() {
		return data;
	}
	public void setData(BugTrackerDto data) {
		this.data = data;
	}
	
	public List<BugTrackerDto> getChildren() {
		return children;
	}
	public void setChildren(List<BugTrackerDto> children) {
		this.children = children;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
