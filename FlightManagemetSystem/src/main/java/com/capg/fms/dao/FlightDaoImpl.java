package com.capg.fms.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capg.fms.model.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	EntityManager entityManager;	
	
	@Override
	public void  addFlight(Flight flight) {	
		entityManager.persist(flight);
		
	}

	@Override
	public void updateFlight(Flight flight) {
		entityManager.getTransaction().begin();
		entityManager.merge(flight);
		entityManager.getTransaction().commit();
	}

	@Override
	public Flight retrieveFlight(long flightNumber) {
		return entityManager.find(Flight.class, flightNumber);
	}

	@Override
	public List<Flight> retrieveAllFlights() {
		String query = "select flight from Flight ";
		TypedQuery<Flight> fs = entityManager.createQuery(query, Flight.class);
		return fs.getResultList();	
	}

	@Override
	public boolean deleteFlight(long flightNumber) {
		Flight flight = entityManager.find(Flight.class, flightNumber);
		if(flight != null)
		{
			entityManager.remove(flight);
			return true;
		}
		else {
		return false;	
		}
	}
}

