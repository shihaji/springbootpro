package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user1")
public class LoginController {
	
	@Autowired
	LoginBo loginBo;
	
	@GetMapping("login")
	public String loginPage() {
		
		return "login";
	}
	
	@PostMapping("loginControl")
	public ModelAndView loginUser(User user) {
		
		
		ModelAndView mv=new ModelAndView();
		if(loginBo.validateUser(user)) {
			
			mv.setViewName("home");
			mv.addObject("user1",user.getUsername());
			
		}else {
			mv.setViewName("login");
			mv.addObject("user1","Invalid user");
		}
		
		
		
		return mv;
		
	}

}
