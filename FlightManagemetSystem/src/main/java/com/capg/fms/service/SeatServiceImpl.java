package com.capg.fms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.model.BookedSeats;
import com.capg.fms.dao.SeatDao;

@Service
@Transactional
public class SeatServiceImpl implements SeatService
{
	@Autowired 
	private SeatDao seatdao;

	@Override
	public BookedSeats newSeat(BookedSeats seat) {
		seatdao.newSeat(seat);
		return seat;
	}

	@Override
	public BookedSeats getSeat(int seatnumber) {
		return seatdao.getSeat(seatnumber);
	
	}

	@Override
	public List<BookedSeats> getAllSeat() {
		return seatdao.getAllSeat();
	
	}
}
