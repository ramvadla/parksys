package com.iiit.parksys;

public interface Handler {
	public  void handleVehicle(Vehicle vehicle);
	public void setSuccessor(Handler handler);

}
