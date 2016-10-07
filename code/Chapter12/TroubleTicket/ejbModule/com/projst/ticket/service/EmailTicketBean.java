/**
 * 
 */
package com.projst.ticket.service;

import javax.jms.ObjectMessage;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.projst.ticket.entity.TicketData;

/**
 * <!-- begin-xdoclet-definition -->
 * @ejb.bean name="EmailTicket" 
 *     acknowledge-mode="Auto-acknowledge"
 *     destination-type="javax.jms.Topic"
 *     subscription-durability="NonDurable"
 *     transaction-type="Container"
 *     destination-jndi-name="topic/ticket"
 *     connection-factory-jndi-name="ConnectionFactory"
 *     message-selector="EVENT = 'ADD TICKET'"
 *     
 * @jboss.destination-jndi-name
 *     name="topic/ticket"
 * <!-- end-xdoclet-definition -->
 * @generated
 **/
public class EmailTicketBean implements javax.ejb.MessageDrivenBean,
		javax.jms.MessageListener {

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * The context for the message-driven bean, set by the EJB container. 
	 * @generated
	 */
	private javax.ejb.MessageDrivenContext messageContext = null;

	/** 
	 * Required method for container to set context.
	 * @generated 
	 */
	public void setMessageDrivenContext(
			javax.ejb.MessageDrivenContext messageContext)
			throws javax.ejb.EJBException {
		this.messageContext = messageContext;
	}

	/** 
	 * Required creation method for message-driven beans. 
	 *
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * <!-- begin-xdoclet-definition -->
	 * @ejb.create-method 
	 * <!-- end-xdoclet-definition -->
	 * @generated
	 */
	public void ejbCreate() {
		//no specific action required for message-driven beans 
	}

	/** 
	 * Required removal method for message-driven beans. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void ejbRemove() {
		messageContext = null;
	}

	/** 
	 * This method implements the business logic for the EJB. 
	 * 
	 * <p>Make sure that the business logic accounts for asynchronous message processing. 
	 * For example, it cannot be assumed that the EJB receives messages in the order they were 
	 * sent by the client. Instance pooling within the container means that messages are not 
	 * received or processed in a sequential order, although individual onMessage() calls to 
	 * a given message-driven bean instance are serialized. 
	 * 
	 * <p>The <code>onMessage()</code> method is required, and must take a single parameter 
	 * of type javax.jms.Message. The throws clause (if used) must not include an application 
	 * exception. Must not be declared as final or static. 
	 *
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void onMessage(javax.jms.Message message) {
		// begin-user-code
		if(message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage)message;
			
			try {
				TicketData ticket = (TicketData)objectMessage.getObject();
				
				//build email message using javax.mail API
				Context ctx = new InitialContext();
				Session session = (Session)ctx.lookup("java:/Mail");
				
				javax.mail.Message email = new MimeMessage(session);
				email.setRecipient(
						MimeMessage.RecipientType.TO,
						new InternetAddress(ticket.getEmail()));
				
				email.setSubject("Confirm receipt of ticket: " + ticket.getId());
				email.setText("This is an automated response that your trouble ticket was received.");
				
				Transport.send(email);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// end-user-code
	}
}