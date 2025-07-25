package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.ProjectsDto;
import com.example.demo.model.ProjectsEntity;

public interface  ProjectsRepository extends JpaRepository<ProjectsEntity, Long> {
	
	@Query("SELECT new com.example.demo.dto.ProjectsDto(p.projId, p.projName, p.createdId, p.createdDate, u.profileName) " +
		       "FROM ProjectsEntity p LEFT JOIN UserinfoEntity u ON p.createdId = u.uId")
	List<ProjectsDto> getAllProjectsList();
}
