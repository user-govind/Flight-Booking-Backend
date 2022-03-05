package com.cdac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.GenericRepo;
import com.cdac.dao.GenericRepositoryBooking;
import com.cdac.dao.GenericRepositoryFlight;
import com.cdac.dao.GenericRepositoryPassenger;
import com.cdac.dao.GenericRepositoryUser;
import com.cdac.entity.BookingInfo;
import com.cdac.entity.FlightInfo;
import com.cdac.entity.PassangerInfo;
import com.cdac.entity.UserInfo;
import com.cdac.exception.FlightServiceException;

@Service
@Transactional
public class FlightServiceImple implements FlightService {
		
	@Autowired
	private GenericRepositoryFlight flightRepo;
	
	@Autowired
	private GenericRepositoryUser userRepo;
	
	@Autowired
	private GenericRepositoryBooking bookingRepo;
	
	@Autowired
	private GenericRepositoryPassenger passRepo;
	
	@Override
	public List<FlightInfo> featchFlight() {
		
		return flightRepo.findAll();
	}
	@Override
	public boolean addFlight(FlightInfo fl) {
		try {
			flightRepo.save(fl);
			return true;
		}
		catch(IllegalArgumentException e){
			throw new FlightServiceException("Flight Not Added! Try Again");
		}
	}
	
	@Override
	public List<FlightInfo> fetchFlightByFromDAndToD(String from, String to) {
		
		return flightRepo.findByFromDAndToD(from,to);
	}
	
	@Override
	public UserInfo featchUserByEmailAndPass(String email,String pass) {
		
		return userRepo.findByEmailAndUserPassword(email, pass);
	}
	
	@Override
	public boolean addUser(UserInfo user) {
		try {
			userRepo.save(user);
			return true;
		}
		catch(Exception e){
			throw new FlightServiceException("User Not Added! Try Again");
		}
	}
	@Override
	public FlightInfo featchFlightById(Integer id) {
		
			FlightInfo fl = flightRepo.findById(id).get();
			return fl;
	}
	
	@Override
	public UserInfo featchUserById(Integer id) {
		
			UserInfo fl = userRepo.findById(id).get();
			return fl;
	}
	
	@Override
	public boolean deleteFlight(Integer id) {
		
		try{
			flightRepo.deleteById(id);
			return true;
			}
		catch(Exception e) {
			throw new FlightServiceException();
		}
		
	
	}
	@Override
	public boolean addBooking(BookingInfo bi) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<BookingInfo> featchBooking() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addPassenger(PassangerInfo pi) {
		
		try {
			PassangerInfo p = passRepo.save(pi);
			System.out.println(p.getPassangerId());
			return true;
		}
		catch(Exception e){
			throw new FlightServiceException("User Not Added! Try Again");
		}
		
	}
	@Override
	public List featchPassByUserId(Integer id) {
		GenericRepo gendao = new GenericRepo();
		 
		return passRepo.fatchBookings(id);
	}
	
	
	
}
