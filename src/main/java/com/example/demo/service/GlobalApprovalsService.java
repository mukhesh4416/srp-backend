package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GlobalApprovalsDto;
import com.example.demo.repository.GlobalApprovalsRepository;


@Service
public class GlobalApprovalsService {
	
	private final GlobalApprovalsRepository globalApprovalsRepository;
	
	public GlobalApprovalsService(GlobalApprovalsRepository globalApprovalsRepository) {
		this.globalApprovalsRepository = globalApprovalsRepository;
	}
	
	
	public CompletableFuture<String> globalApprovals(GlobalApprovalsDto data){
		
		try {
			
			switch(data.getActionMode()){
				case "Task_Submit":
					this.globalApprovalsRepository.updateTaskSubmitStatus(data.getRefId());
					return CompletableFuture.completedFuture("Success");
				case "Bug_Submit":
					this.globalApprovalsRepository.updateBugSubmitStatus(data.getRefId());
					return CompletableFuture.completedFuture("Success");
				default:
					return CompletableFuture.completedFuture("ActionMode Mismatch");
			}
			
		}catch(Exception error) {
			error.printStackTrace();
			throw new RuntimeException(error);
		}
	}
	

}
