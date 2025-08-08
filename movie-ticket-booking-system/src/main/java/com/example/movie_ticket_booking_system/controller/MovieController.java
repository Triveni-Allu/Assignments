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
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_ticket_booking_system.model.Movie;
import com.example.movie_ticket_booking_system.service.MovieService;



@RestController
@RequestMapping("/api")
public class MovieController {
 @Autowired
 MovieService movieService;
 @GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@PostMapping("/movies")
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		Movie movie = movieService.getMovieById(id);
		return  new ResponseEntity<Movie>(movie,HttpStatus.OK) ;
	}
	
	@PutMapping("/movies/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
	
 	return movieService.updateMovie(id, movie);
		
		
		
	}
	@DeleteMapping("/movies/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "movie deleted with this "+id;
		
	}
}
