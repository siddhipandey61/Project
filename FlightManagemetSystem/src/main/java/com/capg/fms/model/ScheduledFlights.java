package com.capg.fms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScheduledFlights {
	private int serialno;
	@Id
	private int scheduleid;
	private int flightid;
	public ScheduledFlights() {
		super();
	}
	public ScheduledFlights(int serialno, int scheduleid, int flightid) {
		super();
		this.serialno = serialno;
		this.scheduleid = scheduleid;
		this.flightid = flightid;
	}
	public int getSerialno() {
		return serialno;
	}
	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}
	public int getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	@Override
	public String toString() {
		return "ScheduledFlights [serialno=" + serialno + ", scheduleid=" + scheduleid + ", flightid=" + flightid + "]";
	}
}
