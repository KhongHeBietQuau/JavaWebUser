package com.hithaui.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Users")
public class UserDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userID;
	
	@Column(name = "userName",nullable = false,unique = true)
	private String userName;
	
	@Column(name = "passWord",nullable = false)
	private String passWord;
	
	@Column(name = "money",nullable = true)
	private Integer money;
	
	@Column(name = "email",nullable = true)
	private String email;
	
	@Column(name = "phoneNumber",nullable = true)
	private String phoneNumber ;
	
	
	@Column(name = "linkImage",nullable = true)
	private String linkImage;

	@OneToMany(mappedBy = "userDAO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BookUpDAO> listBookUpDAOs;
	
	@OneToMany(mappedBy = "userDAO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BookReadDAO> listBookReadDAOs;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

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

	public List<BookUpDAO> getListBookUpDAOs() {
		return listBookUpDAOs;
	}

	public void setListBookUpDAOs(List<BookUpDAO> listBookUpDAOs) {
		this.listBookUpDAOs = listBookUpDAOs;
	}

	public List<BookReadDAO> getListBookReadDAOs() {
		return listBookReadDAOs;
	}

	public void setListBookReadDAOs(List<BookReadDAO> listBookReadDAOs) {
		this.listBookReadDAOs = listBookReadDAOs;
	}

	public UserDAO(Integer userID, String userName, String passWord, Integer money, String email, String phoneNumber,
			String linkImage, List<BookUpDAO> listBookUpDAOs, List<BookReadDAO> listBookReadDAOs) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.passWord = passWord;
		this.money = money;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.linkImage = linkImage;
		this.listBookUpDAOs = listBookUpDAOs;
		this.listBookReadDAOs = listBookReadDAOs;
	}

	public UserDAO() {
		super();
	}

	


	
	
}
