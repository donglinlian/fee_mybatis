package com.alice.application.subscriber.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alice.application.subscriber.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		
		return "login";
		
	}
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String signin(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String username,
			String password) {
		boolean isExists = false;

		logger.info("/adminlogin...username: " + username + ",the password: "+ password);
		try {
			isExists = loginService.checkIsAdmin(username, password);
//			isExists = true;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";

		}
		if (isExists) {
			return "index";
		}
		return "error";

	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		logger.info("/logout.. logout now qucikly " );
		
		return "login";

	}
}
