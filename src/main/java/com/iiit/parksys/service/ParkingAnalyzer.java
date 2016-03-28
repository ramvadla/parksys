package com.iiit.parksys.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iiit.parksys.vo.AirLock;
import com.iiit.parksys.vo.Garage;

public class ParkingAnalyzer {
	private static ParkingAnalyzer pa = new ParkingAnalyzer();
	private static Garage grg = new Garage();
	private static List<AirLock> al = new ArrayList<AirLock>();
	static {
		al.add(new AirLock("1"));
		al.add(new AirLock("2"));
		al.add(new AirLock("3"));
		grg.setAirlocks(al);
	}

	public static ParkingAnalyzer getInstance() {
		return pa;
	}

	public int getEmptySpaces() {
		return grg.getFreeSlots();
	}

	public Garage getGarage() {
		return grg;
	}

	public AirLock getEmptyAirLock() {
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			AirLock airLock = (AirLock) iterator.next();
			if (!airLock.isAirLockFull()) {
				return airLock;
			}

		}
		return null;
	}

	public AirLock getNonEmptyAirLock() {
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			AirLock airLock = (AirLock) iterator.next();
			if (airLock.isNoEmpty()) {
				return airLock;
			}

		}
		return null;
	}

}
