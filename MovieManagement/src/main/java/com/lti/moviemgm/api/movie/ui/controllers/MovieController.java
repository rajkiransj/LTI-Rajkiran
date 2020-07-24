package com.lti.moviemgm.api.movie.ui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.moviemgm.api.movie.ui.document.Movie;
import com.lti.moviemgm.api.movie.ui.dto.MovieDetailsDto;
import com.lti.moviemgm.api.movie.ui.dto.MovieDto;
import com.lti.moviemgm.api.movie.ui.dto.ResponseMessage;
import com.lti.moviemgm.api.movie.ui.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private Environment env;

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MovieDetailsDto> saveMovie(@RequestBody MovieDto movieDto) {

		ResponseEntity<MovieDetailsDto> response;
		try {
			MovieDetailsDto movieDetailsDto = this.movieService.saveMovie(movieDto);
			response = new ResponseEntity<>(movieDetailsDto, HttpStatus.OK);
		} catch (Exception ex) {
			response = new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}

	@PutMapping(path = "/{movieid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseMessage> updateMovie(@PathVariable String movieid, @RequestBody MovieDto movieDto) {

		// ResponseEntity<ResponseMessage> response;
		ResponseMessage response = new ResponseMessage();
		try {
			MovieDetailsDto moviedtls = this.movieService.updateMovie(movieDto, movieid);
			if (moviedtls instanceof MovieDetailsDto) {
				response.setMessageType(env.getProperty("response.messagetype.success"));
				response.setMessage(movieDto.getName().toUpperCase() + " UPDATED SUCCESSFULLY");
			} else {
				response.setMessageType(env.getProperty("response.messagetype.failure"));
				response.setMessage(movieDto.getName() + "NOT FOUND ON THE PORTAL");
			}
		} catch (Exception ex) {
			throw new RuntimeException("Student not found");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{movieid}")
	public ResponseEntity<String> deleteMovie(@PathVariable String movieid) {
		ResponseEntity<String> response;
		if (this.movieService.deleteMovie(movieid)) {
			response = new ResponseEntity<String>("Moive deleted successfully", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Movie not present in system", HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping(path = "/{movieid}"/*
									 * , consumes = {MediaType.APPLICATION_JSON_VALUE}
									 */
	)
	public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String movieid) {

		Optional<Movie> movie = this.movieService.getMovieById(movieid);

		return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
	}

	@GetMapping(
			/* consumes = {MediaType.APPLICATION_JSON_VALUE}, */
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Movie>> getAllMovie() {

		List<Movie> allMoviesList = this.movieService.getAllMovies();
		if (!allMoviesList.isEmpty()) {
			return new ResponseEntity<List<Movie>>(allMoviesList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping("/status/check")
	public String getStatus() {
		return "Working on port " + env.getProperty("local.server.port");
	}

}
