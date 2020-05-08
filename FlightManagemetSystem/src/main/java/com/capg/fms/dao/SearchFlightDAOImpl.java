package com.capg.dao;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capg.dao.SearchFlightDAO;
import com.capg.entity.FlightEntity;
import com.capg.entity.ScheduleEntity;
import com.capg.model.Flight;

@Repository(value="SearchFlightDao")
public class SearchFlightDAOImpl implements SearchFlightDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Integer> getAvailabilityofFlights(String source,String destination,String departureDate) throws Exception {
		// TODO Auto-generated method stub
		//converting string to date
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    DateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
	    Date date = formatter.parse(departureDate);
	    Date date2 = formatter2.parse(departureDate+" "+"59:59:59.999");
	      
	      Timestamp timeStampDate = new Timestamp(date.getTime());
	      Timestamp timeStampDate2 = new Timestamp(date2.getTime());
		Query query = entityManager.createQuery("SELECT s.scheduleId from ScheduleEntity s WHERE s.source = ?1 and s.destination = ?2 and s.departureDateTime BETWEEN ?3 AND ?4)");
		query.setParameter(1,source);
		query.setParameter(2, destination);
		query.setParameter(3, timeStampDate);
		query.setParameter(4, timeStampDate2);
		List<Integer> scheduleIds = query.getResultList();
		if (scheduleIds== null)
			return null;
		query = entityManager.createQuery("SELECT sf.FlightEntity.flightNumber from ScheduledFlightsEntity sf WHERE sf.ScheduleEntity.scheduleId IN ?1");
		query.setParameter(1, scheduleIds);
		List<Integer> flightIds = query.getResultList();
		if (flightIds==null)
			return null;
		return flightIds;
		
	}

	@Override
	public List<Flight> getAvailabilityofSeats(List<Integer> flightIds) throws Exception {
		// TODO Auto-generated method stub
		List<Flight> flights = new ArrayList<Flight>();
		Query query = entityManager.createQuery("SELECT f from FlightsEntity f WHERE f.flightNumber IN ?1 AND f.seatCapacity>0");
		query.setParameter(1, flightIds);
		List<FlightEntity> flightEntities = query.getResultList();
		if(flightEntities!=null) {
			for (FlightEntity flightEntity:flightEntities) {
				Flight flight = new Flight();
				flight.setFlightNumber(flightEntity.getFlightNumber());
				flight.setCarrierName(flightEntity.getCarrierName());
				flight.setSeatCapacity(flightEntity.getSeatCapacity());
				flights.add(flight);
			}
			return flights;
		}
		return null;
	}

}
