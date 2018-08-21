package com.search.flight.beans;

import java.util.Comparator;

public class SortByPrice implements Comparator<FlightDetails>{

	@Override
	public int compare(FlightDetails obj1, FlightDetails obj2) {
		double price1 = Double.parseDouble(obj1.getPrice().replace('$', ' ' ).trim());
		double price2 = Double.parseDouble(obj2.getPrice().replace('$', ' ' ).trim());
		return (int) ((double) price1-price2);


	}



}
