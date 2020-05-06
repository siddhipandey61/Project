package com.capg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.exception.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;
import com.capg.fms.service.ScheduledFlightsService;

@RestController
@RequestMapping("/scheduledFlights")
public class ScheduledFlightsController {
	
	@Autowired
	private ScheduledFlightsService scheduledFlightsService;
	
	@GetMapping(value="/scheduledFlight/{scheduleId}",produces= {"application/json"})
	public List<ScheduledFlights> viewSchdeuledFlights(@PathVariable int scheduleId) throws ScheduleIdNotFoundException{
		return scheduledFlightsService.getScheduledFlight(scheduleId);
	}
	
	@GetMapping(value="/scheduledFlights")
	public List<ScheduledFlights> viewAllScheduledFlights(){
		return scheduledFlightsService.getAllScheduledFlights();
	}
	
	@GetMapping(value="/displaySchedule")
	public List<Schedule> viewFlightSchedule(@RequestParam("src") String source,@RequestParam("dest") String destination) {
		return scheduledFlightsService.getScheduledFlight(source, destination);
	}
	
	@PostMapping(value="/scheduledFlight/add",produces= {"application/json"})
	public String addScheduledFlight(@RequestBody ScheduledFlights sflight) throws ScheduleIdNotFoundException {
		scheduledFlightsService.newScheduledFlights(sflight);
		return "Flight Schedule added successfully";
	}
	
	@PutMapping(value="/schdeuledFlight/modify",consumes= {"application/json"})
	public String modifyScheduledFlight(@RequestBody ScheduledFlights sflight) {
		scheduledFlightsService.modifyScheduledFlights(sflight);
		return "Flight Schdeule modified successfully";
	}
	
	@DeleteMapping(value="/scheduledFlight/delete/{scheduleId}")
	public String deleteScheduledFlight(@PathVariable int scheduleId) {
		scheduledFlightsService.deleteScheduledFlights(scheduleId);
		return "Flight Schedule with schedule Id:"+scheduleId+"deleted successfully";
	}
	
	

}
