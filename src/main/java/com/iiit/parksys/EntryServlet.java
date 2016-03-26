package com.iiit.parksys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryServlet extends HttpServlet{

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String vnumber = request.getParameter("vnumber");
		String vdate = request.getParameter("vdate");
		String authType = request.getParameter("authType");
		String airLockNum = request.getParameter("airLockNum");
		System.out.println("vnumber: "+vnumber+" vdate:"+vdate+" authType:"+authType+" airLockNum:"+airLockNum);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNumber(vnumber);
		vehicle.setAuthType(authType);
		//TODO;Get it form UI..
		vehicle.setType("General");
		EntryHandler handler =Utils.getEntryHandlerChain();
		handler.handleVehicle(vehicle);

	}
}
