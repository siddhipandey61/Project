package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.model.Passenger;

public interface PassengerDaoI {

	public void addUser(Passenger passenger);
	public void updateUser(Passenger passenger);
	public Passenger retrieveUser(long pnrNumber);
	public List<Passenger> retrieveAllPassenger();
	public boolean deletePassenger(long pnrNumber);
	
}

