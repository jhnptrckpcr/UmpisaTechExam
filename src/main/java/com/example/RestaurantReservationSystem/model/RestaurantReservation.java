package com.example.RestaurantReservationSystem.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class RestaurantReservation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private LocalDateTime reservationDateTime;
    private int numberOfGuests;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getReservationDateTime() {
		return reservationDateTime;
	}
	public void setReservationDateTime(LocalDateTime reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
    
}