package com.search.flight.endpoint;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.search.flight.service.FlightService;

public class FlightControllerTest {

	private FlightController controller;
	
	@Before
	public void setUp(){
		controller = new FlightController();
		FlightService flightService = new FlightService();
		controller.setService(flightService);
	}
	
	@Test
	public void testGetFlightDetailsPositive() throws IOException {
		
		String expected = controller.getFlightDetails("YYC", "YYZ");
		Assert.assertNotEquals(expected, "No Flights Found for YYC --> YY");
	}
	
	@Test
	public void testGetFlightDetailsNegative() throws IOException {
		
		String actual = controller.getFlightDetails("YYC", "dummy");
		String expected = "No Flights Found for YYC --> dummy";
		Assert.assertEquals(expected, actual);
	}

}
