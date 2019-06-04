package com.ruscigno.arctouch.UpcomingMovies.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    private RestTemplate restTemplate = new RestTemplate();

    @ResponseBody
    @RequestMapping("/upcoming")
    public String upcomingMovies2(@RequestParam(value = "page", defaultValue = "1") int page) {
        RestTemplate restTemplate = new RestTemplate();
        String quote = restTemplate.getForObject(String.format(upcomingURL, apiKey, page), String.class);
        return quote;
    }
}