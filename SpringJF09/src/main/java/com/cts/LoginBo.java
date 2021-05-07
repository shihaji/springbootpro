package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBo {
	
	@Autowired
	LoginDao loginDao;
	
	public boolean validateUser(User user) {
		
		String s=loginDao.getUser(user);
		
		if(s.equals(user.getUsername())) {
			return true;
		}
		
		return false;
		
	}
	

}
