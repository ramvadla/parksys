package com.iiit.parksys.reports;

public class TextBuilder extends ReportBuilder {

	@Override
	public String buildReport() {
		StringBuilder sb = new StringBuilder();
		sb.append("total_payments:").append(rd.getTotalPayments()).append("\n");
		sb.append("amount_due:").append(rd.getDueAmount()).append("\n");
		sb.append("peak_hours:").append(rd.getPeakGarageHours()).append("\n");
		sb.append("permit_count:").append(rd.getPermitsCount()).append("\n");
		return sb.toString();
	}
	

}
