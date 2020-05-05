package com.capg.fms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Schedule {
	@Id
	@Size(min=4,max=8)
	private int schedule_id;
	private String source;
	private String destination;
	private LocalDateTime arrivaltime;
	private LocalDateTime departuretime;
	public Schedule() {
		super();
	}
	public Schedule(int schedule_id, String source, String destination, LocalDateTime arrivaltime,
			LocalDateTime departuretime) {
		super();
		this.schedule_id = schedule_id;
		this.source = source;
		this.destination = destination;
		this.arrivaltime = arrivaltime;
		this.departuretime = departuretime;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
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
	public LocalDateTime getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(LocalDateTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public LocalDateTime getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(LocalDateTime departuretime) {
		this.departuretime = departuretime;
	}
	@Override
	public String toString() {
		return "Schedule [schedule_id=" + schedule_id + ", source=" + source + ", destination=" + destination
				+ ", arrivaltime=" + arrivaltime + ", departuretime=" + departuretime + "]";
	}

}
