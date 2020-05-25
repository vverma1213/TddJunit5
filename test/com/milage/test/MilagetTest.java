package com.milage.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import com.airport.Flight;
import com.airport.Passenger;
import com.milage.Milage;

@TestInstance(Lifecycle.PER_CLASS)
public class MilagetTest {

	private Milage milage;
	
	@BeforeAll
	void beforeAll() {
		milage=new Milage();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1; e; harsha; false; 349","2; b; vivek; true; 278","3; e; sunil; false; 319"})
	void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for(Passenger passenger: flight.getPassengerList()) {
			milage.addMilage(passenger, flight.getDistance());
		}
	}
	
	@AfterAll
	void afterAll() {
		milage.calculateGivenPoint();
		assertEquals(17, milage.getPassengerPointMap().get(new Passenger("harsha",false)).intValue());
		assertEquals(27, milage.getPassengerPointMap().get(new Passenger("vivek",false)).intValue());
		System.out.println(milage.getPassengerPointMap());
	}
}
