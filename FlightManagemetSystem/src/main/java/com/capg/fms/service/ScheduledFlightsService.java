package com.capg.fms.service;

import java.util.List;

import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;

public interface ScheduledFlightsService {
	public boolean newScheduledFlights(ScheduledFlights sflight);
	public List<Schedule> getScheduledFlight(String source, String destination);
	public List<ScheduledFlights> getAllScheduledFlights(int scheduleId);
	public boolean modifyScheduledFlights(ScheduledFlights sflight);
	public boolean deleteScheduledFlights(Schedule scheduleId);
}
