package com.cdac.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.LoginStatus;
import com.cdac.dto.ProfilePicDetails;
import com.cdac.dto.flight;
import com.cdac.entity.FlightInfo;
import com.cdac.entity.PassangerInfo;
import com.cdac.entity.UserInfo;
import com.cdac.exception.FlightServiceException;
import com.cdac.service.EmailService;
import com.cdac.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private EmailService emailService;
	//I have changed this file


	@PostMapping("/add-flight")
	public boolean addFlight(@RequestBody FlightInfo fl) {

		try {
			return flightService.addFlight(fl);
		} catch (FlightServiceException e) {
			return false;
		}
	}
	

	@PostMapping("/get-all-flights")
	public List<FlightInfo> featch() {
		return flightService.featchFlight();
	}
	

	@PostMapping("/get-flights-results")
	public List<FlightInfo> featchFromTo(@RequestBody FlightInfo flight) {
		return flightService.fetchFlightByFromDAndToD(flight.getFromD(), flight.getToD());
	}
	
	@PostMapping("/get-flight")
	public FlightInfo featchById(@RequestBody flight fl) {
		return flightService.featchFlightById(fl.getFlightNo());
	}
	
	

	@PostMapping("/get-logindetails")
	public LoginStatus chechUser(@RequestBody UserInfo user) {
		UserInfo newUser = flightService.featchUserByEmailAndPass(user.getEmail(), user.getUserPassword());
		LoginStatus ls = new LoginStatus();

		if (newUser != null) {
			ls.setStatus(true);
			ls.setName(newUser.getUserFirstName());
			ls.setUserId(newUser.getUserId());
			ls.setRollId(newUser.getRollId());
			return ls;
		} else {
			ls.setStatus(false);
			return ls;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteFlight(@PathVariable Integer id ) {
		try {	
						
			return flightService.deleteFlight(id);
		}
		catch(FlightServiceException e){
			return false;
		}
	}

	@PostMapping("/add-user")
	public boolean addUser(@RequestBody UserInfo user) {
		try {
			user.setRollId(1);
			emailService.sendEmailForNewRegistration(user.getEmail());
			return flightService.addUser(user);
		} catch (FlightServiceException e) {
			return false;
		}
	}
	
	@PostMapping("/add-passenger")
	public boolean addPassenger(@RequestBody PassangerInfo pass) {

		try {
			System.out.println("working");
			System.out.println(pass.getFlightInfo().getFlightNo());
			pass.setFlightInfo(flightService.featchFlightById(pass.getFlightInfo().getFlightNo()));
			pass.setUserInfo(flightService.featchUserById(pass.getUserInfo().getUserId()));
			System.out.println("working");
			return flightService.addPassenger(pass);
		} catch (FlightServiceException e) {
			return false;
		}
	}
	
	@PostMapping("/getpassengers")
	public List getPassengers(@RequestBody UserInfo id ) {
		System.out.println(id.getUserId());
		return flightService.featchPassByUserId(id.getUserId());
		
	}
	
	
	
	@PostMapping("/upload-profile-pic")
	public boolean uploadPic(ProfilePicDetails profilePicDetails) {
	
		//store the image in some folder
		String uploadedPicName = profilePicDetails.getProfilePic().getOriginalFilename();
		String fileName = profilePicDetails.getCustomerId() + "-" + uploadedPicName;
		
		try {
			FileCopyUtils.copy(profilePicDetails.getProfilePic().getInputStream(), new FileOutputStream("C:/Users/kulka/Documents/Desktop/flight-seat-booking-app/src/images/" + fileName));
		} catch (IOException e) {
			//hoping there won't be any error
		}
		
		//update the information in the db
		UserInfo customer = flightService.featchUserById(profilePicDetails.getCustomerId());
		customer.setProfilePic(fileName);
		
	
		return flightService.addUser(customer);
	}
}
