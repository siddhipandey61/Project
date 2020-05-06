package com.capg.fms.service;
import com.capg.fms.model.Booking;
import com.capg.fms.model.BookingList;
import com.capg.fms.model.Passenger;


	public interface IBookingService{
		
		Booking addBooking(Booking booking) ;
		Booking viewBookingByBookingId(long bookingId);
		BookingList viewAllBookings();
		Booking modifyBooking(Booking booking);
		boolean deleteBooking(long bookingId);
		boolean validateBookingId(long bookingId);
		boolean validateUserId(long id);
		boolean validateNoOfPassengers(int noOfPassengers);
		void validateBooking(Booking booking);
		void validatePassenger(Passenger passenger);
}