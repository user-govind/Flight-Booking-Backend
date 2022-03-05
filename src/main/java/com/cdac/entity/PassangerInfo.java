package com.cdac.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_passangerInfo")
public class PassangerInfo {

	@Id
	@GeneratedValue
	private int passangerId;
	private String passangerName;
	private short passangerAge;
	private String passangerGender;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private UserInfo userInfo;
	
	@ManyToOne
	@JoinColumn(name="FlightNo", nullable=false)
	private FlightInfo flightInfo;

	public int getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(int passangerId) {
		this.passangerId = passangerId;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public short getPassangerAge() {
		return passangerAge;
	}

	public void setPassangerAge(short passangerAge) {
		this.passangerAge = passangerAge;
	}

	public String getPassangerGender() {
		return passangerGender;
	}

	public void setPassangerGender(String passangerGender) {
		this.passangerGender = passangerGender;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}
	 
}
