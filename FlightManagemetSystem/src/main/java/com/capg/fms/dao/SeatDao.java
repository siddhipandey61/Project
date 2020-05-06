package com.capg.fms.dao;

import java.util.List;
import com.capg.fms.model.*;

public interface SeatDao 
{

	public BookedSeats newSeat(BookedSeats seat);
	public BookedSeats getSeat(int seatnumber);
	public List<BookedSeats> getAllSeat();
	
	
}
