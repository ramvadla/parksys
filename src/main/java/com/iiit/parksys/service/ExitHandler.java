package com.iiit.parksys.service;

import com.iiit.parksys.vo.AirLock;
import com.iiit.parksys.vo.Vehicle;

/**
 * It handles the exit of the vehicles
 * 
 * @author ramakrishna
 * 
 */
public class ExitHandler implements Handler {
	private Handler nextHandler;

	public void handleVehicle(Vehicle vehicle) {

		ParkingAnalyzer pa = ParkingAnalyzer.getInstance();
		AirLock airLock = pa.getNonEmptyAirLock();
		if(airLock!=null){
			airLock.exitVehicle(vehicle);
		}
		
		pa.getGarage().exitVehicle(vehicle);

		if (nextHandler != null) {
			nextHandler.handleVehicle(vehicle);
		}
	}

	public void setSuccessor(Handler handler) {
		nextHandler = handler;

	}
}
