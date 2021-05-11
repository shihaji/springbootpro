package com.cts;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
	
	@Autowired
	LoginDao loginDao;
	
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
			BindingResult result,Model model,RedirectAttributes redirectAttr) {
		
		if(result.hasErrors()) {
			System.out.println(result.hasErrors());
			return "registerForm";
		}		
	
		model.addAttribute("name", employee.getName());
		
		redirectAttr.addFlashAttribute("name", employee.getName());
		
		return "redirect:/homeView";  // redirection is done by browser in the case of redirect
		                              // url changes           
		}
	
	@GetMapping("homeView")
	public String viewMethod() {
		
		return "home";
	}
	
	@GetMapping("showAll")
	public String getAllEmp(Model model) {
		
		List<Employee1> list=loginDao.getAllEmp();
	
		model.addAttribute("list",list);
		
		return "home";
	}
	
	
	@GetMapping("searchEmployee")
	public String  findEmployee(Model model) {
		
		model.addAttribute("find","Search Employee");
		return "home";
		
	}
	
	@GetMapping("findEmployee")
	public String getEmployee(@RequestParam String id,Model model) throws EmployeeNotFoundException {
		
		Employee1 emp=loginDao.searchEmployee(id);
		
		if(emp==null) {
			throw new EmployeeNotFoundException("not found");
		}
		
		System.out.println(emp);
		model.addAttribute("emp1",emp);
		
		return "home";
	}
	
	

}
