package com.haikuo.sky.model;

import java.io.Serializable;

import com.haikuo.sky.annotation.Column;
import com.haikuo.sky.annotation.TableName;

@SuppressWarnings("serial")
@TableName("t_user")
public class User implements Serializable{
	
	@Column("id")
	private long id;
	
	@Column("name")
	private String userName;
	
	@Column("pwd")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
