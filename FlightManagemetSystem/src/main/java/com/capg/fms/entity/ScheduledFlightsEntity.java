package com.capg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="ScheduledFlights")
public class ScheduledFlightsEntity {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="schedule_id")
	private ScheduleEntity scheduleEntity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="flight_id")
	private FlightEntity flightEntity;

	public ScheduleEntity getScheduleEntity() {
		return scheduleEntity;
	}

	public void setScheduleEntity(ScheduleEntity scheduleEntity) {
		this.scheduleEntity = scheduleEntity;
	}

	public FlightEntity getFlightEntity() {
		return flightEntity;
	}

	public void setFlightEntity(FlightEntity flightEntity) {
		this.flightEntity = flightEntity;
	}
	
	
	
	

}
