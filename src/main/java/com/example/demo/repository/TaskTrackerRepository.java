package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.TaskTrackerDto;
import com.example.demo.model.BugTrackerEntity;
import com.example.demo.model.TaskTrackerEntity;

public interface TaskTrackerRepository extends JpaRepository<TaskTrackerEntity, Long>{

	
	@Query(value = "SELECT t.task_code FROM task_tracker t WHERE t.task_code LIKE CONCAT(:taskCode, '%') ORDER BY t.task_id DESC LIMIT 1", nativeQuery = true)
	String getTaskCodeNo(@Param("taskCode") String taskCode);
	
	@Query(value = "select * from bug_tracker where task_id = :taskId order by bug_id", nativeQuery = true)
	List<BugTrackerEntity> getBugsByTaskId(@Param("taskId") Long taskId);
	
	
	@Query("SELECT new com.example.demo.dto.TaskTrackerDto(" +
		       "t.taskId, t.taskCode, t.project, t.module, t.component, t.description, " +
		       "t.testerId, t.createdId, t.status, t.submitStatus, t.createdDate, u.profileName, t.taskCode,v.profileName, t.priority, t.trackerStatus ) " +
		       "FROM TaskTrackerEntity t LEFT JOIN UserinfoEntity u ON t.createdId = u.uId "
		       + " LEFT JOIN UserinfoEntity v ON t.testerId = v.uId ORDER BY t.taskId ASC")
	List<TaskTrackerDto> getAllTaskList();
}
