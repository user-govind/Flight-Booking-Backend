package com.cdac.dao;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.entity.PassangerInfo;

public interface GenericRepositoryPassenger extends JpaRepository<PassangerInfo, Integer> {
	
	
	@Query(value = "select * from tbl_passanger_info inner join tbl_user_info inner join tbl_flight_info where tbl_flight_info.flight_no = tbl_passanger_info.flight_no and tbl_user_info.user_id = tbl_passanger_info.user_id and tbl_user_info.user_id=:id",nativeQuery=true)
    public List<PassangerInfo> fatchBookings(@Param("id") int id);


}
