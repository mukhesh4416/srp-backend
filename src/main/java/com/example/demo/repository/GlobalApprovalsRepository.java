package com.example.demo.repository;

public interface GlobalApprovalsRepository{

	void updateTaskSubmitStatus(int taskId);
	void updateBugSubmitStatus(int bugId);
}
