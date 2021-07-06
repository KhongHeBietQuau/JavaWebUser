package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hithaui.dao.BookUpDAO;

@Repository
public interface BookRepository extends JpaRepository<BookUpDAO, Integer> {

}
