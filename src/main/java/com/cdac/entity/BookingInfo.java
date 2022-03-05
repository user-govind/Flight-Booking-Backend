package com.cdac.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_bookingInfo")
public class BookingInfo {

	@Id
	@GeneratedValue
	private int bookingId;
	private String ticketNo;
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="flightNo", nullable=false)
	private FlightInfo flightInfo;
	
	@ManyToOne
	@JoinColumn(name="user", nullable=false)
	private UserInfo user;
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	public UserInfo getUserInfo() {
		return user;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.user = userInfo;
	}

}
