package com.hithaui.dao;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "bookUps")
public class BookUpDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer id;

	@Nationalized
	@Column(name = "name_book", nullable = false,length = 1000)
	private String nameBook;

	@Column(name = "user_id_up", nullable = true)
	private Integer user_id_up;
	
	@Column(name = "link_book", nullable = true)
	private String linkBook;

	@Nationalized
	@Column(name = "author", nullable = false)
	private String author;
	
	@Nationalized
	@Column(name = "publishing_company", nullable = true)
	private String publishingCompany;
	
	@Nationalized
	@Column(name = "language", nullable = true)
	private String language;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserDAO userDAO;

	@CreationTimestamp
	private Timestamp createAt ;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	@Column(name = "number_of_pages", nullable = true)
	private Integer numberOfPages;

	@Column(name = "status_book", nullable = true)
	private String statusBook;
	
	@Column(name = "view_book", nullable = true)
	private Integer viewBook;
	
	@Column(name = "like_book", nullable = true)
	private Integer likeBook;
	
	@Nationalized
	@Column(name = "content_book", nullable = false,length = 100000)
	private String contentBook;
	
	@Nationalized
	@Column(name = "describe_book", nullable = true,length = 3000)
	private String describeBook;
	
	@Column(name = "price_book", nullable = false)
	private Integer	 priceBook;
	
	@Column(name = "classify", nullable = false)
	private Integer	 classify;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public Integer getUser_id_up() {
		return user_id_up;
	}

	public void setUser_id_up(Integer user_id_up) {
		this.user_id_up = user_id_up;
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

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getStatusBook() {
		return statusBook;
	}

	public void setStatusBook(String statusBook) {
		this.statusBook = statusBook;
	}

	public Integer getViewBook() {
		return viewBook;
	}

	public void setViewBook(Integer viewBook) {
		this.viewBook = viewBook;
	}

	public Integer getLikeBook() {
		return likeBook;
	}

	public void setLikeBook(Integer likeBook) {
		this.likeBook = likeBook;
	}

	public String getContentBook() {
		return contentBook;
	}

	public void setContentBook(String contentBook) {
		this.contentBook = contentBook;
	}

	public String getDescribeBook() {
		return describeBook;
	}

	public void setDescribeBook(String describeBook) {
		this.describeBook = describeBook;
	}

	public Integer getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(Integer priceBook) {
		this.priceBook = priceBook;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	public BookUpDAO(Integer id, String nameBook, Integer user_id_up, String linkBook, String author,
			String publishingCompany, String language, UserDAO userDAO, Timestamp createAt, Timestamp updateAt,
			Integer numberOfPages, String statusBook, Integer viewBook, Integer likeBook, String contentBook,
			String describeBook, Integer priceBook, Integer classify) {
		super();
		this.id = id;
		this.nameBook = nameBook;
		this.user_id_up = user_id_up;
		this.linkBook = linkBook;
		this.author = author;
		this.publishingCompany = publishingCompany;
		this.language = language;
		this.userDAO = userDAO;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.numberOfPages = numberOfPages;
		this.statusBook = statusBook;
		this.viewBook = viewBook;
		this.likeBook = likeBook;
		this.contentBook = contentBook;
		this.describeBook = describeBook;
		this.priceBook = priceBook;
		this.classify = classify;
	}

	public BookUpDAO() {
		super();
	}

	
}
