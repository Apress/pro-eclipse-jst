/**
 * 
 */
package com.projst.ticket.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.ejb.FinderException;
import javax.naming.NamingException;

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
}
