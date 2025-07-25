package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_info")
public class UserinfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uId;
	
	@Transient
	private String actionMode;
	
	private String userName;
	private String profileName;
	private String role;
	private String rl;
	private String password;
	private String mailId;
	private String phoneNo;
	
	public UserinfoEntity() {
		
	}
	
	public UserinfoEntity(
			Long uId,
			String userName,
			String profileName,
			String role,
			String rl,
			String password,
			String mailId,
			String phoneNo,
			String actionMode
	){
		this.uId = uId;
		this.userName = userName;
		this.profileName = profileName;
		this.role = role;
		this.rl = rl;
		this.password = password;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.actionMode = actionMode;
	}
	
	public Long getuId() {
		return uId;
	}
	
	public void setuId(Long uId) {
		this.uId = uId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	public String getProfileName() {
		return profileName;
	}
	
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRl() {
		return rl;
	}
	
	public void setRl(String rl) {
		this.rl = rl;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMailId() {
		return mailId;
	}
	
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getActionMode() {
		return actionMode;
	}
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	
}
