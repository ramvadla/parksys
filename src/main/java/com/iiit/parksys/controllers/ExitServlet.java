package com.iiit.parksys.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiit.parksys.service.EntryHandler;
import com.iiit.parksys.service.PaymentHandler;
import com.iiit.parksys.util.Utils;
import com.iiit.parksys.vo.Vehicle;

/**
 * It is the controller servlet for entry of he vehicles
 * 
 * @author ramakrishna
 * 
 */
public class ExitServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//paid_amount
		//payment_type
		//vehicle_id
		String vnumber = request.getParameter("vehicle_id");
		String payment_type = request.getParameter("payment_type");
		String paid_amount = request.getParameter("paid_amount");
		System.out.println("vnumber: " + vnumber + " payment_type:" + payment_type + " paid_amount:" + paid_amount);
		Vehicle vehicle = new Vehicle();
		vehicle.setId(Integer.valueOf(vnumber));
		vehicle.setPaymentType(payment_type);
		vehicle.setPaidAmount(Double.valueOf(paid_amount));
		PaymentHandler handler = Utils.getPaymentHandlerChain();
		handler.handleVehicle(vehicle);

	}
}
