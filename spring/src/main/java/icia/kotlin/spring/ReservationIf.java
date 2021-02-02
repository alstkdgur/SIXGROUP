package icia.kotlin.spring;

import java.util.ArrayList;

import icia.kotlin.beans.Movie;

public interface ReservationIf {
	

	public ArrayList<Movie> getMovieList();

	public ArrayList<Movie> selMovieList(Movie movie);
}
