package com.iiit.parksys.vo;

public class AirLock {
	private static final String FULL = "FULL";
	private static final String NOT_FULL = "NOT_FULL";
	private int size;
	private String status;
	private int cnt=0;
	private String name;
	public AirLock(){
		status=NOT_FULL;
	}
	public AirLock(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean enterVehicle(Vehicle v) {
		
		if(!isAirLockFull()){
			cnt++;
			if(cnt==3){
				status=FULL;
			}
			return true;
		}

		return false;

	}

	public boolean exitVehicle(Vehicle v) {
		cnt--;
		status=NOT_FULL;
		return true;

	}

	public boolean isAirLockFull() {
		return FULL.equalsIgnoreCase(status);

	}
	
	public boolean isNoEmpty(){
		return cnt>0;
	}
	
	public int getOccupancy(){
		return cnt;
	}

}
