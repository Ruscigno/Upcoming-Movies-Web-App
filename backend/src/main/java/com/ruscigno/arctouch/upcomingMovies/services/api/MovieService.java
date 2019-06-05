package com.ruscigno.arctouch.upcomingMovies.services.api;

import com.ruscigno.arctouch.upcomingMovies.dtos.UpcomingMoviesTMDbDTO;

public interface MovieService {

    UpcomingMoviesTMDbDTO getUpcomingMovies(int page);

	String getMovieDetails(Long movieId);

	String findByText(String query, int page);
    
}