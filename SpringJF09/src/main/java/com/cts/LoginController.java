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
	public String loginUser(@RequestParam String username,@RequestParam String userpassword) {
			
		
		return "forward:/validate";  // forward happens at server side  and url wont change
		
	}
	
	@PostMapping("validate")
	public ModelAndView validateUser(String username,String userpassword) {
		
		System.out.println("in validate user method");
		
      User user=new User();
		
		user.setUsername(username);
		user.setUserpassword(userpassword);
				
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
