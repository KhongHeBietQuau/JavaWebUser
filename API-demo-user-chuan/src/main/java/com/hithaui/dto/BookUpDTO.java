package com.hithaui.dto;

public class BookUpDTO {
	
	private String nameBook;

	private Integer user_id;
	
	private String linkBook;

	
	private String author;
	
	
	private String publishingCompany;
	
	
	private String language;
	
	
	private Integer numberOfPages;

	private String status;
	
	
	private Integer view;
	
	private Integer like;
	
	
	private String content;
	
	
	private String describe;
	
	
	private Integer price;


	public String getNameBook() {
		return nameBook;
	}


	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getLinkBook() {
		return linkBook;
	}


	public void setLinkBook(String linkBook) {
		this.linkBook = linkBook;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublishingCompany() {
		return publishingCompany;
	}


	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Integer getNumberOfPages() {
		return numberOfPages;
	}


	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getView() {
		return view;
	}


	public void setView(Integer view) {
		this.view = view;
	}


	public Integer getLike() {
		return like;
	}


	public void setLike(Integer like) {
		this.like = like;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public BookUpDTO(String nameBook, Integer user_id, String linkBook, String author, String publishingCompany,
			String language, Integer numberOfPages, String status, Integer view, Integer like, String content,
			String describe, Integer price) {
		super();
		this.nameBook = nameBook;
		this.user_id = user_id;
		this.linkBook = linkBook;
		this.author = author;
		this.publishingCompany = publishingCompany;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.status = status;
		this.view = view;
		this.like = like;
		this.content = content;
		this.describe = describe;
		this.price = price;
	}


	public BookUpDTO() {
		super();
	}

}
