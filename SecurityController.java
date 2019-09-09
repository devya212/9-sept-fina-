package com.nucleus.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.nucleus.service.IUserService;

@Controller
public class SecurityController {

	@Autowired
	IUserService iuser;
	
	@RequestMapping("/loginform")
	public String request1()
	{
		return "LoginForm";
	}
	
	@RequestMapping("/loginfailure")
	public String request2(ModelMap map)
	{
		map.addAttribute("error","Invalid credentials");
		return "LoginForm";
	}
	@RequestMapping("/noaccess")
	public String request3()
	{		
		return "accessdenied";
	}
	
	@RequestMapping("/defaultpage")
	public ModelAndView request3(HttpServletRequest request,Principal principal)
	{		
		/*String target="result";
		if(request.isUserInRole("ROLE_ADMIN"))
			target="adminHome";
		else if(request.isUserInRole("ROLE_USER"))
			target="makerHome";
		return target;*/
		List<String> list=iuser.getRoles(principal.getName());
		return new ModelAndView("default","list",list);
	}
	@RequestMapping("/roletarget")
	public String request4(@RequestParam("r1") String rolename,Principal principal)
	{		
		String target="result";
		if(rolename.equals("ROLE_ADMIN"))
			target="adminHome";
		else if(rolename.equals("ROLE_USER"))
			target="makerHome";
		return target;
	}
	
}
