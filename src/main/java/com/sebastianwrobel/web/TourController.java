package com.sebastianwrobel.web;

import java.security.Principal;
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
public class TourController {
	@Autowired
	private TourService tourService;

	@GetMapping("/addTour")
	public String showForm(ModelMap model) {
		model.addAttribute("tour", new Tour());
		return "form";
	}
	
	@PostMapping("/processForm")
	public String showTourData(@Valid @ModelAttribute Tour tour, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		tourService.saveOrUpdate(tour);
		return "redirect:showOffer";
	}
	
	@GetMapping("/showOffer")
	public String getTours(ModelMap model) {
		List<Tour> tours = tourService.findAll();
		model.addAttribute("tours", tours);
		return "tours";
	}
	
	@GetMapping("/deleteTour/{id}")
	public String deleteTour(@PathVariable Integer id) {
		Tour tour = tourService.findById(id);
		if(tour != null) {
			tourService.delete(id);
		}
		return "redirect:/showOffer";
	}
	
	@GetMapping("/editTour/{id}")
	public String editTour(@PathVariable Integer id, ModelMap model) {
		Tour tour = tourService.findById(id);
		if(tour != null) {
			model.addAttribute("tour", tour);
			return "form";
		}
		return "redirect:/showOffer";
	}
	
	@GetMapping("/addUserToTour/{id}")
	public String addUserToTour(@PathVariable Integer id, Principal principal) {
		tourService.addUserToTour(id, principal.getName());
		
		return "redirect:/showOffer";
	}
	
	@GetMapping("/showOfferForNextMonth")
	public String getToursForNextMonth(ModelMap model) {
		List<Tour> tours = tourService.getAllForNextMonth();
		model.addAttribute("tours", tours);
		return "tours";
	}
}
