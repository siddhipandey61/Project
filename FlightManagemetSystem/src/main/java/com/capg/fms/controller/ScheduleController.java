package com.capg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.model.Schedule;
import com.capg.fms.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping(value="/schedule/{scheduleId}",produces={"application/json"})
	public List<Schedule> displaySchedule(@PathVariable int scheduleId){
		return scheduleService.getAllSchedule(scheduleId);
	}
	
	@PostMapping(value="/schedule/add",produces= {"application/json"})
	public String addSchedule(@RequestBody Schedule schedule) {
		scheduleService.newSchedule(schedule);
		return "Schedule added successfully";
	}
	
	@PutMapping(value="/schedule/update",consumes= {"application/json"})
	public String updateSchedule(@RequestBody Schedule schedule) {
		scheduleService.modifySchedule(schedule);
		return "Schedule modified successfully";
	}
	
	@DeleteMapping(value="/schedule/delete/{scheduleId}")
	public String deleteSchedule(@PathVariable int scheduleId) {
		scheduleService.deleteSchedule(scheduleId);
		return "Schedule with Schedule Id:"+scheduleId+"deleted successfully";
	}
	

}
