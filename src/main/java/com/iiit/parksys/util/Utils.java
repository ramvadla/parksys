package com.iiit.parksys.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.iiit.parksys.service.AuthHandler;
import com.iiit.parksys.service.EntryHandler;
import com.iiit.parksys.service.ExitHandler;
import com.iiit.parksys.service.ParkingHandler;
import com.iiit.parksys.service.PaymentHandler;
import com.iiit.parksys.service.ServiceHandler;
import com.iiit.parksys.vo.Vehicle;

/**
 * It is the utility class.
 * 
 * @author ramakrishna
 * 
 */
public class Utils {
	public static EntryHandler getEntryHandlerChain() {
		EntryHandler eh = new EntryHandler();
		AuthHandler ah = new AuthHandler();
		ParkingHandler ph = new ParkingHandler();
		ServiceHandler sh = new ServiceHandler();
		eh.setSuccessor(ah);
		ah.setSuccessor(ph);
		ph.setSuccessor(sh);

		return eh;
	}

	public static PaymentHandler getPaymentHandlerChain() {
		PaymentHandler ch = new PaymentHandler();
		ExitHandler xh = new ExitHandler();
		ch.setSuccessor(xh);

		return ch;
	}

	public static Double calculateAmountDue(Date v) {
		Double amount = 30.0;

		long diff = new Date().getTime() -v.getTime();
		long hours = TimeUnit.MILLISECONDS.toHours(diff);
		amount = amount + (hours - 1) * 20;
		return amount;

	}

	public static String getDatetimeStr(Date d) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(d);
		return date;
	}

}
