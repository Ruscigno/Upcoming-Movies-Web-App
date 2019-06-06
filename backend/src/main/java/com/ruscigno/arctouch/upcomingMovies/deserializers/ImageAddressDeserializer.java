package com.ruscigno.arctouch.upcomingMovies.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ImageAddressDeserializer extends JsonDeserializer<String> {

	private static final String IMAGE_URL = "https://image.tmdb.org/t/p/w500";
	
	@Override
	public String deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		return IMAGE_URL + node.toString().replace("\"", "");
	}

}
