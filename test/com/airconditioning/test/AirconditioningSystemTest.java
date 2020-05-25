package com.airconditioning.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.MockitoExtension;
import com.airconditioning.AirconditioningSystem;
import com.airconditioning.Thermometer;

@ExtendWith(MockitoExtension.class)
public class AirconditioningSystemTest {

	@InjectMocks
	AirconditioningSystem airconditioningSystem;
	
	@Mock
	Thermometer thermometer;
	
	@Test
	void testAirconditioningSystemStarted() {
		when(thermometer.getTemperature()).thenReturn(25.0);
		airconditioningSystem.setTemperatureThreshold(24.0);
		airconditioningSystem.checkAirconditioningSystem();
		assertTrue(airconditioningSystem.isOpen());
		verify(thermometer,times(1)).getTemperature();
		
	}
	
	@Test
	void testAirconditioningSystemStopped() {
		when(thermometer.getTemperature()).thenReturn(23.0);
		airconditioningSystem.setTemperatureThreshold(24.0);
		airconditioningSystem.checkAirconditioningSystem();
		assertFalse(airconditioningSystem.isOpen());
		verify(thermometer,times(1)).getTemperature();
		
	}
	
	
}
