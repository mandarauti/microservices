package com.practice.domain;

public class BookingDO {
	
	long bookingId;
	String createdtime;
	String description;
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", CreatedTime="
				+ createdtime + ", description=" + description + "]";
	}
	

}
