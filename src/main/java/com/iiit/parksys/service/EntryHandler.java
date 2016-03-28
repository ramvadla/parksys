package com.iiit.parksys.service;

import com.iiit.parksys.dao.VehicleDAO;
import com.iiit.parksys.vo.AirLock;
import com.iiit.parksys.vo.Vehicle;

/**
 * It handles the entry of the vehciles
 * 
 * @author ramakrishna
 * 
 */
public class EntryHandler implements Handler {
	private Handler nextHandler;

	public void handleVehicle(Vehicle vehicle) {

		VehicleDAO.createVehicle(vehicle);
		ParkingAnalyzer pa = ParkingAnalyzer.getInstance();
		AirLock airLock = pa.getEmptyAirLock();
		if(airLock!=null){
			airLock.enterVehicle(vehicle);
		}
		
		int emptySpaces = pa.getEmptySpaces();
		if(emptySpaces>0){
			pa.getGarage().enterVehicle(vehicle);
		}
		
		if (nextHandler != null) {
			nextHandler.handleVehicle(vehicle);
		}
	}

	public void setSuccessor(Handler handler) {
		nextHandler = handler;

	}

}
