package com.ruscigno.arctouch.upcomingMovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruscigno.arctouch.upcomingMovies.dtos.UpcomingMoviesTMDbDTO;
import com.ruscigno.arctouch.upcomingMovies.services.api.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping(value = "/upcoming")
	public ResponseEntity<UpcomingMoviesTMDbDTO> upcomingMovies(
			@RequestParam(value = "page", defaultValue = "0") int page) {
		return ResponseEntity.ok(movieService.getUpcomingMovies(page + 1));
	}

	@ResponseBody
	@RequestMapping("/details/{movie_id}")
	public ResponseEntity<String> movieDetails(@PathVariable("movie_id") Long movieId) {
		return ResponseEntity.ok(movieService.getMovieDetails(movieId));
	}

	@ResponseBody
	@RequestMapping("/search")
	public ResponseEntity<UpcomingMoviesTMDbDTO> search(@RequestParam(value = "query", required = true) String query,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		return ResponseEntity.ok(movieService.findByText(query, page + 1));
	}
}