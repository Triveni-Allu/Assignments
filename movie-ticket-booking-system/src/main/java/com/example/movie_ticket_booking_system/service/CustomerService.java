package com.example.movie_ticket_booking_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_system.model.Customer;
import com.example.movie_ticket_booking_system.repository.CustomerRepository;

@Service
public class CustomerService {
@Autowired
CustomerRepository customerRepository;
public Customer saveCustomer(Customer customer) {
	Customer c=customerRepository.save(customer);
	return c;
}
public List<Customer> getAllCustomer(){
	return customerRepository.findAll();
}
 public Customer getCustomerById(Long id) {
	 return customerRepository.findById(id).get();
 }
 
 public void deleteCustomer(Long id) {
	 customerRepository.deleteById(id);
 }
 
 public Customer updateCustomer(Long id,Customer customer) {
	 Customer existing=getCustomerById(id);
	 if(existing!=null) {
		 existing.setId(customer.getId());
			existing.setEmail(customer.getEmail());
			existing.setName(customer.getName());
	 }
	 return null;
 }
}
