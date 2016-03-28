package com.iiit.parksys.service;

import com.iiit.parksys.vo.Vehicle;

/**
 * It is the handler interace for different chain of responsibility handlers
 * 
 * @author ramakrishna
 * 
 */
public interface Handler {
	public void handleVehicle(Vehicle vehicle);

	public void setSuccessor(Handler handler);

}
