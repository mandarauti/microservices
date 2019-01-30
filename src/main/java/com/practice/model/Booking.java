package com.practice.model;

public class Booking {
	
	long bookingId;
	long CreatedTime;
	String description;
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public long getCreatedTime() {
		return CreatedTime;
	}
	public void setCreatedTime(long createdTime) {
		CreatedTime = createdTime;
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
				+ CreatedTime + ", description=" + description + "]";
	}
	

}
