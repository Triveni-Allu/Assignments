package com.example.movie_ticket_booking_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie_ticket_booking_system.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
	 Optional<Movie> findByTitle(String title);
}
