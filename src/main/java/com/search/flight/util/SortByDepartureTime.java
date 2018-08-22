package com.search.flight.util;

import java.util.Comparator;

import com.search.flight.beans.FlightDetails;

public class SortByDepartureTime implements Comparator<FlightDetails> {

	@Override
	public int compare(FlightDetails obj1, FlightDetails obj2) {

		String str1 = obj1.getDepartureTime().replaceAll("[\\.$|,|;|'|/|-|:]", "");
		String str2 = obj2.getDepartureTime().replaceAll("[\\.$|,|;|'|/|-|:]", "");
		str1 = str1.replaceAll("-", "");
		str2 = str2.replaceAll("-", "");
		str1 = str1.replaceAll("\\s", "");
		str2 = str2.replaceAll("\\s", "");
		long departureTime1 = Long.parseLong(str1);
		long departureTime2 = Long.parseLong(str2);

		return (int) ((long) departureTime1 - departureTime2);

	}

}
