package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.BookingInfo;

public interface GenericRepositoryBooking extends JpaRepository<BookingInfo, Integer> {

}
