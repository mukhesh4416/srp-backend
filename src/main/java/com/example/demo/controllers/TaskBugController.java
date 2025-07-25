package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BugTrackerDto;
import com.example.demo.dto.TaskBugDto;
import com.example.demo.dto.TaskTrackerDto;
import com.example.demo.model.BugTrackerEntity;
import com.example.demo.model.TaskTrackerEntity;
import com.example.demo.service.BugTrackerService;
import com.example.demo.service.TaskTrackerService;

@CrossOrigin(origins = {"http://localhost:5173", "http://192.168.77.247:5173", "http://192.168.77.199:5173"})
@RestController
@RequestMapping("/tracker")
public class TaskBugController {

    private final TaskTrackerService taskTrackerService;
    private final BugTrackerService bugTrackerService;


    TaskBugController(TaskTrackerService taskTrackerService, BugTrackerService bugTrackerService) {
        this.taskTrackerService = taskTrackerService;
        this.bugTrackerService = bugTrackerService;
    }

    @PostMapping("/getAllTrackingList")
    public List<TaskBugDto> getAllTrackingList(@RequestBody TaskTrackerEntity data){
    	return this.taskTrackerService.getAllTrackingList();
    }
	
	@PostMapping("/saveTaskData")
	public CompletableFuture<String> saveTaskData(@RequestBody TaskTrackerEntity data){
		return this.taskTrackerService.saveTaskData(data);
	}
	
    @PostMapping("/getAllTaskList")
    public List<TaskTrackerDto> getAllTaskList(@RequestBody TaskTrackerEntity data){
    	return this.taskTrackerService.getAllTaskList();
    }
    
    @PostMapping("/getAllBugList")
    public List<BugTrackerDto> getAllBugList(@RequestBody BugTrackerEntity data){
    	return this.bugTrackerService.getAllBugList();
    }
    
	@PostMapping("/saveBugData")
	public CompletableFuture<String> saveBugData(@RequestBody BugTrackerEntity data){
		return this.bugTrackerService.saveBugData(data);
	}
	
	@DeleteMapping("/deleteTask")
	public CompletableFuture<String> deleteTask(@RequestParam("taskId") Long taskId){
		return this.taskTrackerService.deleteTask(taskId);
	}
	
	@DeleteMapping("/deleteBug")
	public CompletableFuture<String> deleteBug(@RequestParam("bugId") Long bugId){
		return this.bugTrackerService.deleteBug(bugId);
	}
}
