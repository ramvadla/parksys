package com.iiit.parksys.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiit.parksys.reports.ReportDirector;
import com.iiit.parksys.reports.TextBuilder;
import com.iiit.parksys.reports.XMLBuilder;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String btnName = request.getParameter("xmlbtn");
		System.out.println("type: "+btnName);
		String filename = "report.txt";
		String reportstr="";
		ReportDirector director = new ReportDirector();
		if("XML".equalsIgnoreCase(btnName)){
			filename = "report.xml";
			reportstr=director.construct(new XMLBuilder());
		}else{
			reportstr=director.construct(new TextBuilder());
		}
		
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "\"");

		out.write(reportstr);
		out.close();
	}

}
