package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.BugTrackerDto;
import com.example.demo.model.BugTrackerEntity;

public interface BugTrackerRepository extends JpaRepository<BugTrackerEntity, Long> {

	
	@Query(value = "SELECT t.bug_code FROM bug_tracker t WHERE t.bug_code LIKE CONCAT(:bugCode, '%') ORDER BY t.bug_id DESC LIMIT 1", nativeQuery = true)
	String getBugCodeNo(@Param("bugCode") String bugCode);
	
	@Query("SELECT new com.example.demo.dto.BugTrackerDto(b.bugId,b.taskId,b.bugCode,b.project,b.module,b.component,b.description,b.developerId,b.createdId,b.status,b.submitStatus,b.createdDate,u.profileName,b.bugCode,v.profileName,b.priority,b.trackerStatus)"
			+ " FROM BugTrackerEntity b LEFT JOIN UserinfoEntity u ON b.createdId = u.uId "
			+ " LEFT JOIN UserinfoEntity v ON b.developerId = v.uId"
			+ " ORDER BY b.bugId ASC")
	List<BugTrackerDto> getAllBugsList();
	
	@Query("SELECT new com.example.demo.dto.BugTrackerDto(b.bugId,b.taskId,b.bugCode,b.project,b.module,b.component,b.description,b.developerId,b.createdId,b.status,b.submitStatus,b.createdDate,u.profileName,b.bugCode,v.profileName,b.priority,b.trackerStatus)"
			+ " FROM BugTrackerEntity b LEFT JOIN UserinfoEntity u ON b.createdId = u.uId "
			+ " LEFT JOIN UserinfoEntity v ON b.developerId = v.uId"
			+ " WHERE b.taskId = :taskId ORDER BY b.bugId ASC")
	List<BugTrackerDto> getAllBugsListByTaskId(@Param("taskId") Long taskId);
}
