package com.practice.services;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingsServiceTest {
	@Autowired
	private MockMvc mvc;
	
	

	
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@InjectMocks
	BookingService bookingService;
	
	 @Before
	  public void setup()
	  {
		 bookingService=new BookingService();
		  request=createMock(HttpServletRequest.class);
		 

	  }
	 @Test
		public void createbooking() throws Exception {
			MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
					.post("/create/booking")
					.contentType("application/json")
					.content("{\"id\":1,\"createdtime\":\"12/12/1978\",\"description\":\"first test\"}");

			// create one more user
			this.mvc.perform(builder).andExpect(
					MockMvcResultMatchers.status().isOk());

		}

}
