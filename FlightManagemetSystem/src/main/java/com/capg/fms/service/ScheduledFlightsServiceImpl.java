package com.capg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.ScheduledFlightsDao;
import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;

@Service
@Transactional
public class ScheduledFlightsServiceImpl implements ScheduledFlightsService{
	
	@Autowired
	private ScheduledFlightsDao scheduledFlightsDao;

	@Override
	public boolean newScheduledFlights(ScheduledFlights sflight) {
		return scheduledFlightsDao.addScheduledFlights(sflight);
	}

	@Override
	public List<Schedule> getScheduledFlight(String source, String destination) {
		return scheduledFlightsDao.retrieveScheduledFlights(source, destination);
	}

	@Override
	public List<ScheduledFlights> getAllScheduledFlights(int scheduleId) {
		return scheduledFlightsDao.retrieveAllScheduledFlights(scheduleId);
	}

	@Override
	public boolean modifyScheduledFlights(ScheduledFlights sflight) {
		return scheduledFlightsDao.updateScheduledFlights(sflight);
	}

	@Override
	public boolean deleteScheduledFlights(Schedule scheduleId) {
		return scheduledFlightsDao.deleteScheduledFlights(scheduleId);
	}

}
