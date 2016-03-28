package com.iiit.parksys.reports;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.iiit.parksys.dao.VehicleDAO;
import com.iiit.parksys.vo.Vehicle;

public class ReportDirector {
	private int peakHrs;
	private int permitCnt;
	private int dueAmount;
	private int totalPayments;

	public ReportDirector() {
		List<Vehicle> vehicles = VehicleDAO.getVehicles();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (vehicles != null) {
			for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
				Vehicle vehicle = (Vehicle) iterator.next();
				if ("permit".equalsIgnoreCase(vehicle.getAuthType())) {
					permitCnt++;
				}
				if (vehicle.getPaidAmount() != null)
					totalPayments += vehicle.getPaidAmount();
				if (vehicle.getInTime() != null) {
					Integer hr = vehicle.getInTime().getHours();
					Integer cnt = map.get(hr);
					if (cnt == null) {
						cnt = 0;
					}
					map.put(hr, ++cnt);
				}
			}
		}

		// calculate the peak hours
		Iterator<Integer> iterator = map.keySet().iterator();
		int max = 0;
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			Integer val = map.get(key);
			if (val > max) {
				peakHrs = key;
			}
		}

	}

	public int getPeakGarageHours() {
		return peakHrs;
	}

	public int getPermitsCount() {
		return permitCnt;
	}

	public int getDueAmount() {
		return dueAmount;
	}

	public int getTotalPayments() {
		return totalPayments;
	}

	public String construct(ReportBuilder builder) {
		builder.setReportBuilder(this);
		return builder.buildReport();
	}

}
