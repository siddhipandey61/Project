package com.capg.fms.dao;

import java.util.List;
import com.capg.fms.model.*;

public interface SeatDao 
{

	public void addSeat(BookedSeats seat);
	public void updateSeat(BookedSeats seat);
	public BookedSeats retrieveSeat(int seatnumber);
	public List<BookedSeats> retrieveAllSeat();
	public boolean deleteSeat(int seatnumber);
	
}
