/*
 * Generated by XDoclet - Do not edit!
 */
package com.projst.ticket.entity;

/**
 * Local interface for Ticket.
 * @generated 
 * @wtp generated
 */
public interface TicketLocal
   extends javax.ejb.EJBLocalObject
{

   public java.lang.Integer getId(  ) ;

   public java.lang.String getSummary(  ) ;

   public void setSummary( java.lang.String summary ) ;

   public java.lang.String getDetail(  ) ;

   public void setDetail( java.lang.String detail ) ;

   public java.sql.Timestamp getSubmitted(  ) ;

   public void setSubmitted( java.sql.Timestamp date ) ;

   public java.sql.Timestamp getLastModified(  ) ;

   public void setLastModified( java.sql.Timestamp date ) ;

   /**
    * Provides access to the generated getData() method of the generated CMP class.
    */
   public com.projst.ticket.entity.TicketData getData(  ) ;

   /**
    * Provides access to the generated setData() method of the generated CMP class.
    */
   public void setData( com.projst.ticket.entity.TicketData data ) ;

}