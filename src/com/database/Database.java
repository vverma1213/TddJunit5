package com.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.airport.Flight;

public class Database {
	private Map<String,String> registeredUser=new HashMap<>();
	List<List<String>> queriedData=new ArrayList<>();

	public boolean login(Credentials credentials) {
		String username=credentials.getUsername();
		String password=credentials.getPassword();
		
		return registeredUser.keySet().contains(username) &&
					registeredUser.get(username).equals(password);
	}
	
	public List<List<String>> queryFlightDatabase(){
		return queriedData;
	}
	
	public double averageDistance(List<Flight> flightList) {
		return flightList.stream()
				.mapToDouble(Flight::getDistance)
				.average()
				.getAsDouble();
	}
	
	public int minimumDistance(List<Flight> flightList) {
		return flightList.stream()
				.mapToInt(Flight::getDistance)
				.min()
				.getAsInt();
	}
	
	public int maximumDistance(List<Flight> flightList) {
		return flightList.stream()
				.mapToInt(Flight::getDistance)
				.max()
				.getAsInt();
	}
}
