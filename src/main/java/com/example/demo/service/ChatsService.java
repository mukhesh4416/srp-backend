package com.example.demo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChatsDto;
import com.example.demo.model.ChatsEntity;
import com.example.demo.repository.ChatsRepository;

@Service
public class ChatsService {
	
	@Autowired
	private final ChatsRepository chatsRepository;
	
	public ChatsService(ChatsRepository chatsRepository) {
		this.chatsRepository = chatsRepository;
	}
	
	public List<ChatsDto> getChatList(int refId){
		return this.chatsRepository.getAllChatByRefId(refId);
	}

	@Async
	public CompletableFuture<String> saveChatMessage(ChatsEntity data){
		try {
			this.chatsRepository.save(data);
			return CompletableFuture.completedFuture("Success");
		}catch(Exception error) {
			error.printStackTrace();
			return CompletableFuture.completedFuture("Error");
		}
	}
}
