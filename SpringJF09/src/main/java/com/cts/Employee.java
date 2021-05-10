package com.cts;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	
	@Min(value = 100,message = "id should be greater than 100")
	@Max(value=10000, message="id should be less than 10000")
	private int id;
	@NotEmpty(message = "name cannot be empty")
	@Size(min = 3, max=10)
	private String name;
	
	@Digits(integer = 5, fraction = 0,message="wrong data")
	private int salary;
	private String desg;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "Enter date of joining")
    private Date doj;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	
	
	
	

}
