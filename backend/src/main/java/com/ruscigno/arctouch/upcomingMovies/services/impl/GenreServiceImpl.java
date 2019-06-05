package com.ruscigno.arctouch.upcomingMovies.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ruscigno.arctouch.upcomingMovies.entities.Genre;
import com.ruscigno.arctouch.upcomingMovies.entities.GenreList;
import com.ruscigno.arctouch.upcomingMovies.services.api.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Value("tmdb_genre_url")
	private String genreURL;

	@Value("api_key")
	private String apiKey;

	@Autowired
	private GenreList genres;

	@Override
	public void populate() {
		genres.getGenres().clear();

		RestTemplate restTemplate = new RestTemplate();
		genres = restTemplate.getForObject(String.format(genreURL, apiKey), GenreList.class);
	}

	@Override
	public Optional<Genre> findById(int id) {
		if (genres.getGenres().isEmpty())
			populate();
		return genres.getGenres().stream().filter(genre -> genre.getId() == id).findFirst();
	}
}