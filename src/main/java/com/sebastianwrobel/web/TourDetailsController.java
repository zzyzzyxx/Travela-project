package com.sebastianwrobel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sebastianwrobel.domain.Tour;
import com.sebastianwrobel.domain.TourDetails;
import com.sebastianwrobel.service.TourDetailsService;
import com.sebastianwrobel.service.TourService;
@Controller
public class TourDetailsController {

	@Autowired
	private TourService tourService;
	
	@Autowired
	private TourDetailsService tourDetailsService;
	
	@GetMapping("/showTourDetails/{tourId}")
	public String showTourDetails(@PathVariable int tourId, ModelMap model) {
		Tour tour = tourService.findById(tourId);
		if(tour != null) {
			model.addAttribute("tour", tour);
			return "tour-details";
		}
		return "redirect:/showOffer";
	}
	
	@GetMapping("/editTourDetails/{tourId}")
	public String editTourDetails(@PathVariable int tourId, ModelMap model) {
		Tour tour = tourService.findById(tourId);
		if(tour != null) {
			model.addAttribute("tourDetails", tour.getTourDetails());
			return "form-tour-details";
		}
		return "redirect:/showOffer";
	}
	
	@PostMapping("/processFormTourDetails")
	public String processTourDetailsData(@ModelAttribute TourDetails tourDetails) {
		tourDetailsService.saveOrUpdate(tourDetails);
		return "redirect:/showOffer";
	}
	
}
