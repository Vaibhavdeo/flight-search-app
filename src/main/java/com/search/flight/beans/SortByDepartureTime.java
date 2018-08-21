package com.search.flight.beans;

import java.util.Comparator;

public class SortByDepartureTime implements Comparator<FlightDetails> {

	@Override
	public int compare(FlightDetails obj1, FlightDetails obj2) {

		long departureTime1 = Long.parseLong(obj1.getDepartureTime()
				.substring(10, obj1.getDepartureTime().length())
				.replace(':', ' ').replaceAll("\\s", ""));
		long departureTime2 = Long.parseLong(obj2.getDepartureTime()
				.substring(10, obj2.getDepartureTime().length())
				.replace(':', ' ').replaceAll("\\s", ""));

		return  (int) ((long) departureTime1-departureTime2);

	}

}
