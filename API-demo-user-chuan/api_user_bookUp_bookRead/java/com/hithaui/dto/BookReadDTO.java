package com.hithaui.dto;

public class BookReadDTO {
	private Integer book_id_reading;
	
	private Integer userId;

	public Integer getBook_id_reading() {
		return book_id_reading;
	}

	public void setBook_id_reading(Integer book_id_reading) {
		this.book_id_reading = book_id_reading;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BookReadDTO(Integer book_id_reading, Integer userId) {
		super();
		this.book_id_reading = book_id_reading;
		this.userId = userId;
	}

	public BookReadDTO() {
		super();
	}
	
	
}
