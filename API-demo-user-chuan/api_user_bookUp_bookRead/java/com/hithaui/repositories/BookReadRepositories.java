package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.BookReadDAO;

@Repository
public interface BookReadRepositories extends JpaRepository<BookReadDAO, Integer> {

}
