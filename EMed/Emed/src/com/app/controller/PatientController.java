package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IPatientDao;
import com.app.pojos.User;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	IPatientDao pdao;
	
	
	@GetMapping("/doclist")
	public String getDoctorList(HttpSession hs)
	{
		hs.setAttribute("doclist",pdao.getDoctorsList());
		return "/patient/doclist";
	}
	
	
	
	@PostMapping("/doclist")
	public String setappoint(@RequestParam Integer docid,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date appdate,HttpSession hs)
	{
		 User u =(User) hs.getAttribute("user");
		pdao.setApp(docid, appdate, u);
		return "/admin/requested";
	}
	
	

}
