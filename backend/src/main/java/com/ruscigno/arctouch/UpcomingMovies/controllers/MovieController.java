package com.ruscigno.arctouch.UpcomingMovies.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
class MovieController {

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
}