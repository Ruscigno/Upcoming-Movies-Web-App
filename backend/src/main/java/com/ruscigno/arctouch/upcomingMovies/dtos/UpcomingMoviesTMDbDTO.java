package com.ruscigno.arctouch.upcomingMovies.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruscigno.arctouch.upcomingMovies.entities.Movie;

import lombok.Data;

@Data
public class UpcomingMoviesTMDbDTO implements Serializable {

    private static final long serialVersionUID = -3058512211175280666L;

    private List<Movie> results = new ArrayList<>();
    private int page;
    private int total_results;
    private Map<String, String> dates = new HashMap<>();
    private int total_pages;
    
}