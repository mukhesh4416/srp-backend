package com.example.demo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserinfoDto;
import com.example.demo.model.UserinfoEntity;
import com.example.demo.repository.UserinfoRepository;

@Service
public class UserinfoService {
	
	private final UserinfoRepository userinfoRepository;
	
	public UserinfoService(UserinfoRepository userinfoRepository) {
		this.userinfoRepository = userinfoRepository;
	}

	public List<UserinfoEntity> getuserinfo(){
		return userinfoRepository.findAll();
	}
	
	public List<UserinfoDto> getAllTesters(){
		return userinfoRepository.getTestList();
	}
	
	public List<UserinfoDto> getAllDevelopers(){
		return userinfoRepository.getDevelopersList();
	}
	
	@Async
	public CompletableFuture<String> saveUser(UserinfoEntity data){
		if("insert".equals(data.getActionMode())) {
			this.userinfoRepository.save(data);
		}
		return CompletableFuture.completedFuture("Success");
	}
	
	@Async
	public CompletableFuture<String> deleteUser(Long id){
		if(!this.userinfoRepository.findById(id).isEmpty()) {
			this.userinfoRepository.deleteById(id);
			return CompletableFuture.completedFuture("Sucess");
		}else {
			return CompletableFuture.completedFuture("Failure - User does not exist");
		}
	}
	
	public UserinfoEntity loginUser(String userName,String password) {
		try {
			List<UserinfoEntity> data = this.userinfoRepository.getUserLogin(userName,password);
			if(this.userinfoRepository.getUserLogin(userName,password).isEmpty()) {
				return data.get(0);
			}else {
				return data.get(0);
			}
		}catch(Exception e){		
			 e.printStackTrace(); // Logs the error
//			 return "An error occurred while logging in";	
		}
		return null;
		
	}
	
}
