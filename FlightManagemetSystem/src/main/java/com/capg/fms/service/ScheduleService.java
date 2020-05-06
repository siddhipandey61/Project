package com.capg.fms.service;

import java.util.List;

import com.capg.fms.model.Schedule;

public interface ScheduleService {
	public Schedule newSchedule(Schedule schedule);
	public Schedule getSchedule(int scheduleid);
	public List<Schedule> getAllSchedule();
	public Schedule modifySchedule(Schedule schedule);
	public boolean deleteSchedule(int scheduleid);
}
