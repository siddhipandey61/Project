package com.capg.fms.model;

import java.math.BigInteger;

public class BookedSeats
{
	private String category;
	private int no_of_seats;
	private int filled_seats;
	private BigInteger serial_no;
	private int booking_id;
	
	public BookedSeats(String category,int no_of_seats,int filled_seats,BigInteger serial_no,int booking_id)
	{
		super();
		
	this.category=category;
	this.no_of_seats=no_of_seats;
	this.filled_seats=filled_seats;
	this.serial_no=serial_no;
	this.booking_id=booking_id;
	
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public int getFilled_seats() {
		return filled_seats;
	}

	public void setFilled_seats(int filled_seats) {
		this.filled_seats = filled_seats;
	}

	public BigInteger getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(BigInteger serial_no) {
		this.serial_no = serial_no;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	@Override
	public String toString() {
		return "BookedSeats [category=" + category + ", no_of_seats=" + no_of_seats + ", filled_seats=" + filled_seats
				+ ", serial_no=" + serial_no + ", booking_id=" + booking_id + "]";
	}
	
}