package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public String showLoginPage() {
		return "/user/login";
	}

	@PostMapping("/login")
	public String validateUser(Model modelMap, HttpSession session, @RequestParam String email,
			@RequestParam String pass) {
		User user = userService.authenticateUser(email, pass);
		if (user != null) {
			session.setAttribute("user_credentials", user);
			return "redirect:/flight/search";
		}
		modelMap.addAttribute("message", "Invalid Credentials. Try Again!");
		return "/user/login";
	}

	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		modelMap.addAttribute("user_details", session.getAttribute("user_credentials"));
		session.invalidate();
		response.setHeader("refresh", "5;url=" + request.getContextPath() + "/");
		return "/user/logout";
	}

}
