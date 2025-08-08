package com.example.movie_ticket_booking_system.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_ticket_booking_system.model.Booking;
import com.example.movie_ticket_booking_system.model.Customer;
import com.example.movie_ticket_booking_system.service.BookingService;
import com.example.movie_ticket_booking_system.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	 CustomerService customerService;
	@Autowired
	BookingService bookingService;
	 @GetMapping("/customers")
		public List<Customer> getAllCustomer(){
			return customerService.getAllCustomer();
		}

		@PostMapping("/customers")
		public Customer createCustomer(@RequestBody Customer customer) {
			return customerService.saveCustomer(customer);
		}
		@GetMapping("/customers/{id}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
			Customer customer = customerService.getCustomerById(id);
			return  new ResponseEntity<Customer>(customer,HttpStatus.OK) ;
		}
		
		@PutMapping("/customers/{id}")
		public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		
	 	return customerService.updateCustomer(id, customer);
			
			
			
		}
		@DeleteMapping("/customers/{id}")
		public String deleteCustomer(@PathVariable Long id) {
			customerService.deleteCustomer(id);
			return "customer deleted with this "+id;
			
		}
	
}
