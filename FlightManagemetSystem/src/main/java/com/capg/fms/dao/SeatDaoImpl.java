package com.capg.fms.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.capg.fms.model.BookedSeats;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

@Repository
public class SeatDaoImpl implements SeatDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addSeat(BookedSeats seat) {
		entityManager.persist(seat);
	}

	@Override
	public void updateSeat(BookedSeats seat) {
	entityManager.getTransaction().begin();
	entityManager.merge(seat);
	entityManager.getTransaction().commit();
	}

	@Override
	public BookedSeats retrieveSeat(int seatnumber) {
		return entityManager.find(BookedSeats.class, seatnumber);
	}

	@Override
	public List<BookedSeats> retrieveAllSeat() {
		String query = "select seats";
		TypedQuery<BookedSeats> bs = entityManager.createQuery(query, BookedSeats.class);
		return bs.getResultList();
		
	}

	@Override
	public boolean deleteSeat(int seatnumber) {
		BookedSeats bookedseats = entityManager.find(BookedSeats.class, seatnumber);
		if(bookedseats != null)
		{
			entityManager.remove(bookedseats);
			return true;
		}
		else {
			
		return false;	
		}
	}
}
