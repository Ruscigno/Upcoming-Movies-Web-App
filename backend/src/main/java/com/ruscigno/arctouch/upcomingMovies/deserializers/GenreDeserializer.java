package com.ruscigno.arctouch.upcomingMovies.deserializers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.ruscigno.arctouch.upcomingMovies.ApplicationContextProvider;
import com.ruscigno.arctouch.upcomingMovies.entities.Genre;
import com.ruscigno.arctouch.upcomingMovies.services.api.GenreService;

public class GenreDeserializer extends JsonDeserializer<String> {

	private static final String UNKNOWN_GENRE = "Unknown genre";

	private Set<String> result = new HashSet<>();

	@Override
	public String deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		for (int i = 0; i < node.size(); i++) {
			result.add(findById(node.get(i).toString()));
		}
		if (result.isEmpty())
			return UNKNOWN_GENRE;

		return String.join(", ", result);
	}

	private String findById(String id) {
		GenreService genreService = ApplicationContextProvider.getAppContext().getBean(GenreService.class);

		Optional<Genre> result = genreService.findById(Integer.parseInt(id));
		if (result.isEmpty())
			return UNKNOWN_GENRE;

		return result.get().getName();
	}

}
