package com.projst.client;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import com.projst.ticket.service.TicketService;
import com.projst.ticket.service.TicketServiceHome;
import com.projst.ticket.service.TicketServiceUtil;

/**
 * Remote TicketService (Session Bean) client.
 */
public class Main {

	/**
	 * Application main entry point
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		try {
			
			TicketServiceHome home = TicketServiceUtil.getHome();
			TicketService service = home.create();
			String result = service.ping("ping");
			System.out.println(result);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nDone");
	}

}
