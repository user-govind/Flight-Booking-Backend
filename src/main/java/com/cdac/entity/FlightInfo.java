package com.cdac.entity;


import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_flightInfo")
public class FlightInfo {
	
	@Id
	@GeneratedValue
	private int flightNo;
	private String flightName;
	private String fromD;
	private String toD;
	private LocalTime deptTime;
	private LocalTime destTime;
	private int noSeats;
	private double ticketPrice;
	
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="flightInfo")
	@JsonIgnore
	private  List<BookingInfo> bookingInfo;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="flightInfo")
	@JsonIgnore
	private List<PassangerInfo> passangerInfo;
	
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFromD() {
		return fromD;
	}
	public void setFromD(String fromD) {
		this.fromD = fromD;
	}
	public String getToD() {
		return toD;
	}
	public void setToD(String toD) {
		this.toD = toD;
	}
	public LocalTime getDeptTime() {
		return deptTime;
	}
	public void setDeptTime(LocalTime deptTime) {
		this.deptTime = deptTime;
	}
	public LocalTime getDestTime() {
		return destTime;
	}
	public void setDestTime(LocalTime destTime) {
		this.destTime = destTime;
	}
	public int getNoSeats() {
		return noSeats;
	}
	public void setNoSeats(int noSeats) {
		this.noSeats = noSeats;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
}
