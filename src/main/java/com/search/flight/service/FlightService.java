package com.search.flight.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.search.flight.beans.FlightDetails;
import com.search.flight.beans.SortByDepartureTime;
import com.search.flight.beans.SortByPrice;
import com.search.flight.util.FlightUtility;

@Component
public class FlightService {

	public List<FlightDetails> searchFlightDetails(String origin,
			String destination) throws IOException {

		List<FlightDetails> listDetailsResponse = new ArrayList<FlightDetails>();

		List<FlightDetails> listDetails = FlightUtility.loadFlightData();

		System.out.println("Sort By Price" + listDetails);

		for (FlightDetails detail : listDetails) {

			if ((detail.getOrigin().equals(origin))
					&& (detail.getDestination().equals(destination))) {

				listDetailsResponse.add(detail);
			}
		}

		if (!listDetailsResponse.isEmpty()) {
			Collections.sort(listDetailsResponse, new SortByPrice());
			Collections.sort(listDetailsResponse, new SortByDepartureTime());
		}
		return listDetailsResponse;

	}

}
