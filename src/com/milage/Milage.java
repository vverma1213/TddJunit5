package com.milage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.airport.Passenger;

public class Milage {
	
	public static final int VIP_FACTOR=10;
	public static final int USUAL_FACTOR=20;
	
	private HashMap<Passenger,Integer> passengerMilageMap=new HashMap<>();
	private HashMap<Passenger,Integer> passengerPointMap=new HashMap<>();

	public Map<Passenger,Integer> getPassengerPointMap(){
		return Collections.unmodifiableMap(passengerPointMap);
	}
	
	public void addMilage(Passenger passenger,int miles) {
		
		if(passengerMilageMap.containsKey(passenger)) {
			passengerMilageMap.put(passenger, passengerMilageMap.get(passenger)+miles);
		}
		else {
			passengerMilageMap.put(passenger, miles);
		}
		
	}
	
	public void calculateGivenPoint() {
		
		for(Passenger passenger : passengerMilageMap.keySet()) {
			if(passenger.isVip()) {
				passengerPointMap.put(passenger, passengerMilageMap.get(passenger)/VIP_FACTOR);
			}
			else {
				passengerPointMap.put(passenger, passengerMilageMap.get(passenger)/USUAL_FACTOR);
			}
		}
	}
}
