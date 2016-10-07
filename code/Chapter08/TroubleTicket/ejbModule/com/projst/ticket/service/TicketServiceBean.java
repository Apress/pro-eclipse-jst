/**
 * 
 */
package com.projst.ticket.service;

import java.util.Date;


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
}
