package com.ruscigno.arctouch.upcomingMovies.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class GenreList implements Serializable{
	private static final long serialVersionUID = 2865520994565947664L;
	private List<Genre> genres = new ArrayList<>();    
}