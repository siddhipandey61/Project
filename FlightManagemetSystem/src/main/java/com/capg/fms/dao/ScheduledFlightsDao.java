package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.model.ScheduledFlights;

public interface ScheduledFlightsDao {
	public void addScheduledFlights(ScheduledFlights sflight);
	public ScheduledFlights retrieveScheduledFlight(int serialno);
	public List<ScheduledFlights> retrieveAllScheduledFlights();
	public void updateScheduledFlights(ScheduledFlights sflight);
	public boolean deleteScheduledFlights(int serialno);
	
	
}
