package com.haikuo.sky.mb.mapper;

import java.util.List;

import com.haikuo.sky.mb.bo.User;


public interface UserMapper {
	List<User> getById(Long userId);
	
	List<User> getById2(Long userId);

}
