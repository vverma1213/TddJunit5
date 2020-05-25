package com.airport;

public class EconomicFlight extends Flight {
	
	public EconomicFlight(String id) {
		super(id);
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		return passengerList.add(passenger);
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		if(!passenger.isVip()) {
			return passengerList.remove(passenger);
		}
		return false;
	}

}
