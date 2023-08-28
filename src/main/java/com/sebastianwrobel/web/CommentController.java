package com.sebastianwrobel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sebastianwrobel.domain.Comment;
import com.sebastianwrobel.domain.Tour;
import com.sebastianwrobel.service.CommentService;
import com.sebastianwrobel.service.TourService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private TourService tService;
	
	@GetMapping("/addComment")
	public String showCommentForm(ModelMap model) {
		 List<Tour> tours = tService.findAll();
		 model.addAttribute("tours", tours);
		 model.addAttribute("comment", new Comment());
		return "/form-comment";
	}
	

	@PostMapping("/processFormComment")
	public String addCommentData(@ModelAttribute Comment comment) {

		commentService.save(comment);
		return "redirect:/showOffer";
	}
	
}
