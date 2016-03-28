package com.iiit.parksys.reports;

public abstract class ReportBuilder {
	protected ReportDirector rd;
	public void setReportBuilder(ReportDirector rd){
		this.rd = rd;
	}
	public abstract String buildReport();

}
