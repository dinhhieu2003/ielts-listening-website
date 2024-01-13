package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.dao.user.IUserDao;
import com.listening_ielts.dao.user.UserDaoImpl;
import com.listening_ielts.entity.User;

public class UserServiceImpl implements IUserService{

	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void modifyUser(User user) {
		userDao.modifyUser(user);
	}

	@Override
	public void deleteUser(int username) throws Exception {
		userDao.deleteUser(username);
	}

	@Override
	public User checkUser(String username, String password) {
		return userDao.checkUser(username, password);
	}

	@Override
	public boolean isExistEmail(String email) {
		return userDao.isExistEmail(email);
	}

	@Override
	public boolean isExistUserName(String username) {
		return userDao.isExistUserName(username);
	}

	@Override
	public int countUser() {
		return userDao.countUser();
	}

	@Override
	public List<User> getListUserPage(int start, int count) {
		return userDao.getListUserPage(start, count);
	}

	@Override
	public boolean banUser(String username) {
		return userDao.banUser(username);
	}

	@Override
	public List<User> getListUser_ban(int start, int count) {
		return userDao.getListUser_ban(start, count);
	}

	@Override
	public boolean unbanUser(String username) {
		return userDao.unbanUser(username);
	}

}
