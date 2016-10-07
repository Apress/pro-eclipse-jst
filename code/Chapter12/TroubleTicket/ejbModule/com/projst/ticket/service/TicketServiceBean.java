/**
 * 
 */
package com.projst.ticket.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.NamingException;

import com.projst.ticket.entity.TicketData;
import com.projst.ticket.entity.TicketLocal;
import com.projst.ticket.entity.TicketUtil;


/**
 *
 * <!-- begin-user-doc -->
 * A generated session bean
 * <!-- end-user-doc -->
 * *
 * <!-- begin-xdoclet-definition --> 
 * @ejb.bean name="TicketService"	
 *           description="A session bean named TicketService"
 *           display-name="TicketService"
 *           jndi-name="TicketService"
 *           type="Stateless" 
 *           transaction-type="Container"
 * 
 * <!-- end-xdoclet-definition --> 
 * @generated
 */

public abstract class TicketServiceBean implements javax.ejb.SessionBean {

	/** 
	 *
	 * <!-- begin-xdoclet-definition --> 
	 * @ejb.create-method view-type="remote"
	 * <!-- end-xdoclet-definition --> 
	 * @generated
	 *
	 * //TODO: Must provide implementation for bean create stub
	 */
	public void ejbCreate() {
	}

	/** 
	 * Method used to ensure session bean is available
	 * by providing an echo message
	 * <!-- begin-xdoclet-definition --> 
	 * @ejb.interface-method view-type="both"
	 * <!-- end-xdoclet-definition --> 
	 * @generated
	 */
	public String ping(String param) {
		return "pong: " + param + " at " + new Date();
	}
	
	/**
	 * Return all tickets.
	 * @ejb.interface-method view-type="both"
	 */
	public Collection retrieveAllTickets() throws FinderException, NamingException {
		Collection ticketDTOs = new ArrayList();
		Collection tickets = TicketUtil.getLocalHome().findAll();
		for(Iterator iter = tickets.iterator(); iter.hasNext();) {
			TicketLocal ticket = (TicketLocal) iter.next();
			ticketDTOs.add(ticket.getData());
		} 
		return ticketDTOs;
	}
	
	/**
	 * Create new service ticket.
	 * @param ticket ticket dto containing data to set.
	 * @throws NamingException 
	 * @throws CreateException 
	 * @ejb.interface-method view-type="both"
	 */
	public TicketData createTicket(TicketData ticket) throws CreateException, NamingException {
		TicketLocal ticketLocal = TicketUtil.getLocalHome().create(ticket.getSummary(), ticket.getEmail());
		TicketData tempTicket = ticketLocal.getData();
		ticket.setLastModified(tempTicket.getLastModified());
		ticket.setSubmitted(tempTicket.getSubmitted());
		ticketLocal.setData(ticket);
		
		TicketData newTicket = ticketLocal.getData();
		
		emailConfirmation(newTicket);
		
		return newTicket;
	}
	
	private void emailConfirmation(TicketData ticket) {
		Connection conn;
		try {
			conn = EmailTicketDestinationUtil.getConnection();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(EmailTicketDestinationUtil.getDestination());
			ObjectMessage message = session.createObjectMessage();
			
			message.setObject(ticket);
			message.setStringProperty("EVENT", "ADD TICKET");
			
			producer.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permenantly deletes a ticket.
	 * @param id primary key of the ticket to delete.
	 * @throws NamingException 
	 * @throws RemoveException 
	 * @throws EJBException 
	 * @ejb.interface-method view-type="both"
	 */
	public void deleteTicket(Integer id) throws EJBException, RemoveException, NamingException {
		TicketUtil.getLocalHome().remove(id);
	}
	
}
