package com.capg.fms.dao;
import com.capg.fms.model.Booking;
import java.util.List;

public interface IBookingDao {
public Booking addBooking(Booking bean);
	
	public int modifyBooking(int bookingId);
	
	public Booking viewBookingByBookingId(int bookingId);
	
	public List<Booking> viewAllBooking();
	
	public void deleteBooking(int bookingId);
}