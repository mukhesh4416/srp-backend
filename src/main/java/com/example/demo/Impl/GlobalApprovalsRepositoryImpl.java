package com.example.demo.Impl;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.GlobalApprovalsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class GlobalApprovalsRepositoryImpl implements GlobalApprovalsRepository{

	 @PersistenceContext
	 private EntityManager entityManager;

	 @Override
	 public void updateTaskSubmitStatus(int taskId) {
	     String sql = "UPDATE task_tracker SET submit_status = 1 WHERE task_id = :taskId";
	     entityManager.createNativeQuery(sql)
	     				.setParameter("taskId", taskId)
	     				.executeUpdate();
	 }
	 
	 @Override
	 public void updateBugSubmitStatus(int bugId) {
		 String sql = "UPDATE bug_tracker SET submit_status = 1 WHERE bug_id = :bugId";
	     entityManager.createNativeQuery(sql)
	     				.setParameter("bugId", bugId)
	     				.executeUpdate();
	 }
}
