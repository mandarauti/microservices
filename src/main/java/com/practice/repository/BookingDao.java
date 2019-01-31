package com.practice.repository;

import org.springframework.transaction.annotation.Transactional;

import com.practice.model.Booking;
@Transactional
public interface BookingDao extends BaseRepository<Booking, Integer> {

}
