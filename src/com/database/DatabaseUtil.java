package com.database;

import java.util.ArrayList;
import java.util.List;

import com.airport.BusinessFlight;
import com.airport.EconomicFlight;
import com.airport.Flight;
import com.airport.Passenger;
import com.airport.PremiumFlight;

public class DatabaseUtil {

	private DatabaseUtil() {
		
	}
	
	public static List<Flight> buildFlightList(List<List<String>> queriedData) {
		List<Flight> flightList=new ArrayList<>();
		for(List<String> row :queriedData) {
			Flight flight;
			if(row.get(1).equals("e")) {
				flight=new EconomicFlight(row.get(0));
			}else if(row.get(1).equals("b")) {
				flight=new BusinessFlight(row.get(0));
			}
			else {
				flight=new PremiumFlight(row.get(0));
			}
			
			flight.addPassenger(new Passenger(row.get(2),Boolean.valueOf(row.get(3))));
			flight.setDistance(Integer.valueOf(row.get(4)));
			flightList.add(flight);
		}
		return flightList;
	}
}
