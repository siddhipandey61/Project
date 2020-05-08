package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.service.SearchFlightService;
import com.capg.model.Flight;

@RestController
@RequestMapping(value="/")
public class SearchAPI {
	
	@Autowired
	private SearchFlightService searchFlightService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Flight>> searchFlights(@PathVariable String source, @PathVariable String destination,
			@PathVariable String departureDate)throws Exception{
		try {
			List<Flight> flights = searchFlightService.searchFlights(source, destination, departureDate);
			ResponseEntity<List<Flight>> response = new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
			return response;
		}catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
		}
		
	}

}
