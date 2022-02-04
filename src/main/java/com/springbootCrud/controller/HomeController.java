package com.springbootCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	public String home() {
		
		return "index.html";
	}

}
