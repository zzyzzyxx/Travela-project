package com.sebastianwrobel.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sebastianwrobel.domain.Tour;
import com.sebastianwrobel.service.TourService;


@Controller
public class HomeController {
		
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
}
