package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getUser(User user) {
		
		String sql="select name from user where password =?";
		
	     String p=jdbcTemplate.queryForObject(sql, String.class, user.getUserpassword());
		   
	     
		return p;
	}

}
