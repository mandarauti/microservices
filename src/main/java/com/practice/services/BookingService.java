package com.practice.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Booking;
import com.practice.utils.ResponseMessage;

@SpringBootApplication
@RestController
public class BookingService {
	
	@RequestMapping(value = "/create/booking", method = RequestMethod.POST, consumes = "application/json")
public ResponseMessage createBooking(@RequestBody Booking booking,
		HttpServletRequest request, HttpServletResponse response,BindingResult results)
{
		ResponseMessage responseMessage = new ResponseMessage();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//Main Logic
		System.out.println("Booking description"+booking.getDescription());
		stopWatch.stop();
		response.setHeader("RestUrl",request.getRequestURL().toString() );
		response.setHeader("executionTime", stopWatch.getTotalTimeMillis() + " ms");
		return responseMessage;
}
}
