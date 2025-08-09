package com.example.theater_service.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_service.model.Theater;
import com.example.theater_service.repository.TheaterRepository;



@Service
public class TheaterService {
	@Autowired
	TheaterRepository theaterRepository;
	public Theater saveTheater(Theater theater) {
		Theater t=theaterRepository.save(theater);
		return t;
	}
	public List<Theater> getAllTheater(){
		return theaterRepository.findAll();
	}
	 public Theater getTheaterById(Long id) {
		 return theaterRepository.findById(id).get();
	 }
	 
	 public void deleteTheater(Long id) {
		 theaterRepository.deleteById(id);
	 }
	 
	 public Theater updateTheater(Long id,Theater theater) {
		 Theater existing=getTheaterById(id);
		 if(existing!=null) {
			 existing.setId(theater.getId());
				existing.setLocation(theater.getLocation());
				existing.setName(theater.getName());
		 }
		 return null;
	 }

}
