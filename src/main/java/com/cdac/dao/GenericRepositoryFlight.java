package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.FlightInfo;

@Repository
public interface GenericRepositoryFlight extends JpaRepository<FlightInfo, Integer> {

	public List<FlightInfo> findByFromDAndToD(String from , String to);
	
	public FlightInfo findByFlightNo(int no);
}
