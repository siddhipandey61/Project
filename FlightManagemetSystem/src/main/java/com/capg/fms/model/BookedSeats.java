package com.capg.fms.model;

import java.math.BigInteger;
import javax.persistence.Entity;

@Entity
public class BookedSeats
{
	private String category;
	private int noOfSeats;
	private BigInteger serialNo;
	private int bookingId;
	
	public BookedSeats(String category,int noOfSeats,BigInteger serialNo,int bookingId)
	{
		super();
		
	this.category=category;
	this.noOfSeats=noOfSeats;
	this.serialNo=serialNo;
	this.bookingId=bookingId;
	
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public BigInteger getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(BigInteger serialNo) {
		this.serialNo = serialNo;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "BookedSeats [category=" + category + ", noOfSeats=" + noOfSeats + ", serialNo=" + serialNo
				+ ", bookingId=" + bookingId + "]";
	}
	
}
