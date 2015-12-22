package com.haikuo.sky.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.haikuo.sky.dao.UserDao;
import com.haikuo.sky.model.User;

@Repository
public class UserDaoImpl<T> implements UserDao<T>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	 @Override
	    public void register(User user) {
	        String sqlStr = "insert into t_user(name,pwd) values(?,?)";
	        Object[] params = new Object[]{user.getUserName(),user.getPassword()};
	        jdbcTemplate.update(sqlStr, params);
	    }
	 
	    @Override
	    public User findUserByUserName(String userName) {
	        String sqlStr = "select id,name,pwd from t_user where name like ?";
	        final User user = new User();
	        userName = "'%"+userName+"%'";
	        User u2 = new User();
	        u2.setUserName(userName);
	        u2.setPassword(userName+userName+"-2012");
	        register(u2);
	        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
	            @Override
	            public void processRow(ResultSet rs) throws SQLException {
	            	if(rs!=null){
	            		user.setId(rs.getLong("id"));
	            		user.setUserName(rs.getString("name"));
	            		user.setPassword(rs.getString("pwd"));
	            	}
	            }
	        });
	        return user;
	    }

		@Override
		public List<User> findUserList(String userName) {
			// TODO Auto-generated method stub
			 String sqlStr = "select id,name,pwd from t_user where name like ?";
		        final User user = new User();
		        userName = "'%"+userName+"%'";
		        User u2 = new User();
		        u2.setUserName(userName);
		        u2.setPassword(userName+userName+"-2012");
			jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
	            @Override
	            public void processRow(ResultSet rs) throws SQLException {
	            	if(rs!=null){
	            		user.setId(rs.getLong("id"));
	            		user.setUserName(rs.getString("name"));
	            		user.setPassword(rs.getString("pwd"));
	            	}
	            }
	        });
			return null;
		}

}
