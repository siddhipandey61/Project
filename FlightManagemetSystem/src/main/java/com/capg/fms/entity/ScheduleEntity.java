package com.capg.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Schedule")
public class ScheduleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int scheduleId;
	private String source;
	private String destination;
	private Timestamp arrivalDateTime;
	private Timestamp departureDateTime;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Timestamp getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(Timestamp arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public Timestamp getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(Timestamp departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	

}
