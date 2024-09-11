package com.example.RestaurantReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantReservationSystem.model.RestaurantReservation;
import com.example.RestaurantReservationSystem.service.RestaurantReservationService;

@RestController
@RequestMapping("/api/reservations")
public class RestaurantReservationController {
    
	@Autowired
    private RestaurantReservationService reservationService;

	@GetMapping
    public ResponseEntity<List<RestaurantReservation>> getAllReservations() {
        List<RestaurantReservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
	
    @PostMapping
    public ResponseEntity<RestaurantReservation> createReservation(@RequestBody RestaurantReservation reservation) {
    	RestaurantReservation createdReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantReservation> updateReservation(@PathVariable Long id, @RequestBody RestaurantReservation reservation) {
    	RestaurantReservation updatedReservation = reservationService.updateReservation(id, reservation);
        return ResponseEntity.ok(updatedReservation);
    }
    
}
