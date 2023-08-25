package com.sebastianwrobel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.TourDetails;
import com.sebastianwrobel.repository.TourDetailsRepository;
@Service
public class TourDetailsService {
	@Autowired
	TourDetailsRepository tourDetailsRepo;
	
	public TourDetails findById(Integer id) {
		return tourDetailsRepo.getOne(id);
	}
	
	public void saveOrUpdate(TourDetails tourDetails) {
		tourDetailsRepo.save(tourDetails);
	}
	
	public void delete(Integer id) {
		tourDetailsRepo.deleteById(id);
	}
}
