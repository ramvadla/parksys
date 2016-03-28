package com.iiit.parksys.reports;

public class XMLBuilder extends ReportBuilder {

	@Override
	public String buildReport() {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>").append("\n");
		sb.append("<total_payments>").append(rd.getTotalPayments()).append("</total_payments>").append("\n");
		sb.append("<amount_due>").append(rd.getDueAmount()).append("</amount_due>").append("\n");
		sb.append("<peak_hours>").append(rd.getPeakGarageHours()).append("</peak_hours>").append("\n");
		sb.append("<permit_count>").append(rd.getPermitsCount()).append("</permit_count>").append("\n");
		sb.append("</xml>");
		return sb.toString();
	}
	

}
