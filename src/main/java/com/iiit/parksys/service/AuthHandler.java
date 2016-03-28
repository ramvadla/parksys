package com.iiit.parksys.service;

import com.iiit.parksys.vo.Vehicle;

/**
 * It handles the authentication of the vehicles
 * 
 * @author ramakrishna
 * 
 */
public class AuthHandler implements Handler {
	private Handler nextHandler;

	public void handleVehicle(Vehicle vehicle) {

		if (nextHandler != null) {
			nextHandler.handleVehicle(vehicle);
		}
	}

	public void setSuccessor(Handler handler) {
		nextHandler = handler;

	}
}
