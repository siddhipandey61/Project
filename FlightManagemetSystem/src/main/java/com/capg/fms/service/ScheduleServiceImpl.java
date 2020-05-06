package com.capg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.ScheduleDao;
import com.capg.fms.model.Schedule;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao scheduleDao;

	@Override
	public Schedule newSchedule(Schedule schedule) {
		scheduleDao.addSchedule(schedule);
		return schedule;
	}

	@Override
	public Schedule getSchedule(int scheduleid) {
		return scheduleDao.retrieveSchedule(scheduleid);
	}

	@Override
	public List<Schedule> getAllSchedule() {
		return scheduleDao.retrieveAllSchedule();
	}

	@Override
	public Schedule modifySchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);
		return schedule;
	}

	@Override
	public boolean deleteSchedule(int scheduleid) {
		return scheduleDao.deleteSchedule(scheduleid);
	}

	
	
	

}
