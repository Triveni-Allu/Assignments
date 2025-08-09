package com.example.movie_service.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.model.Movie;
import com.example.movie_service.repository.MovieRepository;


@Service
public class MovieService {
@Autowired
MovieRepository movieRepository;

public Movie saveMovie(Movie movie) {
	Movie m=movieRepository.save(movie);
	return m;
}
public List<Movie> getAllMovies(){
	return movieRepository.findAll();
}
 public Movie getMovieById(Long id) {
	 return movieRepository.findById(id).get();
 }
 
 public void deleteMovie(Long id) {
	 movieRepository.deleteById(id);
 }
 
 public Movie updateMovie(Long id,Movie movie) {
	 Movie existing=getMovieById(id);
	 if(existing!=null) {
		 existing.setId(movie.getId());
			existing.setTitle(movie.getTitle());
			existing.setGenre(movie.getGenre());
	 }
	 return null;
 }
}



