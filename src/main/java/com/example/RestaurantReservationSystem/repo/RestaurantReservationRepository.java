package com.example.RestaurantReservationSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestaurantReservationSystem.model.RestaurantReservation;

@Repository
public interface RestaurantReservationRepository extends JpaRepository<RestaurantReservation, Long> {
    
	List<RestaurantReservation> findByEmail(String email);
	
}
