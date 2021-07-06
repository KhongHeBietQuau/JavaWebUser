package com.hithaui.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hithaui.dao.BookUpDAO;
import com.hithaui.dao.UserDAO;
import com.hithaui.dto.BookUpDTO;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.BookRepository;
import com.hithaui.repositories.UserRepository;
import com.hithaui.utils.ConvertBook;

@RestController
@RequestMapping("/api/bookups")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class BookUpController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Cloudinary  cloudinary;
	
	@GetMapping
	public ResponseEntity<?> findAllBooks()
	{
		List<BookUpDAO> list = bookRepository.findAll();
		if (list.size() == 0) {
			throw new NotFoundException("No content");
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{bookID}")
	public ResponseEntity<?> getBookById(@PathVariable("bookID") Integer bookID)
	{
		Optional<BookUpDAO> optional = bookRepository.findById(bookID);
		if(!optional.isPresent())
		{
			throw new NotFoundException("Not found book by BookId " + bookID);
		}
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<?> createNewBook(@RequestBody BookUpDTO bookDTO)
	{
		BookUpDAO bookDAO = ConvertBook.fromDAO(bookDTO);
		Optional<UserDAO> optional = userRepository.findById(bookDTO.getUser_id());
		if(!optional.isPresent())
			throw new NotFoundException("Not found user by userId " + bookDTO.getUser_id());
		bookDAO.setUserDAO(optional.get());
		bookDAO.setUser_id_up(bookDTO.getUser_id());
		BookUpDAO newBookDAO = bookRepository.save(bookDAO);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBookDAO);
	}
	
	@PostMapping("/data")
	public ResponseEntity<?> createBookByFormData(
			@RequestParam("nameBook") String nameBook,
			@RequestParam ("linkBook") MultipartFile linkBook,
			@RequestParam("author") String author,
			@RequestParam("publishingCompany") String publishingCompany ,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages,
			@RequestParam("status") String status,
			@RequestParam("content")String content,
			@RequestParam("describe") String describe,
			@RequestParam("price") Integer price,
			@RequestParam("userId") Integer userId
			)
	throws IOException
	{
		
		Map<?, ?> map = cloudinary.uploader().upload(linkBook.getBytes(), ObjectUtils.emptyMap());
		BookUpDAO bookDAO = new BookUpDAO();
		bookDAO.setNameBook(nameBook);
		bookDAO.setLinkBook(map.get("secure_url").toString());
		bookDAO.setAuthor(author);
		bookDAO.setPublishingCompany(publishingCompany);
		bookDAO.setLanguage(language);
		bookDAO.setNumberOfPages(numberOfPages);
		bookDAO.setStatusBook(status);
		bookDAO.setContentBook(content);
		bookDAO.setDescribeBook(describe);
		bookDAO.setPriceBook(price);
		bookDAO.setLikeBook(0);
		bookDAO.setViewBook(0);
		bookDAO.setClassify(0);
		bookDAO.setUser_id_up(userId);
		Optional<UserDAO> optional = userRepository.findById(userId);
		if(!optional.isPresent())
			throw new NotFoundException("Not found user by userId " + userId);
		bookDAO.setUserDAO(optional.get());
		BookUpDAO newBookDAO = bookRepository.save(bookDAO);
		return ResponseEntity.status(201).body(newBookDAO);
	}
	
	
	
	@DeleteMapping("/{bookID}")
	public ResponseEntity<?> deleteBookById(@PathVariable("bookID") Integer bookID)
	{
		Optional<BookUpDAO> optional = bookRepository.findById(bookID);
		if(!optional.isPresent())
		{
			throw new NotFoundException("Not found book by bookId: " + bookID);
		}
		bookRepository.deleteById(bookID);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
