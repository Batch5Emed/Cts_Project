package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IUserDao;
import com.app.pojos.Role;
import com.app.pojos.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserDao udao;
	
	@Autowired 
	JavaMailSender sendmail;
	
	public UserController() {
	System.out.println("Inside User Controller");
	}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "/user/login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "/user/register";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String em,@RequestParam String pwd,HttpSession hs)
	{
		try
		{
	  User u = udao.getUserByMail(em, pwd);
	  hs.setAttribute("user", u);
	     if(u.getUserType()==Role.PATIENT)
		  return "redirect:/patient/doclist";
	     else if(u.getUserType()==Role.DOCTOR)
	    	 return "redirect:/doctor/appointments";
	     else 
	    	 return "redirect:/admin/users";
		}
		catch (RuntimeException e) {
		  e.printStackTrace();
		  return "/user/login";
		}
	}
		  
//		
//		@PostMapping("/register")
//			public String register(@RequestParam String username,@RequestParam String email,@RequestParam String password)
//			{
//			  
//			User u = new User();
//			u.setUserNanme(username);
//			u.setPassword(password);
//			u.setEmail(email);
//			u.setUserType(Role.PATIENT);
//			udao.registerUser(u);
//			return "/user/login";
//			
//			}
	  
	@PostMapping("/register")
	public String register(User u)
	{
		u.setUserType(Role.PATIENT);
		udao.registerUser(u);
		return "redirect:/user/login";
	}
			
	


}
