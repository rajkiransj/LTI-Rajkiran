package com.lti.multiplexmgm.api.multiplex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.lti.multiplexmgm.api.multiplex.document.MultiplexDocument;
import com.lti.multiplexmgm.api.multiplex.service.MultiplexService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/multiplex")
public class MultiplexController {

	@Autowired
	private MultiplexService multiplexService;

	// Create new multiplex
	@PostMapping /* (produces = "application/json") */
	public ResponseEntity<Object> registerMultiplex(@RequestBody MultiplexDocument multiplexDoc) {
		try {
			this.multiplexService.registerMultiplex(multiplexDoc);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// Get all multiplex List
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<MultiplexDocument>> getAllMultiplex() {

		List<MultiplexDocument> multiplexList = this.multiplexService.findAll();
		if (!multiplexList.isEmpty()) {
			return new ResponseEntity<List<MultiplexDocument>>(multiplexList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Delete Multiplex by using multiplex id
	@DeleteMapping(path = "/{multiplexid}")
	public ResponseEntity<String> deleteMultiplex(@PathVariable String multiplexid) {
		ResponseEntity<String> response;
		if (this.multiplexService.deleteMujltiplexById(multiplexid)) {
			response = new ResponseEntity<String>("Moive deleted successfully", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Movie not present in system", HttpStatus.NOT_FOUND);
		}

		return response;
	}

	
	// Get Multiplex details by id
	@GetMapping(path = "/{multiplexId}")
	public ResponseEntity<Optional<MultiplexDocument>> getMovie(@PathVariable String multiplexId) {

		Optional<MultiplexDocument> multiplex = this.multiplexService.getMultiplexDetail(multiplexId);

		return new ResponseEntity<Optional<MultiplexDocument>>(multiplex, HttpStatus.OK);
	}

	// Update Multiplex by multiplex Id
	@PutMapping(path = "/{multiplexId}")
	public ResponseEntity<MultiplexDocument> updateMultiplex(@PathVariable String multiplexId,
			@RequestBody MultiplexDocument multiplexDocument) {
		MultiplexDocument mdoc = multiplexService.updateMultiplexDetail(multiplexId, multiplexDocument);
		return new ResponseEntity<MultiplexDocument>(mdoc, HttpStatus.OK);
	}

	@GetMapping("/status/check")
	public String checkStatus() {
		return "Multiplex Controller";
	}

}
