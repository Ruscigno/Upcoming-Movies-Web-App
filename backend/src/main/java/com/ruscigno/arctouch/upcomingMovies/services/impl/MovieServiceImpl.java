package com.ruscigno.arctouch.upcomingMovies.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    @RequestMapping("/upcoming")
    public String upcomingMovies(@RequestParam(value = "page", defaultValue = "1") int page) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(upcomingURL, apiKey, page), String.class);
    }

    @ResponseBody
    @RequestMapping("/details/{movie_id}")
    public String movieDetails(@PathVariable("movie_id") Long movieId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(detailsURL, movieId, apiKey), String.class);
    }

    @ResponseBody
    @RequestMapping("/search")
    public String search(
        @RequestParam(value = "query", required = true) String query, 
        @RequestParam(value = "page", defaultValue = "1") int page) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(searchURL, query, apiKey, page), String.class);
    }

	@Override
	public String getMovieDetails(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByText(String query, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public UpcomingMoviesTMDbDTO getUpcomingMovies(int page) {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(upcomingURL, apiKey, page), UpcomingMoviesTMDbDTO.class);
    }
    
}