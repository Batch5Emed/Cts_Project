package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IDoctorDao;
import com.app.pojos.User;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	IDoctorDao ddao;
	
	
	public DoctorController() {
		// TODO Auto-generated constructor stub
		System.out.println("In Docotr Contr");
	}
	
	@GetMapping("/appointments")
	public String showapp(HttpSession hs)
	{
		
		System.out.println("In apps");
		User u = (User) hs.getAttribute("user");
		hs.setAttribute("applist",ddao.getApp(u));
		return "/doctor/appointments";
	}
	
	@GetMapping("/acceptapp")
	public String acceptapp(@RequestParam String appid)
	{
 ddao.acceptreq(Integer.valueOf(appid));
		return "redirect:/doctor/appointments";
	}

	
	@GetMapping("/declineapp")
	public String declineapp(@RequestParam String appid)
	{
 ddao.rejectreq(Integer.valueOf(appid));
		return "redirect:/doctor/appointments";
	}
	
	
	
	
	
	

}
