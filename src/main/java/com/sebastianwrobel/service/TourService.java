package com.sebastianwrobel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Tour;
import com.sebastianwrobel.domain.TourDetails;
import com.sebastianwrobel.domain.User;
import com.sebastianwrobel.repository.TourRepository;
import com.sebastianwrobel.repository.UserRepository;

@Service
public class TourService {
	
	@Autowired
	TourRepository tourRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Tour> findAll(){
		return tourRepo.findAll();
	}

	public void delete(Integer id) {
		tourRepo.deleteById(id);
	}

	public Tour findById(Integer id) {
		//return tourRepo.findById(id).get();
		return tourRepo.getOne(id);
	}

	public void saveOrUpdate(Tour tour) {
		tourRepo.save(tour);
	}
	
	public void addTourDetailsIfNotExists(Tour tour) {
		if(tour.getTourDetails() == null) {
			tour.setTourDetails(new TourDetails());
			saveOrUpdate(tour);
		}
	}
	
	public Tour getByIdWithComments(int id) {
		return tourRepo.getByIdWithComments(id);
	}
	
	public void addUserToTour(Integer id, Integer userId) {
		Tour tour = findById(id);
		
		if(tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		
		User user = userRepo.getOne(userId);
		if(user != null) {
			tour.getUsers().add(user);
			saveOrUpdate(tour);
		}
			
	}
}
