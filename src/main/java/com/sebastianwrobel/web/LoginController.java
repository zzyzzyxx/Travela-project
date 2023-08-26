package com.sebastianwrobel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sebastianwrobel.domain.User;
import com.sebastianwrobel.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping("/forbidden")
	public String showForbiddenError() {
		return "403";
	}
	
	@GetMapping("/signup")
	public String signup(ModelMap model) {
		model.addAttribute("user", new User());
		return "form-signup";
	}
	
	@PostMapping("processSignup")
	public String processSignup(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		boolean errors = false;
		
		if(!user.getPassword().equals(user.getConfirmedPassword())) {
			redirectAttributes.addAttribute("differentPasswords", "Passwords are different");
			errors = true;
		}
		
		if(userService.loginExists(user.getLogin())) {
			redirectAttributes.addAttribute("loginExists", "Login already exists in the database");
			errors = true;
		}
		
		if(errors) {
			return "redirect:/signup";
		}
		
		userService.createNewAccount(user);
		return "login";
	}
	
}
