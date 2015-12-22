package com.haikuo.sky.model;

import java.util.Date;

import com.haikuo.sky.annotation.Column;
import com.haikuo.sky.annotation.TableName;

@TableName("t_fuck")
public class Fuck {

	@Column("id")
	private int id;
	
	@Column("name")
	private String name2;
	
	@Column("date")
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
