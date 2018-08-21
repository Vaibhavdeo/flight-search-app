package com.search.flight.beans;


public class FlightDetails {

	private String origin;

	private String departureTime;

	private String destination;

	private String destinationTime;

	private String price;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}



	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FlightDetails [origin=" + origin + ", departureTime="
				+ departureTime + ", destination=" + destination
				+ ", destinationTime=" + destinationTime + ", price=" + price
				+ "]";
	}


}
