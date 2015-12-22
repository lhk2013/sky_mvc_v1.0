package com.haikuo.sky.service;

import com.haikuo.sky.dao.BaseDao;
import com.haikuo.sky.model.User;

public interface UserService extends BaseDao<User> {
	User findByPk(long userId)throws Exception;
	
	public User loginCheck(User user);
	
	public boolean register(User user);
	
	com.haikuo.sky.entity.User saveEntity(long userId)throws Exception;
}
