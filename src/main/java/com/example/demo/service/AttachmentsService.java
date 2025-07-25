package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AttachmentsDto;
import com.example.demo.model.AttachmentsEntity;
import com.example.demo.repository.AttachmentsRepository;

@Service
public class AttachmentsService {

	private final AttachmentsRepository attachmentsRepository;
	
	public AttachmentsService(AttachmentsRepository attachmentsRepository) {
		this.attachmentsRepository = attachmentsRepository;
	}
	
	public CompletableFuture<String> saveAttachments(MultipartFile file, AttachmentsEntity model){
	    try {
	        AttachmentsEntity attachment = new AttachmentsEntity();

	        attachment.setUId(model.getUId());
	        attachment.setRefId(model.getRefId());
	        attachment.setDocumentName(model.getDocumentName());
	        attachment.setCreatedId(model.getCreatedId());
	        attachment.setAttachFile(file.getBytes());
	        attachmentsRepository.save(attachment);

	        return CompletableFuture.completedFuture("Success");
	    } catch (IOException e) {
	        e.printStackTrace();  // For debugging
	        return CompletableFuture.completedFuture("Failed");
	    }
	}
	
	public List<AttachmentsDto> getAllAttachmentsList(Integer refId){
		return this.attachmentsRepository.getAllAttachmentsList(refId);
	}
	
	public String deleteAttachment(Long attachId){
		this.attachmentsRepository.deleteById(attachId);
		return "Success";
	}
}
