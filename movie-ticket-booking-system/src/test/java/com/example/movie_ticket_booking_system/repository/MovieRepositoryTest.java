package com.example.movie_ticket_booking_system.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.movie_ticket_booking_system.model.Movie;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryTest {
@Autowired 
MovieRepository movieRepository;
	
@Test
void testSaveMovie() {
    Movie movie = new Movie();
    movie.setTitle("Inception");
    movie.setGenre("Sci-Fi");
  
    Movie saved = movieRepository.save(movie);

    assertNotNull(saved.getId());
    assertEquals("Inception", saved.getTitle());
    assertEquals("Sci-Fi", saved.getGenre());
    
}

@Test
void testFindById() {
    Movie movie = new Movie();
    movie.setTitle("Interstellar");
    movie.setGenre("Sci-Fi");
       Movie saved = movieRepository.save(movie);

    Optional<Movie> found = movieRepository.findById(saved.getId());

    assertTrue(found.isPresent());
    assertEquals("Interstellar", found.get().getTitle());
}

@Test
void testFindByTitle() {
    Movie movie = new Movie();
    movie.setTitle("Avatar");
    movie.setGenre("Fantasy");
   
    movieRepository.save(movie);

    Optional<Movie> result = movieRepository.findByTitle("Avatar");

    assertTrue(result.isPresent());
    assertEquals("Avatar", result.get().getTitle());
}

@Test
void testDeleteMovie() {
    Movie movie = new Movie();
    movie.setTitle("Titanic");
    movie.setGenre("Romance");
    
    Movie saved = movieRepository.save(movie);
    Long id = saved.getId();

    movieRepository.deleteById(id);

    Optional<Movie> result = movieRepository.findById(id);
    assertFalse(result.isPresent());
}

}
