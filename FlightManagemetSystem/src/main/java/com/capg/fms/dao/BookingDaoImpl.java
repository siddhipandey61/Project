package com.capg.fms.dao;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.capg.fms.model.Booking;

@Repository
@Transactional

public class BookingDaoImpl implements IBookingDao
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Booking addBooking(Booking bean) 
	{
		em.persist(bean);
		
		return bean;
	}
	
	public List<Booking> viewAllBooking() 
	{
		TypedQuery<Booking> query = em.createQuery("from Booking", Booking.class);
		return query.getResultList();
	}
	
	public Booking viewBookingByBookingId(int bookingId) 
	{
		return em.find(Booking.class, bookingId);
	}
	
	public void deleteBooking(int bookingId) 
	{
		Booking b = em.find(Booking.class, bookingId);
		em.remove(b);
	}

	public int modifyBooking(int bookingId) {
		// TODO Auto-generated method stub
		return 0;
	}
}