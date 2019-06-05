package com.ruscigno.arctouch.upcomingMovies.deserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.ruscigno.arctouch.upcomingMovies.entities.Genre;
import com.ruscigno.arctouch.upcomingMovies.services.api.GenreService;
import com.ruscigno.arctouch.upcomingMovies.services.impl.GenreServiceImpl;

public class GenreDeserializer extends JsonDeserializer<String> {

	private static final String UNKNOWN_GENRE = "Unknown genre";

	private GenreService genreService;

	private List<String> result = new ArrayList<>();

	@Override
	public String deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		genreService = new GenreServiceImpl();

		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		for (int i = 0; i < node.size(); i++) {
			result.add(findById(node.get(i).toString()));
		}
		if (result.isEmpty())
			return UNKNOWN_GENRE;

		return result.toString();
	}

	private String findById(String id) {
		Optional<Genre> result = genreService.findById(Integer.parseInt(id));
		if (result.isEmpty())
			return UNKNOWN_GENRE;

		return result.get().getName();
	}

}
