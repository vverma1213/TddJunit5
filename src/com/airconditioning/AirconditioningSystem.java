package com.airconditioning;

public class AirconditioningSystem {
	
	private Thermometer thermometer;
	private double temperatureThreshold;
	private boolean open;
	
	public AirconditioningSystem() {
		this.open=false;
	}

	public void checkAirconditioningSystem() {
		this.open=(thermometer.getTemperature()) >=temperatureThreshold;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setThermometer(Thermometer thermometer) {
		this.thermometer = thermometer;
	}

	public void setTemperatureThreshold(double temperatureThreshold) {
		this.temperatureThreshold = temperatureThreshold;
	}
	
	

}
