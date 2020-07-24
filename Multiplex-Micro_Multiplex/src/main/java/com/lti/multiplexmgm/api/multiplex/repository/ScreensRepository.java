package com.lti.multiplexmgm.api.multiplex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.multiplexmgm.api.multiplex.document.Screens;

@Repository
public interface ScreensRepository extends MongoRepository<Screens, String> {

}
