package com.hithaui.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.BookReadDAO;
import com.hithaui.dao.UserDAO;
import com.hithaui.dto.BookReadDTO;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.BookReadRepositories;
import com.hithaui.repositories.UserRepository;

@RestController
@RequestMapping("/api/bookreads")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class BookReadController {
	@Autowired
	private BookReadRepositories bookReadRepositories;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<?> findAllBooks()
	{
		List<BookReadDAO> list = bookReadRepositories.findAll();
		if (list.size() == 0) {
			throw new NotFoundException("No content");
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{bookID}")
	public ResponseEntity<?> getBookById(@PathVariable("bookID") Integer bookID)
	{
		Optional<BookReadDAO> optional = bookReadRepositories.findById(bookID);
		if(!optional.isPresent())
		{
			throw new NotFoundException("Not found book by BookId " + bookID);
		}
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	}
	
	
	@PostMapping
	public ResponseEntity<?> createNewBook(@RequestBody BookReadDTO bookReadDTO)
	{
		BookReadDAO bookReadDAO = new BookReadDAO();
		Optional<UserDAO> optional = userRepository.findById(bookReadDTO.getUserId());
		if(!optional.isPresent())
			throw new NotFoundException("Not found user by userId " + bookReadDTO.getUserId());
		bookReadDAO.setUserDAO(optional.get());
		bookReadDAO.setBook_id_reading(bookReadDTO.getBook_id_reading());
		bookReadDAO.setUser_id_reading(bookReadDTO.getUserId());
		BookReadDAO newBookDAO = bookReadRepositories.save(bookReadDAO);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBookDAO);
	}
	
}
