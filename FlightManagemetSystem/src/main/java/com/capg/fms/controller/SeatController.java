package com.capg.fms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.service.SeatService;
import com.capg.fms.model.BookedSeats;


@RestController
@RequestMapping("/bookedSeats")
 
public class SeatController 
{
	@Autowired
	private SeatService seatservice;
	
	
	@PostMapping(value="/addSeat",produces= {"application/json"})
	public String newSeat(@RequestBody BookedSeats seat)
	{
		seatservice.newSeat(seat);
		return "Seat added successfully";
	}
	
	
	@GetMapping(value="/getSeat/{seatnumber}",produces={"application/json"})
	public List<BookedSeats> displayBookedSeats(@PathVariable int seatnumber)
	{
		return seatservice.getAllSeat(seatnumber);
	}
	
}