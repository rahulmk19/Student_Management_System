package com.student.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class HomeController {
	@RequestMapping
	public String getHello() {
		return "Welcome to Student management system";
	}
}
