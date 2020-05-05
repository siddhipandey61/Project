package com.capg.fms.dao;

import java.util.List;
import javax.persistence.Entitymanager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capg.fms.model.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDaoI {

	@PersistenceContext
	EntityManager entityManager;	
	
	public void  addPassenger(Passenger passenger) {	
		entityManager.persist(passenger);
		
	}

	public void updatePassenger(Passenger passenger) {
		entityManager.getTransaction().begin();
		entityManager.merge(passenger);
		entityManager.getTransaction().commit();
	}

	public Passenger retrievePassenger(long pnrNumber) {
		return entityManager.find(Passenger.class, pnrNumber);
	}

	@Override
	public List<Passenger> retrieveAllPassenger() {
		String query = "select passenger from Passenger ";
		TypedQuery<Passenger> fs = entityManager.createQuery(query, Passenger.class);
		return fs.getResultList();	
	}

	@Override
	public boolean deletePassenger(long pnrNumber) {
		Passenger passenger = entityManager.find(Passenger.class, pnrNumber);
		if(passenger != null)
		{
			entityManager.remove(passenger);
			return true;
		}
		else {
		return false;	
		}
	}
}

