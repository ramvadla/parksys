package com.iiit.parksys.service;

import com.iiit.parksys.dao.VehicleDAO;
import com.iiit.parksys.vo.Vehicle;

/**
 * It handles the payment of the parking
 * @author ramakrishna
 *
 */
public class PaymentHandler implements Handler {
	private Handler nextHandler;

	public void handleVehicle(Vehicle vehicle) {
		VehicleDAO.updateVehicle(vehicle);

		if (nextHandler != null) {
			nextHandler.handleVehicle(vehicle);
		}
	}

	public void setSuccessor(Handler handler) {
		nextHandler = handler;

	}

}
