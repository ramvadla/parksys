package com.iiit.parksys;

public class Utils {
	public static EntryHandler getEntryHandlerChain() {
		EntryHandler eh = new EntryHandler();
		AuthHandler ah = new AuthHandler();
		ParkingHandler ph = new ParkingHandler();
		ServiceHandler sh = new ServiceHandler();
		PaymentHandler ch = new PaymentHandler();
		ExitHandler xh = new ExitHandler();
		eh.setSuccessor(ah);
		ah.setSuccessor(ph);
		ph.setSuccessor(sh);
		sh.setSuccessor(ch);
		ch.setSuccessor(xh);

		return eh;
	}

}
