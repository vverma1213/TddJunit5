package com.airconditioning.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.MockitoExtension;
import com.airconditioning.Sensor;
import com.airconditioning.Thermometer;

@ExtendWith(MockitoExtension.class)
public class ThermometerTest {

	@InjectMocks
	Thermometer thermometer;
	
	@Mock
	Sensor sensor;
	
	@Test
	void testWorkingSensor()
	{
		thermometer.setTemperature(25.0);
		when(sensor.isBlocked()).thenReturn(false);
		assertEquals(sensor, thermometer.getSensor());
		assertEquals(25.0,thermometer.getTemperature(),0.001);
		verify(sensor, times(1)).isBlocked();
	}
	
	@Test
	void testBlockingSensor()
	{
		thermometer.setTemperature(25.0);
		when(sensor.isBlocked()).thenReturn(true);
		assertEquals(sensor, thermometer.getSensor());
		assertThrows(RuntimeException.class, () -> thermometer.getTemperature());
		verify(sensor, times(1)).isBlocked();
	}
	
	
}
