package com.hithaui.dto;

public class UserDTO {
	private String userName;
	
	
	private String passWord;
	
	
	private Integer money;
	
	
	private String email;
	
	
	private String phoneNumber ;
	
	
	private String linkImage;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getMoney() {
		return money;
	}


	public void setMoney(Integer money) {
		this.money = money;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getLinkImage() {
		return linkImage;
	}


	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}


	public UserDTO(String userName, String passWord, Integer money, String email, String phoneNumber,
			String linkImage) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.money = money;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.linkImage = linkImage;
	}


	public UserDTO() {
		super();
	}


	

	

	
	
	
}
