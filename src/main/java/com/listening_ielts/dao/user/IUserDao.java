package com.listening_ielts.dao.user;

import java.util.List;

import com.listening_ielts.entity.User;


public interface IUserDao {
	List <User> findAllUser();
	void insertUser(User user);
	void modifyUser(User user);
	void deleteUser(int username) throws Exception;
	User checkUser(String username, String password);
	boolean isExistEmail(String email);
	boolean isExistUserName(String username);
	int countUser();
	List<User> getListUserPage(int start, int count);
	boolean banUser(String username);
	List<User> getListUser_ban(int start, int count);
	boolean unbanUser(String username);
}

