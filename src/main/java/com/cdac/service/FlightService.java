package com.cdac.service;

import java.util.List;

import com.cdac.entity.BookingInfo;
import com.cdac.entity.FlightInfo;
import com.cdac.entity.PassangerInfo;
import com.cdac.entity.UserInfo;

public interface FlightService {

	public List<FlightInfo> featchFlight();
	public boolean addFlight(FlightInfo fl);
	public UserInfo featchUserByEmailAndPass(String email,String pass);
	public boolean addUser(UserInfo user);
	
	public List<FlightInfo> fetchFlightByFromDAndToD(String from , String to );
	
	public FlightInfo featchFlightById(Integer id);
	
	public boolean deleteFlight(Integer id);
	
	public boolean addBooking(BookingInfo bi);
	
	public List<BookingInfo> featchBooking();
	
	public boolean addPassenger(PassangerInfo pi);
	
	public UserInfo featchUserById(Integer id);
	
	
	public List<PassangerInfo> featchPassByUserId(Integer id);
}
