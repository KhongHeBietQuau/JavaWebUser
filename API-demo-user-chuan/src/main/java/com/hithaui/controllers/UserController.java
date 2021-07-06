package com.hithaui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hithaui.dao.BookReadDAO;
import com.hithaui.dao.BookUpDAO;
import com.hithaui.dao.UserDAO;
import com.hithaui.dto.UserDTO;
import com.hithaui.exceptions.DuplicateRecordException;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.UserRepository;
import com.hithaui.utils.ConvertUserDTOFromUserDAO;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Cloudinary cloudinary;
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		List<UserDAO> list = userRepository.findAll();
		if (list.size() == 0) {
			throw new NotFoundException("No content");
		}
		return ResponseEntity.status(200).body(list);
	}
	@GetMapping("/{userID}")
	public ResponseEntity<?> getUserById(@PathVariable("userID") Integer userID)
	{
		Optional<UserDAO> userDAO = userRepository.findById(userID);
		if (!userDAO.isPresent()) {
			throw new NotFoundException("Not found User by UserId " + userID);
		}
		return ResponseEntity.status(HttpStatus.OK).body(userDAO.get());
	}
	
	@GetMapping("/{userID}/bookups")
	public ResponseEntity<?> getbookupsById(@PathVariable("userID") Integer userID)
	{
		Optional<UserDAO> userDAO = userRepository.findById(userID);
		if (!userDAO.isPresent()) {
			throw new NotFoundException("Not found User by UserId " + userID);
		}
		List<BookUpDAO> list = userDAO.get().getListBookUpDAOs();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{userID}/bookreads")
	public ResponseEntity<?> getbookreadsById(@PathVariable("userID") Integer userID)
	{
		Optional<UserDAO> userDAO = userRepository.findById(userID);
		if (!userDAO.isPresent()) {
			throw new NotFoundException("Not found User by UserId " + userID);
		}
		List<BookReadDAO> list = userDAO.get().getListBookReadDAOs();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO)
	{
		UserDAO oldUserDAO = userRepository.findByUserName(userDTO.getUserName());
		if(oldUserDAO != null)
		{
			throw new DuplicateRecordException("Duplicate record User");
		}
		UserDAO userDAO = ConvertUserDTOFromUserDAO.Convert(userDTO);
		UserDAO newUserDAO = userRepository.save(userDAO);
		return ResponseEntity.status(201).body(newUserDAO);
	}
	
	@PostMapping("/data")
	public ResponseEntity<?> createNewUser(@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord,
			@RequestParam("money") Integer money  ,
			@RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("linkImage") MultipartFile linkImage)
	throws IOException
	{
		UserDAO oldUserDAO = userRepository.findByEmail(email);
		oldUserDAO = userRepository.findByPhoneNumber(phoneNumber);
		oldUserDAO = userRepository.findByUserName(userName);
		if(oldUserDAO != null)
		{
			throw new DuplicateRecordException("Duplicate record User");
		}
		Map<?, ?> map = cloudinary.uploader().upload(linkImage.getBytes(), ObjectUtils.emptyMap());
		UserDAO userDAO = new UserDAO();
		userDAO.setEmail(email);
		userDAO.setLinkImage(map.get("secure_url").toString());
		userDAO.setMoney(money);
		userDAO.setPassWord(passWord);
		userDAO.setPhoneNumber(phoneNumber);
		userDAO.setUserName(userName);
		UserDAO newUserDAO = userRepository.save(userDAO);
		return ResponseEntity.status(201).body(newUserDAO);
	}
	
	@PatchMapping("/{userID}")
	public ResponseEntity<?> editUserById(@PathVariable ("userID") Integer userID,
			@RequestBody UserDTO userDTO)
	{
		Optional<UserDAO> optional = userRepository.findById(userID);
		if (!optional.isPresent()) {
			throw new NotFoundException("Not found User by UserId " + userID);
		}
		UserDAO userDAO = optional.get();
		
		if(!optional.isPresent())
		{
			return ResponseEntity.status(204).build();
		}
		if(userDTO.getEmail()!= null)
		userDAO.setEmail(userDTO.getEmail());
		
		if(userDTO.getLinkImage() != null)
		userDAO.setLinkImage(userDTO.getLinkImage());
		
		if(userDTO.getMoney() != null)
		userDAO.setMoney(userDTO.getMoney());
		
		if(userDTO.getPassWord() != null)
		userDAO.setPassWord(userDTO.getPassWord());
		
		if(userDTO.getPhoneNumber() != null)
		userDAO.setPhoneNumber(userDTO.getPhoneNumber());
		
		if(userDTO.getUserName() != null)
		userDAO.setUserName(userDTO.getUserName());
		
		UserDAO newUserDAO = userRepository.save(userDAO);
		return ResponseEntity.status(HttpStatus.OK).body(newUserDAO);
	}
	
	@DeleteMapping("/{userID}")
	public ResponseEntity<?> deleteUserById(@PathVariable ("userID") Integer userID)
	{
		Optional<UserDAO> optional = userRepository.findById(userID);
		if (!optional.isPresent()) {
			throw new NotFoundException("Not found student by studentId " + userID);
		}
		userRepository.deleteById(userID);
		return ResponseEntity.status(200).build();
	}
}
