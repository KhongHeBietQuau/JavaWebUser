package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Integer> {
	UserDAO  findByEmail(String email);
	UserDAO  findByUserName(String userName);
	UserDAO findByPhoneNumber(String phoneNumber);
}
