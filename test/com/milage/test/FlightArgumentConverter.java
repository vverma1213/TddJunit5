package com.milage.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import com.airport.BusinessFlight;
import com.airport.EconomicFlight;
import com.airport.Flight;
import com.airport.Passenger;
import com.airport.PremiumFlight;

public class FlightArgumentConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
		assertEquals(String.class,source.getClass(),"can convert only from String");
		assertEquals(Flight.class, targetType,"can convert only from Flight");
		
		String [] flightString=source.toString().split(";");
		Flight flight=null;
		
		switch(flightString[1].toLowerCase().trim()) {
		case "b":
			flight=new BusinessFlight(flightString[0]);
			break;
		case "p":
			flight=new PremiumFlight(flightString[0]);
			break;
		case "e":
			flight=new EconomicFlight(flightString[0]);
			break;
		}
		
		flight.addPassenger(new Passenger(flightString[2].trim(), Boolean.valueOf(flightString[3].trim())));
		flight.setDistance(Integer.valueOf(flightString[4].trim()));
		
		return flight;
	}

}
