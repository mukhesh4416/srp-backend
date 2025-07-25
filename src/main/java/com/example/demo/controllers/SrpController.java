package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AttachmentsDto;
import com.example.demo.dto.ChatsDto;
import com.example.demo.dto.GlobalApprovalsDto;
import com.example.demo.dto.ProjectsDto;
import com.example.demo.dto.UserinfoDto;
import com.example.demo.model.AttachmentsEntity;
import com.example.demo.model.ChatsEntity;
import com.example.demo.model.ProjectsEntity;
import com.example.demo.model.UserinfoEntity;
import com.example.demo.service.AttachmentsService;
import com.example.demo.service.ChatsService;
import com.example.demo.service.GlobalApprovalsService;
import com.example.demo.service.ProjectsService;
import com.example.demo.service.UserinfoService;


@CrossOrigin(origins = {"http://localhost:5173", "http://192.168.77.247:5173", "http://192.168.77.199:5173"})
@RestController
@RequestMapping("/srp")
public class SrpController {

	private final UserinfoService userinfoService;
	private final ProjectsService projectsService;
	private final GlobalApprovalsService globalApprovalsService;
	private final ChatsService chatsService;
	private final AttachmentsService attachmentsService;
	
	public SrpController(
			UserinfoService userinfoService,
			ProjectsService projectsService,
			GlobalApprovalsService globalApprovalsService,
			ChatsService chatsService,
			AttachmentsService attachmentsService
	) {
		this.userinfoService = userinfoService;
		this.projectsService = projectsService;
		this.globalApprovalsService = globalApprovalsService;
		this.chatsService = chatsService;
		this.attachmentsService = attachmentsService;
	}
	
	@PostMapping("/loginUser")
	public UserinfoEntity getUserLogin(@RequestParam("userName") String userName, @RequestParam("password") String password){
		return this.userinfoService.loginUser(userName, password);
	}
	
	@GetMapping("/getAllUsers")
	public List<UserinfoEntity> getAllusersinfo(){
		return this.userinfoService.getuserinfo();
	}
	
	@PostMapping("/saveUser")
	public CompletableFuture<String> saveUser(@RequestBody UserinfoEntity user){
		return this.userinfoService.saveUser(user);
	}
	
	@DeleteMapping("/deleteUser")
	public CompletableFuture<String> deleteUser(@RequestParam("uId") Long uId){
		return this.userinfoService.deleteUser(uId);
	}
	
	@GetMapping("/getAllTesters")
	public List<UserinfoDto> getAllTesters(){
		return this.userinfoService.getAllTesters();
	}
	
	@GetMapping("/getAllDevelopers")
	public List<UserinfoDto> getAllDevelopers(){
		return this.userinfoService.getAllDevelopers();
	}
	
	//Projects Servicess
	@GetMapping("/getAllProjectsList")
	public List<ProjectsDto> getAllProjects(){
		return this.projectsService.getAllProjects();
	}
	
	@PostMapping("/saveProjectName")
	public CompletableFuture<String> saveProjectName(@RequestBody ProjectsEntity data) {
		return this.projectsService.saveProjetName(data);
	}
	
	@DeleteMapping("/deleteProjectById")
	public CompletableFuture<String> deleteProjectName(@RequestParam("projId") Long projId){
		return this.projectsService.deleteProjectName(projId);
	}
	
	@PostMapping("/update/any/globalApprovals")
	public CompletableFuture<String> globalApprovals(@RequestBody GlobalApprovalsDto data) {
		return this.globalApprovalsService.globalApprovals(data);
	}
	
	//Chat Services
	@GetMapping("/getChatList")
	public List<ChatsDto> getChatList(@RequestParam("refId") int refId){
		return this.chatsService.getChatList(refId);
	}
	
	@PostMapping("/saveChatMessage")
	public CompletableFuture<String> saveChatMessage(@RequestBody ChatsEntity data) {
		return this.chatsService.saveChatMessage(data);
	}
	
//	Attachments
	@PostMapping("/uploadAttachment")
	public CompletableFuture<String> uploadAttachment(@RequestParam("file") MultipartFile file,@ModelAttribute AttachmentsEntity model) {
	    return this.attachmentsService.saveAttachments(file, model);
	}
	
	@GetMapping("/getAllAttachmentsList")
	public List<AttachmentsDto> getAllAttachmentsList(@RequestParam("refId") Integer refId){
		return this.attachmentsService.getAllAttachmentsList(refId);
	}
	
	@DeleteMapping("/deleteAttachment")
	public String deleteAttachment(@RequestParam("attachId") Long attachId){
		return this.attachmentsService.deleteAttachment(attachId);
	}
}
