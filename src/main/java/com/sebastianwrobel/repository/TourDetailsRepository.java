package com.sebastianwrobel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebastianwrobel.domain.TourDetails;

@Repository
public interface TourDetailsRepository extends JpaRepository<TourDetails, Integer> {

}
