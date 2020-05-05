package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.fms.model.ScheduledFlights;

@Repository
public class ScheduledFlightsDaoImpl implements ScheduledFlightsDao{

	@PersistenceContext
	EntityManager entityManager;
	
	/* This module will add the flights scheduled in the ScheduledFlights.
	 * Parameters:serial no, schedule id, flight id. */
	@Override
	public void addScheduledFlights(ScheduledFlights sflight) {
		entityManager.persist(sflight);
	}

	/* This module will retrieve the flight scheduled in the ScheduledFlights.
	 * Parameters:serial no, schedule id, flight id. */
	@Override
	public ScheduledFlights retrieveScheduledFlight(int serialno) {
		return entityManager.find(ScheduledFlights.class, serialno);
	}

	/* This module will retrieve all flights scheduled in the ScheduledFlights.
	 * Parameters:serial no, schedule id, flight id. */
	@Override
	public List<ScheduledFlights> retrieveAllScheduledFlights() {
		String query = "select sflight from ScheduledFlights sflight";
		TypedQuery<ScheduledFlights> q = entityManager.createQuery(query, ScheduledFlights.class);
		return q.getResultList();
	}
	
	/* This module will update the flights scheduled in the ScheduledFlights.
	 * Parameters:serial no, schedule id, flight id. */
	@Override
	public void updateScheduledFlights(ScheduledFlights sflight) {
		entityManager.getTransaction().begin();
		entityManager.merge(sflight);
		entityManager.getTransaction().commit();
	}
	
	/* This module will delete the flights scheduled in the ScheduledFlights.
	 * Parameters:serial no, schedule id, flight id. */
	@Override
	public boolean deleteScheduledFlights(int serialno) {
		ScheduledFlights sflight =entityManager.find(ScheduledFlights.class, serialno);
		if(sflight !=null)
		{
			entityManager.remove(sflight);
			return true;
		}
		else 
		return false;
	}

}
