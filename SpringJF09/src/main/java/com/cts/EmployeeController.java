package com.cts;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EmployeeController {
	
    @InitBinder
	public void  formatDoj(WebDataBinder binder) {
		
    	
    	
    	
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		CustomDateEditor editor=new CustomDateEditor(df, true);
		
		binder.registerCustomEditor(Date.class,editor);
		
				
	}
    
    @ModelAttribute("roles")
    public Map<String,String> getAllDesg(){
    	
    	Map<String,String> map=new HashMap<String,String>();
    	map.put("prg", "programmer");
    	map.put("tester", "tester");
    	map.put("analyst", "analyst");
    	map.put("admin", "Admin");
    	return map;
    }
	
	
	
	@GetMapping("register")
	public String getForm(@ModelAttribute Employee employee) {
		
		return "registerForm";
	}
	
	@PostMapping("employeeRegister")
	public String registerEmployee(@SessionAttribute("user1") String user,@Valid @ModelAttribute Employee employee, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.hasErrors());
			return "registerForm";
		}
		
		System.out.println("emp name "+employee.getName());
		System.out.println("doj "+employee.getDoj());
		return "home";
	}
	

}
