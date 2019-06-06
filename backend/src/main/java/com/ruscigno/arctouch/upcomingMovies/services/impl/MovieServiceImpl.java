package com.ruscigno.arctouch.upcomingMovies.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ruscigno.arctouch.upcomingMovies.dtos.UpcomingMoviesTMDbDTO;
import com.ruscigno.arctouch.upcomingMovies.services.api.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${api_key}")
    private String apiKey;

    @Value("${tmdb_upcoming_url}")
    private String upcomingURL;

    @Value("${tmdb_details_url}")
    private String detailsURL;

    @Value("${tmdb_search_url}")
    private String searchURL;

	@Override
	public String getMovieDetails(Long movieId) {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(detailsURL, movieId, apiKey), String.class);
	}

	@Override
	public UpcomingMoviesTMDbDTO findByText(String query, int page) {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(searchURL, query, apiKey, page), UpcomingMoviesTMDbDTO.class);
	}
	
	@Override
    public UpcomingMoviesTMDbDTO getUpcomingMovies(int page) {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(upcomingURL, apiKey, page), UpcomingMoviesTMDbDTO.class);
    }
    
}