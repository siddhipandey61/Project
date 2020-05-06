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
	
	// This module will add the flights scheduled in the ScheduledFlights.
	@Override
	public boolean addScheduledFlights(ScheduledFlights sflight) {
		entityManager.persist(sflight);
		return true;
	}
	
	//This module will retrieve all the schedules based on the source and destination given by the customer.
	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> retrieveScheduledFlights(String source, String destination) {
		Query query = entityManager.createQuery("select s from Schedule s where Source="+source+"AND Destination="+destination);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ScheduledFlights> retrieveAllScheduledFlights(int scheduleId){
		Query query = entityManager.createQuery("select sf from ScheduledFlights sf where Schedule Id="+scheduleId);
		return query.getResultList();
	}
	
	// This module will update the flights scheduled in the ScheduledFlights.
	@Override
	public boolean updateScheduledFlights(ScheduledFlights sflight) {
		entityManager.getTransaction().begin();
		entityManager.merge(sflight);
		entityManager.getTransaction().commit();
		return true;
	}
	
	// This module will delete the flights scheduled in the ScheduledFlights.
	@Override
	public boolean deleteScheduledFlights(Schedule scheduleId) {
		ScheduledFlights sflight =entityManager.find(ScheduledFlights.class, scheduleId);
		if(sflight !=null)
		{
			entityManager.remove(sflight);
			return true;
		}
		else 
		return false;
	}

}
