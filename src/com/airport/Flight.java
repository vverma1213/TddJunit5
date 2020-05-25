package com.airport;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Flight {

	private String id;
	private int distance;
	
	protected Set<Passenger> passengerList=new HashSet<Passenger>();
	
	public Flight(String id) {
		this.id=id;
	}
	
	public Set<Passenger> getPassengerList(){
		return Collections.unmodifiableSet(passengerList);
	}
	
	
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public abstract boolean addPassenger(Passenger passenger);
	public abstract boolean removePassenger(Passenger passenger);
}
