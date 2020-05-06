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
	public BookedSeats newSeat(BookedSeats seat) {
		entityManager.persist(seat);
		return seat;
	}

	@Override
	public BookedSeats getSeat(int seatnumber) {
		return entityManager.find(BookedSeats.class, seatnumber);
	}

	@Override
	public List<BookedSeats> getAllSeat() {
		String query = "select seats";
		TypedQuery<BookedSeats> bs = entityManager.createQuery(query, BookedSeats.class);
		return bs.getResultList();
		
	}
}

