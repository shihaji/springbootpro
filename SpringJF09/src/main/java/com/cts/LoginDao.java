package com.cts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	
	public List<Employee1> getAllEmp(){
		
		String sql="select * from employee";
		
		
		return jdbcTemplate.query(sql, new RowMapper<Employee1>() {

			@Override
			public Employee1 mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee1 emp=new Employee1();
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				
				return emp;
			}
			
		});
		
		
	}


	public Employee1 searchEmployee(String id) {
		
		String sql="select * from employee where id=?";
		 Employee1 emp1=null;
		
		 try {
		 
		emp1=jdbcTemplate.queryForObject(sql, new RowMapper<Employee1>() {

			@Override
			public Employee1 mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee1 emp=new Employee1();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				
				return emp;
			}
			
		}, id);
		 }catch(Exception e) {
			 System.out.println("exception thrown");
			 return null;
		 }
		return emp1;
		
	}
	
	
	
	

}
