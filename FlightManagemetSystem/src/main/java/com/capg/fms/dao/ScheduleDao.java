package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.model.Schedule;

public interface ScheduleDao {
	public boolean addSchedule(Schedule schedule);
	public Schedule retrieveSchedule(int scheduleid);
	public List<Schedule> retrieveAllSchedule(int scheduleId);
	public boolean updateSchedule(Schedule schedule);
	public boolean deleteSchedule(int scheduleid);
}
