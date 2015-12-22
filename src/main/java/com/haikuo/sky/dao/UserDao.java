package com.haikuo.sky.dao;

import java.util.List;

import com.haikuo.sky.model.User;

public interface UserDao<T> {
	 public void register(User user);
	 public User findUserByUserName(String userName);
	 public List<User> findUserList(String userName);
}
