package com.hithaui.utils;

import com.hithaui.dao.UserDAO;
import com.hithaui.dto.UserDTO;

public class ConvertUserDTOFromUserDAO {
	public static UserDAO Convert(UserDTO userDTO)
	{
		UserDAO userDAO = new UserDAO();
		userDAO.setEmail(userDTO.getEmail());
		userDAO.setLinkImage(userDTO.getLinkImage());
		userDAO.setMoney(userDTO.getMoney());
		userDAO.setPassWord(userDTO.getPassWord());
		userDAO.setPhoneNumber(userDTO.getPhoneNumber());
		userDAO.setUserName(userDTO.getUserName());
		return userDAO;
	}
}
