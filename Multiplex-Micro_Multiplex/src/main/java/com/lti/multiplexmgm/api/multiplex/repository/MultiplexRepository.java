package com.lti.multiplexmgm.api.multiplex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.multiplexmgm.api.multiplex.document.MultiplexDocument;

@Repository
public interface MultiplexRepository extends MongoRepository<MultiplexDocument, String> {

}
