/*
 * Generated by XDoclet - Do not edit!
 */
package com.projst.ticket.service;

/**
 * Remote interface for TicketService.
 * @generated 
 * @wtp generated
 */
public interface TicketService
   extends javax.ejb.EJBObject
{
   /**
    * Method used to ensure session bean is available by providing an echo message <!-- begin-xdoclet-definition -->
    * @generated     */
   public java.lang.String ping( java.lang.String param )
      throws java.rmi.RemoteException;

   /**
    * Return all tickets.
    */
   public java.util.Collection retrieveAllTickets(  )
      throws javax.ejb.FinderException, javax.naming.NamingException, java.rmi.RemoteException;

   /**
    * Create new service ticket.
    * @param ticket ticket dto containing data to set.
    * @throws NamingException
    * @throws CreateException
    */
   public com.projst.ticket.entity.TicketData createTicket( com.projst.ticket.entity.TicketData ticket )
      throws javax.ejb.CreateException, javax.naming.NamingException, java.rmi.RemoteException;

   /**
    * Permenantly deletes a ticket.
    * @param id primary key of the ticket to delete.
    * @throws NamingException
    * @throws RemoveException
    * @throws EJBException
    */
   public void deleteTicket( java.lang.Integer id )
      throws javax.ejb.RemoveException, javax.naming.NamingException, java.rmi.RemoteException;

}
