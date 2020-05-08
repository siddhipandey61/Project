package com.capg.dao;

import java.util.List;

import com.capg.entity.FlightEntity;
import com.capg.model.Flight;

public interface SearchFlightDAO {
	
	public List<Integer> getAvailabilityofFlights(String source,String destination,String departureDateTime)throws Exception;
	
	public List<Flight> getAvailabilityofSeats(List<Integer> flightIds)throws Exception;

}
