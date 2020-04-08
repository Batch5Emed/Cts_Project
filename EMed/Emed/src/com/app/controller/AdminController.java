package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IUserDao;
import com.app.dao.UserDaoImpl;
import com.app.pojos.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired        //dependency injection
	IUserDao udao;
	
@GetMapping("/users")	
 public String getAllUsers(HttpSession hs)
 {
	System.out.println("in admin-user");
hs.setAttribute("allusers", udao.getAllUser());
return "/admin/users";
 }


@GetMapping("/addDoctor")
public String addDoctor()
{
	return "/admin/addDoctor";
}

@PostMapping("/addDoctor")
public String registerDoc(User u)
{
	System.out.println("inside register doc");
	udao.regDoc(u);
	return "redirect:/admin/users";
}


}
