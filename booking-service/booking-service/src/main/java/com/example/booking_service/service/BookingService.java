package com.example.booking_service.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;


@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

public Booking saveBooking(Booking booking) {
	Booking b=bookingRepository.save(booking);
	return b;
}
public List<Booking> getAllBooking(){
	return bookingRepository.findAll();
}
 public Booking getBookingById(Long id) {
	 return bookingRepository.findById(id).get();
 }
 
 public void deleteBooking(Long id) {
	 bookingRepository.deleteById(id);
 }
 
 public Booking updateBooking(Long id,Booking booking) {
	 Booking existing=getBookingById(id);
	 if(existing!=null) {
		 existing.setId(booking.getId());
			existing.setBookingDate(booking.getBookingDate());
			existing.setSeats(booking.getSeats());
	 }
	 return null;
 }
}
