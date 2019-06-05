package com.ruscigno.arctouch.upcomingMovies.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ruscigno.arctouch.upcomingMovies.deserializers.GenreDeserializer;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {

    private static final long serialVersionUID = 5246896087248974656L;
    
    private int vote_count;
    private long id;
    private boolean video;
    private double vote_average;
    private String title;
    private double popularity;
    private String poster_path;
    private String original_language;
    private String original_title;
    @JsonDeserialize(using = GenreDeserializer.class)
    private List<String> genre_ids = new ArrayList<>();
    private String backdrop_path;
    private boolean adult;
    private String overview;
    private Date release_date;
}