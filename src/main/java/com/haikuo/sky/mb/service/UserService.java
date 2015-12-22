package com.haikuo.sky.mb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haikuo.sky.mb.bo.User;
import com.haikuo.sky.mb.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getById(Long id){
		return userMapper.getById(id);
	}
}
