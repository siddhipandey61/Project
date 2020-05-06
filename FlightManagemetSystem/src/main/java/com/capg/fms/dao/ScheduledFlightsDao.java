package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.model.ScheduledFlights;

public interface ScheduledFlightsDao {
	public boolean addScheduledFlights(ScheduledFlights sflight);
	public List<Schedule> retrieveScheduledFlights(String source, String destination);
	public List<ScheduledFlights> retrieveAllScheduledFlights(int flightId);
	public boolean updateScheduledFlights(ScheduledFlights sflight);
	public boolean deleteScheduledFlights(Schedule scheduleId);
	
	
}
