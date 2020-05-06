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
	public boolean newScheduledFlights(ScheduledFlights sflight) throws ScheduleIdNotFoundException {
		List<ScheduledFlights> list = getAllScheduledFlights();
		Optional<ScheduledFlights> optional = list.stream().filter(f1->f1.getScheduleId()==sflight.getScheduleId()).findFirst();
		if(optional.isPresent()) {
			return scheduledFlightsDao.addScheduledFlights(sflight);
		}
		else
			throw new ScheduleIdNotFoundException("This id is already taken");
	}

	@Override
	public List<Schedule> getScheduledFlight(String source, String destination) {
		return scheduledFlightsDao.retrieveScheduledFlights(source, destination);
	}
	
	@Override
	public List<ScheduledFlights> getAllScheduledFlights() {
		return scheduledFlightsDao.retrieveAllShceduledFlights();
	}
	
	@Override
	public List<ScheduledFlights> getScheduledFlight(int scheduleId) throws ScheduleIdNotFoundException {
		List<ScheduledFlights> list = getAllScheduledFlights();
		Optional<ScheduledFlights> optional = list.stream().filter(f1->f1.getScheduleId().getScheduleId()==scheduleId).findFirst();
		if(optional.isPresent()) {
			return scheduledFlightsDao.retrieveAllScheduledFlights(scheduleId);
		}
		else
			throw new ScheduleIdNotFoundException("Id doesn't exist");
	}
	@Override
	public boolean modifyScheduledFlights(ScheduledFlights sflight) {
		return scheduledFlightsDao.updateScheduledFlights(sflight);
	}

	@Override
	public boolean deleteScheduledFlights(int scheduleId) {
		return scheduledFlightsDao.deleteScheduledFlights(scheduleId);
	}
}
