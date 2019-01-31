package com.practice.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.domain.BookingDO;
import com.practice.model.Booking;
import com.practice.services.intf.IBookingServiceIntf;
import com.practice.utils.ResponseMessage;

@RestController
public class BookingService {
	@Resource(name="bookingservice")
	IBookingServiceIntf bookingServiceIntf;
	
	@RequestMapping(value = "/create/booking", method = RequestMethod.POST, consumes = "application/json")
public ResponseMessage createBooking(@RequestBody BookingDO booking,
		HttpServletRequest request, HttpServletResponse response,BindingResult results)
{
		ResponseMessage responseMessage = new ResponseMessage();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//Main Logic
		try
		{
			
		
		System.out.println("Booking description"+booking.getDescription() +booking.getCreatedtime());
		Booking bookingentity=new Booking();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
		Date date = dateFormat.parse(booking.getCreatedtime());
		long time = date.getTime();
		bookingentity.setCreatedtime(new Timestamp(time));
		bookingentity.setDescription(booking.getDescription());
		bookingServiceIntf.save(bookingentity);
		responseMessage.setStatusCode(HttpStatus.OK.getReasonPhrase());
		} catch (Exception exception) {
			responseMessage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR
					.getReasonPhrase());
				exception.printStackTrace();
				
			
		}
		stopWatch.stop();
		response.setHeader("RestUrl",request.getRequestURL().toString() );
		response.setHeader("executionTime", stopWatch.getTotalTimeMillis() + " ms");
		return responseMessage;
}
}
