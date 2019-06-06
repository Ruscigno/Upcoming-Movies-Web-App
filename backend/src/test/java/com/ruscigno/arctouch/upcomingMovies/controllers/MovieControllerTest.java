package com.ruscigno.arctouch.upcomingMovies.controllers;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ruscigno.arctouch.upcomingMovies.dtos.UpcomingMoviesTMDbDTO;
import com.ruscigno.arctouch.upcomingMovies.entities.Movie;
import com.ruscigno.arctouch.upcomingMovies.services.api.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MovieControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private MovieService movieService;

	@Before
	public void setUp() throws Exception {
		UpcomingMoviesTMDbDTO dto = new UpcomingMoviesTMDbDTO();
		Movie movie = new Movie();
		dto.getResults().add(movie);

		BDDMockito.given(movieService.findByOrgaoFlPortalTransparencia()).willReturn(dto);
	}

	@Test
	public void findOrgaoByFlPortalTransparenciaTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.errors").isEmpty());
	}
}
