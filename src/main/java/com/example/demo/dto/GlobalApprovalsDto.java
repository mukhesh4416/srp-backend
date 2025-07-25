package com.example.demo.dto;

public class GlobalApprovalsDto {
	
	String actionMode;
	int refId;
	
	public GlobalApprovalsDto() {
		
	}

	public GlobalApprovalsDto(
			String actionMode,
			int refId
	) {
		this.actionMode = actionMode;
		this.refId = refId;
	}
	
	public String getActionMode() {
		return actionMode;
	}
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	
	public int getRefId() {
		return refId;
	}
	public void setRefId(int refId) {
		this.refId = refId;
	}
}
