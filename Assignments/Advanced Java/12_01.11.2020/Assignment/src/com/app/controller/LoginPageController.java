package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {

	@RequestMapping("/")
	public String displayLoginPage() {
		return "/login";
	}

}
