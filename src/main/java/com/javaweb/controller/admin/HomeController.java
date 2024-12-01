package com.javaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@GetMapping(value = "/admin/home")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

//	@GetMapping(value = "/login")
//	public ModelAndView login(){
//		ModelAndView modelAndView = new ModelAndView("login");
//		return modelAndView;
//	}
//
//	@GetMapping(value = "/access-denied")
//	public ModelAndView accessDenied(){
//		return new ModelAndView("redirect:/login?accessDenied");
//	}
//
	@GetMapping(value = "/signup")
	public ModelAndView signup(){
		ModelAndView modelAndView = new ModelAndView("signup");
		return modelAndView;
	}
}
