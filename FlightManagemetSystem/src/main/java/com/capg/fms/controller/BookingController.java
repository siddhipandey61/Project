package com.capg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.exceptions.*;
import com.capg.fms.model.Booking;
import com.capg.fms.service.*;


@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired(required= true)
	BookingServiceImpl bookingService;

	@PostMapping("/createBooking")
	//@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBooking(@RequestBody Booking newBooking) {

		bookingService.addBooking(newBooking);
	}

	@GetMapping("/readAllBooking")
	public Booking readAllBookings() {

		return bookingService.viewAllBookings();
	}

	@GetMapping("/searchBooking/{id}")
	//@ExceptionHandler(BookingIdNotFoundException.class)
	public Booking searchBookingByID(@PathVariable("id") long bookingId) {
		return bookingService.viewBookingByBookingId(bookingId);
	}

	@DeleteMapping("/deleteBooking/{id}")
	//@ExceptionHandler(InvalidInputException.class)
	public void deleteBookingByID(@PathVariable("id") long bookingId) {

		bookingService.deleteBooking(bookingId);
	}}