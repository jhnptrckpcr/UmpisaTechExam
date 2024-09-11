package com.example.RestaurantReservationSystem.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.RestaurantReservationSystem.model.RestaurantReservation;
import com.example.RestaurantReservationSystem.repo.RestaurantReservationRepository;

@Service
public class RestaurantReservationService {
   
	@Autowired
    private RestaurantReservationRepository reservationRepository;

	public List<RestaurantReservation> getAllReservations() {
        return reservationRepository.findAll();
    }
	
    public RestaurantReservation createReservation(RestaurantReservation reservation) {
        System.out.println("Email sent. Reservation created.");
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long id) {
    	if (reservationRepository.existsById(id)) {
    		reservationRepository.deleteById(id);
            System.out.println("Email sent. Reservation canceled.");
    	} else {
    		System.out.println("Reservation does not exist!");
    	}
    }

    public RestaurantReservation updateReservation(Long id, RestaurantReservation reservationDetails) {
    	RestaurantReservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found!"));

        reservation.setReservationDateTime(reservationDetails.getReservationDateTime());
        reservation.setNumberOfGuests(reservationDetails.getNumberOfGuests());
        System.out.println("Email sent. Reservation updated.");
        return reservationRepository.save(reservation);
    }
    
    // Check every 30 minutes for reservations due for reminders
    @Scheduled(fixedRate = 30 * 60 * 1000)
    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime reminderTime = now.plus(4, ChronoUnit.HOURS);

        List<RestaurantReservation> reservations = reservationRepository.findAll();
        for (RestaurantReservation reservation : reservations) {
            if (reservation.getReservationDateTime().isBefore(reminderTime) && reservation.getReservationDateTime().isAfter(now)) {
                sendReminder(reservation);
            }
        }
    }

    private void sendReminder(RestaurantReservation reservation) {
        String message = String.format("Reminder: Your reservation at %s for %d guests is coming up in 4 hours.",
                reservation.getReservationDateTime(), reservation.getNumberOfGuests());

        System.out.println("Email sent! " + message);
    }
    
}