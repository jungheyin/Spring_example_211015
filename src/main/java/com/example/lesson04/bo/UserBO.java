package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;
import com.example.lesson04.model.User;

@Service
public class UserBO {
	
	@Autowired
	public UserDAO userDAO;

	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userDAO.insertUser(name, yyyymmdd,email,introduce);
	}
	
	public User getLastUser() {
		return userDAO.slectLastUser();
	}
	
	// 존재여부 이거나 이름으 가져오거나 방법이 있다.
	// 존재여부 방법
	public boolean existUserByName(String name) {
		return userDAO.existUserByName(name);
	}
}
