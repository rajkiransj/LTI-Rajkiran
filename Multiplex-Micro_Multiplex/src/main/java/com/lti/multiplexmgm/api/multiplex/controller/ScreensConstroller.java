package com.lti.multiplexmgm.api.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.multiplexmgm.api.multiplex.document.Screens;
import com.lti.multiplexmgm.api.multiplex.service.ScreensService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/screens")
public class ScreensConstroller {
	
	@Autowired
	private ScreensService service;
	
	@GetMapping(consumes = "application/json")
	public ResponseEntity<List<Screens>> getAllScreens(){
		List<Screens> screens = this.service.findAll();
		if(screens instanceof List)
			return new ResponseEntity<List<Screens>>(screens,HttpStatus.OK);
		else
			return new ResponseEntity<List<Screens>>(HttpStatus.NO_CONTENT);

	}

}
