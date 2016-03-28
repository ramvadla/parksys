package com.iiit.parksys.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiit.parksys.service.EntryHandler;
import com.iiit.parksys.util.Utils;
import com.iiit.parksys.vo.Vehicle;

/**
 * It is the controller servlet for entry of he vehicles
 * 
 * @author ramakrishna
 * 
 */
public class EntryServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String vnumber = request.getParameter("vehicle_id");
		//String vdate = new Date().;
		String authType = request.getParameter("authentication_mode");
		//todo:calculate airlock based on the status
		//String airLockNum = request.getParameter("airLockNum");
		String airLockNum = "1";
		System.out.println("vnumber: " + vnumber + " authType:" + authType + " airLockNum:" + airLockNum);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNumber(vnumber);
		vehicle.setAuthType(authType);
		// TODO;Get it form UI..
		vehicle.setType("General");
		EntryHandler handler = Utils.getEntryHandlerChain();
		handler.handleVehicle(vehicle);

	}
}
