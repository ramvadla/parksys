package com.iiit.parksys.vo;

import java.util.Iterator;
import java.util.List;

public class Garage {
	private static final String FULL = "FULL";
	private static final String NOT_FULL = "NOT_FULL";
	private int maxSize = 100;
	private List<AirLock> airlocks;
	private int cnt = 0;
	private String status;

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public List<AirLock> getAirlocks() {
		return airlocks;
	}

	public void setAirlocks(List<AirLock> airlocks) {
		this.airlocks = airlocks;
	}

	public boolean enterVehicle(Vehicle v) {

		cnt++;
		if (cnt == maxSize) {
			status = FULL;
			return false;
		}
		return true;
	}

	public boolean exitVehicle(Vehicle v) {
		cnt--;
		status = NOT_FULL;
		return true;

	}

	public boolean isAirLockFull() {
		return FULL.equalsIgnoreCase(status);

	}

	public int getFreeSlots() {
		return maxSize - cnt;
	}

	public int getOccupancy() {
		return cnt;
	}

	public int getAirLockOccupancy() {
		int cnt = 0;
		for (Iterator iterator = airlocks.iterator(); iterator.hasNext();) {
			AirLock airLock = (AirLock) iterator.next();
			cnt = cnt + airLock.getOccupancy();
		}
		return cnt;
	}
}
