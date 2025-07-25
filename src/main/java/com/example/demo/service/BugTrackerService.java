package com.example.demo.service;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BugTrackerDto;
import com.example.demo.model.BugTrackerEntity;
import com.example.demo.repository.BugTrackerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BugTrackerService {
	
	private final BugTrackerRepository bugTrackerRepository;
	
	public BugTrackerService(BugTrackerRepository bugTrackerRepository){
		this.bugTrackerRepository = bugTrackerRepository;
	}
	
	public List<BugTrackerDto> getAllBugList(){
		return this.bugTrackerRepository.getAllBugsList();
	}
	
	@Async
	public CompletableFuture<String> saveBugData(BugTrackerEntity data){

		String actionMode = data.getActionMode();
		try {

			if("insert".equalsIgnoreCase(actionMode)) {
				BugTrackerEntity entity = new BugTrackerEntity();
				entity.setProject(data.getProject());
				entity.setModule(data.getModule());
				entity.setComponent(data.getComponent());
				entity.setDescription(data.getDescription());
				entity.setCreatedId(data.getCreatedId());
				entity.setBugCode(data.getBugCode());
				entity.setTaskId(data.getTaskId());
				entity.setDeveloperId(data.getDeveloperId());
				entity.setPriority(data.getPriority());
				entity.setSubmitStatus(0);
				
				String code = "BUG/" + Year.now().getValue() + "/" + String.format("%02d", LocalDate.now().getMonthValue());
				String fCode = this.bugTrackerRepository.getBugCodeNo(code);
				if(fCode == null) {
					entity.setBugCode(code + "/001");
				}else {	
					String[] codeArray = fCode.split("/");
					String copyCode  = String.join("/",Arrays.copyOf(codeArray, codeArray.length-1));
					entity.setBugCode(copyCode + "/" + String.format("%03d",(Integer.parseInt(codeArray[codeArray.length - 1]) + 1)));
				}
				entity.setStatus("Pending");
				System.out.println("1-1"+entity);
				this.bugTrackerRepository.save(entity);
				return CompletableFuture.completedFuture("Success");
			}else if("update".equalsIgnoreCase(actionMode)) {
				
				if(this.bugTrackerRepository.existsById(data.getBugId())){
					BugTrackerEntity updateEntity = this.bugTrackerRepository.findById(data.getBugId()).orElseThrow(() -> new EntityNotFoundException("BugTracker not found"));
					updateEntity.setProject(data.getProject());
					updateEntity.setModule(data.getModule());
					updateEntity.setComponent(data.getComponent());
					updateEntity.setDescription(data.getDescription());		
					updateEntity.setPriority(data.getPriority());
					this.bugTrackerRepository.save(updateEntity);
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
	
	@Async
	public CompletableFuture<String> deleteBug(Long bugId){
		try {

			if(!this.bugTrackerRepository.findById(bugId).isEmpty()) {
				this.bugTrackerRepository.deleteById(bugId);;
				return CompletableFuture.completedFuture("Success");
			}else {
				return CompletableFuture.completedFuture("Bug Id Not Found");
			}

		}catch(Exception error) {
			error.printStackTrace();
			return CompletableFuture.completedFuture("Error");
		}
	}
}
