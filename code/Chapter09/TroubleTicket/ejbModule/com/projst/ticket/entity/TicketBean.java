/**
 * 
 */
package com.projst.ticket.entity;

import java.util.Date;
import java.sql.Timestamp;

/**
 * <!-- begin-user-doc -->
 * Persistable ticket.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-xdoclet-definition -->
 * @ejb.bean name="Ticket"
 *           description="An entity bean for persisting Tickets"
 *           display-name="Ticket"
 *           jndi-name="Ticket"
 *           type="CMP"
 *           transaction-type="Container"
 *           view-type="local"
 *           schema="ticket"
 *           cmp-version="2.x"
 *           primkey-field="id"
 * 
 * @ejb.finder signature="java.util.Collection findAll()" 
 *             query="SELECT OBJECT(a) FROM ticket as a"
 * 
 * @jboss.persistence table-name = "TICKET"
 *                    datasource = "java:/jdbc/ticket"
 *                    datasource-mapping = "Derby"
 *                    create-table = "false"
 *                    alter-table = "false"
 *                    remove-table = "false"
 * 
 * @jboss.unknown-pk class="java.lang.Integer"
 *                   readonly="true"
 *                   column-name="ID"
 *                   auto-increment="true"
 * 
 * @jboss.entity-command name="get-generated-keys"
 *                       class="org.jboss.ejb.plugins.cmp.jdbc.keygen.JDBC30GeneratedKeysCreateCommand"
 * 
 * <!-- end-xdoclet-definition -->
 * @generated
 */

public abstract class TicketBean implements javax.ejb.EntityBean {

	/**
	 * Create lifecycle method used to initialize the object.
	 * @ejb.create-method
	 */
	public Integer ejbCreate(String summary) throws javax.ejb.CreateException {

		setSummary(summary);
		Date date = new Date();
		Timestamp now = new Timestamp(date.getTime());
		setSubmitted(now);
		setLastModified(now);
		return null;
	}

	/**
	 * @ejb.interface-method
	 * @ejb.persistence
	 *      column-name="ID"
	 *      jdbc-type="BIGINT"
	 */

	public abstract Integer getId();

	/**
	 * @ejb.interface-method
	 * @ejb.persistence
	 *      column-name="SUMMARY"
	 *      jdbc-type="VARCHAR"
	 */

	public abstract String getSummary();

	/**
	 * @ejb.interface-method
	 */

	public abstract void setSummary(String summary);

	/**
	 * @ejb.interface-method
	 * @ejb.persistence
	 *      column-name="DETAIL"
	 *      jdbc-type="VARCHAR"
	 */

	public abstract String getDetail();

	/**
	 * @ejb.interface-method
	 */

	public abstract void setDetail(String detail);

	/**
	 * @ejb.interface-method
	 * @ejb.persistence
	 *      column-name="SUBMITTED"
	 *      jdbc-type="TIMESTAMP"
	 */

	public abstract Timestamp getSubmitted();

	/**
	 * @ejb.interface-method
	 */

	public abstract void setSubmitted(Timestamp date);

	/**
	 * @ejb.interface-method
	 * @ejb.persistence
	 *      column-name="LASTMODIFIED"
	 *      jdbc-type="TIMESTAMP"
	 */

	public abstract Timestamp getLastModified();

	/**
	 * @ejb.interface-method
	 */

	public abstract void setLastModified(Timestamp date);

	/**
	 * Provides access to the generated getData() method of the generated CMP
	 * class.
	 * 
	 * @ejb.interface-method
	 */

	public abstract TicketData getData();

	/**
	 * Provides access to the generated setData() method of the generated CMP
	 * class.
	 * 
	 * @ejb.interface-method
	 */

	public abstract void setData(TicketData data);

}
