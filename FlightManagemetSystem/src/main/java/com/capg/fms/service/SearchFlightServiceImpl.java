package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.SearchFlightDAO;
import com.capg.model.Flight;
@Service("SearchFlightService")
public class SearchFlightServiceImpl implements SearchFlightService{

	@Autowired
	private SearchFlightDAO searchFlightDao;
	
	
	@Override
	public List<Integer> getAvailabilityofFlights(String source,String destination,String departureDateTime) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> flightIds = searchFlightDao.getAvailabilityofFlights(source, destination, departureDateTime);
		if(flightIds != null)
			return flightIds;
		return null;		
		
	}

	@Override
	public List<Flight> getAvailabilityofSeats(List<Integer> flightIds) throws Exception {
		// TODO Auto-generated method stub
		List<Flight> flights = searchFlightDao.getAvailabilityofSeats(flightIds);
		if(flights != null)
			return flights;
		return null;
		
	}

	@Override
	public List<Flight> searchFlights(String source, String destination, String departureDateTime) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> flightIds = getAvailabilityofFlights(source, destination, departureDateTime);
		if(flightIds != null) {
			List<Flight> flights = getAvailabilityofSeats(flightIds);
			if(flights != null)
				return flights;
		}
		return null;

	}
	
	

}
