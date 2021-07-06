package com.hithaui.utils;


import com.hithaui.dao.BookUpDAO;
import com.hithaui.dto.BookUpDTO;

public class ConvertBook {
	public static BookUpDAO fromDAO(BookUpDTO bookDTO)
	{
		BookUpDAO bookUpDAO = new BookUpDAO();
		bookUpDAO.setAuthor(bookDTO.getAuthor());
		bookUpDAO.setLanguage(bookDTO.getLanguage());
		bookUpDAO.setLinkBook(bookDTO.getLinkBook());
		bookUpDAO.setNameBook(bookDTO.getNameBook());
		if(bookDTO.getNumberOfPages()!=null)
		bookUpDAO.setNumberOfPages(bookDTO.getNumberOfPages());
		else {
			bookUpDAO.setNumberOfPages(0);
		}
		bookUpDAO.setPublishingCompany(bookDTO.getPublishingCompany());
		bookUpDAO.setStatusBook(bookDTO.getStatus());
		bookUpDAO.setViewBook(bookDTO.getView());
		bookUpDAO.setLikeBook(bookDTO.getLike());
		bookUpDAO.setPriceBook(bookDTO.getPrice());
		bookUpDAO.setContentBook(bookDTO.getContent());
		bookUpDAO.setDescribeBook(bookDTO.getDescribe());
		bookUpDAO.setClassify(0);
		return bookUpDAO;
	}
}
