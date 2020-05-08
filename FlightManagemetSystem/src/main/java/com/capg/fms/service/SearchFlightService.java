package com.capg.service;

import java.util.List;

import com.capg.model.Flight;

public interface SearchFlightService {
	
	public List<Integer> getAvailabilityofFlights(String source,String destination,String departureDateTime)throws Exception;
	
	public List<Flight> getAvailabilityofSeats(List<Integer> flightIds)throws Exception;
	
	public List<Flight> searchFlights(String source,String destination,String departureDateTime)throws Exception;

}
