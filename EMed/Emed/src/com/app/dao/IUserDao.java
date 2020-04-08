package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao {

	User getUserByMail(String email, String pwd);

	void registerUser(User u);

	List<User> getAllUser();

	void regDoc(User u);

}
