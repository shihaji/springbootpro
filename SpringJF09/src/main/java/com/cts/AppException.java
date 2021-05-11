package com.cts;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppException {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String empException(Model model) {
		model.addAttribute("noEmp", "Employee not found");
		return "home";
	}

}
