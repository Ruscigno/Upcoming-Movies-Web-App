package com.ruscigno.arctouch.upcomingMovies.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Genre implements Serializable {

	private static final long serialVersionUID = -4360922930010874253L;
	private String name;
	private int id;

}