package com.search.flight.endpoint;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.search.flight.beans.FlightDetails;
import com.search.flight.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService service;

	@RequestMapping(value = "/searchFlights/{Origin}/{Destination}", method = RequestMethod.GET)
	public List<FlightDetails> getFlightDetails(@PathVariable("Origin") String origin,
			@PathVariable("Destination") String destination) throws IOException{
		    return service.searchFlightDetails(origin, destination);

	}

}
