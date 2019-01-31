package com.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.model.Booking;
import com.practice.repository.BookingDao;
import com.practice.services.intf.IBookingServiceIntf;

@Component("bookingservice")
public class BookingServiceImpl implements IBookingServiceIntf {
	@Autowired
	private BookingDao bookingdao;

	@Override
	public boolean save(Booking booking) {
		bookingdao.save(booking);
		return true;
	}

}
