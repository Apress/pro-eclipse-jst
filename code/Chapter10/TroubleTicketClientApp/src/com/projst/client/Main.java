package com.projst.client;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;

import com.projst.ticket.entity.TicketData;
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
			
			try {
				System.out.println("\nList tickets:");
				Collection tickets = service.retrieveAllTickets();
				for (Iterator iter = tickets.iterator(); iter.hasNext();) {
					TicketData ticket = (TicketData) iter.next();
					System.out.println("\t " + ticket.getSummary());
				}
			} catch (FinderException e) {
				e.printStackTrace();
			}
			
			
			TicketData newTicket = new TicketData();
			newTicket.setSummary("new ticket");
			newTicket.setDetail("new ticket detail");
			newTicket.setEmail("cjudd@juddsolutions.com");
			
			TicketData createdTicket = service.createTicket(newTicket);
			
			System.out.println("New Ticket Create with id " + createdTicket.getId() + " and confirmation email sent.");
			
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
