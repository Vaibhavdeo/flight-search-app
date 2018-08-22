package com.search.flight.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;
import com.search.flight.beans.FlightDetails;
import com.search.flight.constants.FlightConstants;
import com.search.flight.util.FlightUtility;
import com.search.flight.util.SortByDepartureTime;
import com.search.flight.util.SortByPrice;

@Component
public class FlightService {

	private List<FlightDetails> listDetails = new ArrayList<>();

	public String searchFlightDetails(String origin, String destination) throws IOException {

		String response = null;
		List<FlightDetails> listDetailsResponse = new ArrayList<FlightDetails>();
		listDetails = getFlightList();
		for (FlightDetails detail : listDetails) {

			if ((detail.getOrigin().equals(origin)) && (detail.getDestination().equals(destination))) {

				listDetailsResponse.add(detail);
			}
		}
		if (!listDetailsResponse.isEmpty()) {
			Collections.sort(listDetailsResponse, new SortByPrice());
			Collections.sort(listDetailsResponse, new SortByDepartureTime());
			response = setResponse(listDetailsResponse);
		} else {
			response = "No Flights Found for " + origin + " --> " + destination;
		}
		return response;

	}

	private List<FlightDetails> getFlightList() throws IOException {

		List<FlightDetails> tempDetails = new ArrayList<FlightDetails>();
		tempDetails = FlightUtility.loadFlightDataProvider(FlightConstants.PROVIDER1, FlightConstants.COMMA_DELIMETER);
		listDetails.addAll(tempDetails);
		tempDetails.clear();
		tempDetails = FlightUtility.loadFlightDataProvider(FlightConstants.PROVIDER2, FlightConstants.COMMA_DELIMETER);
		listDetails.addAll(tempDetails);
		tempDetails.clear();
		tempDetails = FlightUtility.loadFlightDataProvider(FlightConstants.PROVIDER3, FlightConstants.PIPE_DELIMETER);
		listDetails.addAll(tempDetails);
		tempDetails.clear();

		return listDetails;

	}

	private String setResponse(List<FlightDetails> list) {

		String str = "";
		
		for (FlightDetails details : list) {

			str = str + details.getOrigin() + " --> " + details.getDestination() + " (" + details.getDepartureTime()
					+ " --> " + details.getDestinationTime() + ")  -" + details.getPrice() + "\n";
		}

		return str;

	}
}
