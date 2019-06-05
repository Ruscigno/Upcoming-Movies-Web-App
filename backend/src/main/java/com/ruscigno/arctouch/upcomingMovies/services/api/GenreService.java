package com.ruscigno.arctouch.upcomingMovies.services.api;

import java.util.Optional;

import com.ruscigno.arctouch.upcomingMovies.entities.Genre;

public interface GenreService {
	void populate();
	Optional<Genre> findById(int id);
}
