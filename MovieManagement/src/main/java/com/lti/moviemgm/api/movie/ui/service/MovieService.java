package com.lti.moviemgm.api.movie.ui.service;

import java.util.List;
import java.util.Optional;

import com.lti.moviemgm.api.movie.ui.document.Movie;
import com.lti.moviemgm.api.movie.ui.dto.MovieDetailsDto;
import com.lti.moviemgm.api.movie.ui.dto.MovieDto;

public interface MovieService {

	MovieDetailsDto saveMovie(MovieDto moviedto);
	Optional<Movie> getMovieById(String moviveid);
	List<Movie> getAllMovies();
	boolean deleteMovie(String movieid);
	MovieDetailsDto updateMovie(MovieDto moviedto,String movieid);
}
