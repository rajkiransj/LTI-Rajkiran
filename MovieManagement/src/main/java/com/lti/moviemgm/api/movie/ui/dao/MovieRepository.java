package com.lti.moviemgm.api.movie.ui.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.moviemgm.api.movie.ui.document.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String>{

}
