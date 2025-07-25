package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectsDto;
import com.example.demo.model.ProjectsEntity;
import com.example.demo.repository.ProjectsRepository;

@Service
public class ProjectsService {

	private final ProjectsRepository projectsRepository;
	
	public ProjectsService(ProjectsRepository projectsRepository) {
		this.projectsRepository = projectsRepository;
	}
	
	public List<ProjectsDto> getAllProjects(){
		return this.projectsRepository.getAllProjectsList();
	}
	
	@Async
	public CompletableFuture<String> saveProjetName(ProjectsEntity data){
		try {
			this.projectsRepository.save(data);
			return CompletableFuture.completedFuture("Success");
		}catch(Exception error) {
			error.printStackTrace();
			return CompletableFuture.completedFuture("Error");
		}
	}
	
	@Async
	public CompletableFuture<String> deleteProjectName(Long projId){
		try {
			Optional<ProjectsEntity> projects = this.projectsRepository.findById(projId);
			if(projects.isPresent()) {
				this.projectsRepository.deleteById(projId);;
				return CompletableFuture.completedFuture("Success");
			}else {
				return CompletableFuture.completedFuture("Project Id Not Found");
			}

		}catch(Exception error) {
			error.printStackTrace();
			return CompletableFuture.completedFuture("Error");
		}
	}
	
}
