/*
 * Generated file - Do not edit!
 */
package com.projst.ticket.service;

/**
 * Utility class for EmailTicket.
 * @generated 
 * @wtp generated
 */
public class EmailTicketDestinationUtil
{

   /** Cached Destination (javax.jms.Destination). Uses lazy loading to obtain its value (loaded by getDestination() methods). */
   private static javax.jms.Destination cachedDestination = null;
   /** Cached connection factory. Uses lazy loading to obtain its value. */
   private static javax.jms.ConnectionFactory cachedConnectionFactory = null;

  private static final java.lang.String DESTINATION_JNDI_NAME="topic/ticket";
  private static final java.lang.String CONNECTION_FACTORY_JNDI_NAME="ConnectionFactory";

   /**
    * Obtain destination Destination from default initial context
    * @return Destination JMS Destination for EmailTicket. Lookup using JNDI_NAME
    */
   public static javax.jms.Destination getDestination() throws javax.naming.NamingException
   {
      if (cachedDestination == null) {
         // Obtain initial context
         javax.naming.InitialContext initialContext = new javax.naming.InitialContext();
         try {
            java.lang.Object objRef = initialContext.lookup(DESTINATION_JNDI_NAME);
            cachedDestination = (javax.jms.Destination) objRef;
         } finally {
            initialContext.close();
         }
      }
      return cachedDestination;
   }

   /**
    * Obtain destination Destination from parameterised initial context
    * @param environment Parameters to use for creating initial context
    * @return Destination JMS Destination for EmailTicket. Lookup using JNDI_NAME
    */
   public static javax.jms.Destination getDestination( java.util.Hashtable environment ) throws javax.naming.NamingException
   {
      // Obtain initial context
      javax.naming.InitialContext initialContext = new javax.naming.InitialContext(environment);
      try {
         java.lang.Object objRef = initialContext.lookup(DESTINATION_JNDI_NAME);
         return (javax.jms.Destination) objRef;
      } finally {
         initialContext.close();
      }
   }

   /**
    * Obtain destination Destination from default initial context
    * @return Destination JMS Connection Factory for EmailTicket. Lookup using JNDI_NAME
    */
   public static javax.jms.Connection getConnection() throws javax.naming.NamingException, javax.jms.JMSException
   {
      if (cachedConnectionFactory == null) {
         // Obtain initial context
         javax.naming.InitialContext initialContext = new javax.naming.InitialContext();
         try {
            java.lang.Object objRef = initialContext.lookup(CONNECTION_FACTORY_JNDI_NAME);
            cachedConnectionFactory = (javax.jms.ConnectionFactory) objRef;
         } finally {
            initialContext.close();
         }
      }
      return cachedConnectionFactory.createConnection();
   }

   /**
    * Obtain destination Destination from parameterised initial context
    * @param environment Parameters to use for creating initial context
    * @return Destination JMS Connection Factory for EmailTicket. Lookup using JNDI_NAME
    */
   public static javax.jms.Connection getConnection( java.util.Hashtable environment ) throws javax.naming.NamingException, javax.jms.JMSException
   {
      // Obtain initial context
      javax.naming.InitialContext initialContext = new javax.naming.InitialContext(environment);
      try {
         java.lang.Object objRef = initialContext.lookup(CONNECTION_FACTORY_JNDI_NAME);
         return ((javax.jms.ConnectionFactory) objRef).createConnection();
      } finally {
         initialContext.close();
      }
   }

   /** Cached per JVM server IP. */
   private static String hexServerIP = null;

   // initialise the secure random instance
   private static final java.security.SecureRandom seeder = new java.security.SecureRandom();

   /**
    * A 32 byte GUID generator (Globally Unique ID). These artificial keys SHOULD <strong>NOT </strong> be seen by the user,
    * not even touched by the DBA but with very rare exceptions, just manipulated by the database and the programs.
    *
    * Usage: Add an id field (type java.lang.String) to your EJB, and add setId(XXXUtil.generateGUID(this)); to the ejbCreate method.
    */
   public static final String generateGUID(Object o) {
       StringBuffer tmpBuffer = new StringBuffer(16);
       if (hexServerIP == null) {
           java.net.InetAddress localInetAddress = null;
           try {
               // get the inet address

               localInetAddress = java.net.InetAddress.getLocalHost();
           }
           catch (java.net.UnknownHostException uhe) {
               System.err.println("EmailTicketUtil: Could not get the local IP address using InetAddress.getLocalHost()!");
               // todo: find better way to get around this...
               uhe.printStackTrace();
               return null;
           }
           byte serverIP[] = localInetAddress.getAddress();
           hexServerIP = hexFormat(getInt(serverIP), 8);
       }

       String hashcode = hexFormat(System.identityHashCode(o), 8);
       tmpBuffer.append(hexServerIP);
       tmpBuffer.append(hashcode);

       long timeNow      = System.currentTimeMillis();
       int timeLow       = (int)timeNow & 0xFFFFFFFF;
       int node          = seeder.nextInt();

       StringBuffer guid = new StringBuffer(32);
       guid.append(hexFormat(timeLow, 8));
       guid.append(tmpBuffer.toString());
       guid.append(hexFormat(node, 8));
       return guid.toString();
   }

   private static int getInt(byte bytes[]) {
       int i = 0;
       int j = 24;
       for (int k = 0; j >= 0; k++) {
           int l = bytes[k] & 0xff;
           i += l << j;
           j -= 8;
       }
       return i;
   }

   private static String hexFormat(int i, int j) {
       String s = Integer.toHexString(i);
       return padHex(s, j) + s;
   }

   private static String padHex(String s, int i) {
       StringBuffer tmpBuffer = new StringBuffer();
       if (s.length() < i) {
           for (int j = 0; j < i - s.length(); j++) {
               tmpBuffer.append('0');
           }
       }
       return tmpBuffer.toString();
   }

}

