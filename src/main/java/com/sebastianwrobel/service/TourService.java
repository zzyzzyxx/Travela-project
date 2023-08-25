package com.sebastianwrobel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Tour;
import com.sebastianwrobel.domain.TourDetails;
import com.sebastianwrobel.repository.TourRepository;

@Service
public class TourService {
	
	@Autowired
	TourRepository tourRepo;
	
	public List<Tour> findAll(){
		return tourRepo.findAll();
	}


	public void delete(Integer id) {
		tourRepo.deleteById(id);
	}


	public Tour findById(Integer id) {
		//return tourRepo.findById(id);
		return tourRepo.findById(id).get();
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
}
