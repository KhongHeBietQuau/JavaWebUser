package com.hithaui.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "bookReads")
public class BookReadDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer id;

	@Column(name = "book_id_reading", nullable = true)
	private Integer book_id_reading;
	
	@Column(name = "user_id_reading", nullable = true)
	private Integer user_id_reading;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserDAO userDAO;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getBook_id_reading() {
		return book_id_reading;
	}


	public void setBook_id_reading(Integer book_id_reading) {
		this.book_id_reading = book_id_reading;
	}


	public Integer getUser_id_reading() {
		return user_id_reading;
	}


	public void setUser_id_reading(Integer user_id_reading) {
		this.user_id_reading = user_id_reading;
	}


	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public BookReadDAO(Integer id, Integer book_id_reading, Integer user_id_reading, UserDAO userDAO) {
		super();
		this.id = id;
		this.book_id_reading = book_id_reading;
		this.user_id_reading = user_id_reading;
		this.userDAO = userDAO;
	}


	public BookReadDAO() {
		super();
	}
	
	
}
