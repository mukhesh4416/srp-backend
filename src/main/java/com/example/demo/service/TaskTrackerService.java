package com.example.demo.service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BugDto;
import com.example.demo.dto.BugTrackerDto;
import com.example.demo.dto.TaskBugDto;
import com.example.demo.dto.TaskTrackerDto;
import com.example.demo.model.TaskTrackerEntity;
import com.example.demo.repository.BugTrackerRepository;
import com.example.demo.repository.TaskTrackerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskTrackerService {

	private final TaskTrackerRepository taskTrackerRepository;
	private final BugTrackerRepository bugTrackerRepository;
	
	public TaskTrackerService(TaskTrackerRepository taskTrackerRepository,BugTrackerRepository bugTrackerRepository){
		this.taskTrackerRepository = taskTrackerRepository;
		this.bugTrackerRepository = bugTrackerRepository;
	}
	
	public List<TaskBugDto> getAllTrackingList(){
		
		List<TaskBugDto> finalList = new ArrayList<>();
		List<TaskTrackerDto> taskList = this.taskTrackerRepository.getAllTaskList();
		
		int i = 0;
		for(TaskTrackerDto task:taskList) {
			TaskBugDto parent = new TaskBugDto();
			parent.setKey(String.valueOf(i));
			parent.setData(task);
			int j = 0;
			List<BugDto> finalBugList = new ArrayList<>();
			List<BugTrackerDto> bugList = this.bugTrackerRepository.getAllBugsListByTaskId(task.getTaskId());
			for(BugTrackerDto bug:bugList) {	
				BugDto child = new BugDto();
				child.setKey(String.valueOf(i) + '-' + String.valueOf(j));
				child.setData(bug);
				j = j + 1;
				finalBugList.add(child);
			}
			parent.setChildren(finalBugList);
			i = i+1;
			finalList.add(parent);
		}	
		return finalList;
	}
	
	
	@Async
	public CompletableFuture<String> saveTaskData(TaskTrackerEntity data){
		String actionMode = data.getActionMode();
			
		try {
			if("insert".equalsIgnoreCase(actionMode)) {
				TaskTrackerEntity entity = new TaskTrackerEntity();
				entity.setProject(data.getProject());
				entity.setModule(data.getModule());
				entity.setComponent(data.getComponent());
				entity.setDescription(data.getDescription());
				entity.setCreatedId(data.getCreatedId());
				entity.setTaskCode(data.getTaskCode());
				entity.setTesterId(data.getTesterId());
				entity.setPriority(data.getPriority());
				entity.setSubmitStatus(0);
				
				String code = "TASK/" + Year.now().getValue() + "/" + String.format("%02d", LocalDate.now().getMonthValue());
				String fCode = this.taskTrackerRepository.getTaskCodeNo(code);
				if(fCode == null) {
					entity.setTaskCode(code + "/001");
				}else {	
					String[] codeArray = fCode.split("/");
					String copyCode  = String.join("/",Arrays.copyOf(codeArray, codeArray.length-1));
					entity.setTaskCode(copyCode + "/" + String.format("%03d",(Integer.parseInt(codeArray[codeArray.length - 1]) + 1)));
				}
				entity.setStatus("Pending");			
				this.taskTrackerRepository.save(entity);
				return CompletableFuture.completedFuture("Success");
				
			}else if("update".equalsIgnoreCase(actionMode)) {	
						
				if(this.taskTrackerRepository.existsById(data.getTaskId())){
					TaskTrackerEntity updateEntity = this.taskTrackerRepository.findById(data.getTaskId()).orElseThrow(() -> new EntityNotFoundException("TaskTracker not found"));
					updateEntity.setProject(data.getProject());
					updateEntity.setModule(data.getModule());
					updateEntity.setComponent(data.getComponent());
					updateEntity.setDescription(data.getDescription());	
					updateEntity.setPriority(data.getPriority());
					this.taskTrackerRepository.save(updateEntity);
					return CompletableFuture.completedFuture("Success");
				}else {
					 throw new EntityNotFoundException("TaskTracker not found");
				}
				
			}else {
				return CompletableFuture.completedFuture("Failed");
			}
		
		}catch(Exception error) {
			error.printStackTrace();
		}
		return null; 
	}
	
	public List<TaskTrackerDto> getAllTaskList(){
		return this.taskTrackerRepository.getAllTaskList();
	}
	
	
	@Async
	public CompletableFuture<String> deleteTask(Long taskId){
		try {

			if(!this.taskTrackerRepository.findById(taskId).isEmpty()) {
				this.taskTrackerRepository.deleteById(taskId);;
				return CompletableFuture.completedFuture("Success");
			}else {
				return CompletableFuture.completedFuture("Task Id Not Found");
			}

		}catch(Exception error) {
			error.printStackTrace();
			return CompletableFuture.completedFuture("Error");
		}
	}
}
