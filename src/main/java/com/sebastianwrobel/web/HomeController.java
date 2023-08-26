package com.sebastianwrobel.web;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sebastianwrobel.api.domain.openweather.OpenWeatherMap;
import com.sebastianwrobel.service.EternalAPIService;

@Controller
public class HomeController {
		
	@Autowired
	private EternalAPIService externalAPIService;
	
	@GetMapping("/")
	public String getTheWelcomePage() {
		return "redirect:/home";
	}
//	
//	@GetMapping("/home")
//	public String getHome(ModelMap model) {
//		return "home";
//	}
	
	@GetMapping("/home")
	public String getHome(HttpServletRequest request, ModelMap model) throws JsonProcessingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		OpenWeatherMap openWeatherMap = externalAPIService.getData(request);
		model.addAttribute("openWeatherMap", openWeatherMap);
		
		return "home";
	}
}
