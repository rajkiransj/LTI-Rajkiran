package com.lti.moviemgm.api.movie.ui.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.moviemgm.api.movie.ui.dao.MovieRepository;
import com.lti.moviemgm.api.movie.ui.document.Movie;
import com.lti.moviemgm.api.movie.ui.dto.MovieDetailsDto;
import com.lti.moviemgm.api.movie.ui.dto.MovieDto;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public MovieDetailsDto saveMovie(MovieDto moviedto) {

		Movie movieobj = new Movie(null, moviedto.getName(), moviedto.getCategory(), moviedto.getProducer(),
				moviedto.getDirector(), moviedto.getReleaseDate());
		movieobj = repository.save(movieobj);
		MovieDetailsDto movieDtls = new MovieDetailsDto(movieobj.getName(), movieobj.getCategory(),
				movieobj.getProducer(), movieobj.getDirector(), movieobj.getReleaseDate());

		return movieDtls;

	}

	@Override
	public Optional<Movie> getMovieById(String moviveid) {
		Optional<Movie> movie = repository.findById(moviveid);
		return movie;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = repository.findAll();
		return movieList;
	}

	@Override
	public boolean deleteMovie(String movieid) {

		if (repository.existsById(movieid)) {
			repository.deleteById(movieid);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public MovieDetailsDto updateMovie(MovieDto moviedto, String movieid) {

		Optional<Movie> movie = repository.findById(movieid);
		Movie movieobj = null;
		// if is present do update
		if (movie.isPresent()) {
			movieobj = new Movie(movieid, moviedto.getName(), moviedto.getCategory(), moviedto.getProducer(),
					moviedto.getDirector(), moviedto.getReleaseDate());
			movieobj = repository.save(movieobj);
		}

		MovieDetailsDto movieDtls = new MovieDetailsDto(movieobj.getName(), movieobj.getCategory(),
				movieobj.getProducer(), movieobj.getDirector(), movieobj.getReleaseDate());

		return movieDtls;
	}

}
