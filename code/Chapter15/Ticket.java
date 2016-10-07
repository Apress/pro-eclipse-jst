package com.projst.ticket.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Trouble Ticket representing something that needs to be fixed.
 *
 * @author cjudd
 */
public class Ticket implements Serializable {
    private long oid = -1;
    private String summary;
    private String detail;
    private Date submittedDate;
    private Date lastModifedDate;
    private String email;
    private String status;

    /**
     * Unique identifier for the ticket.
     *
     * @return Returns the unique identifier.
     */
    public long getOid() {
        return oid;
    }

    /**
     * @see #getOid()
     * @param oid
     *            The unique identifier.
     */
    public void setOid(long oid) {
        this.oid = oid;
    }

    /**
     * @return Returns the summary.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary
     *            The summary to set.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return Returns the detail.
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     *            The detail to set.
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return Returns the submittedDate.
     */
    public Date getSubmittedDate() {
        return submittedDate;
    }

    /**
     * @param submittedDate
     *            The submittedDate to set.
     */
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * @return Returns the lastModifedDate.
     */
    public Date getLastModifedDate() {
        return lastModifedDate;
    }

    /**
     * @param lastModifedDate
     *            The lastModifedDate to set.
     */
    public void setLastModifedDate(Date lastModifedDate) {
        this.lastModifedDate = lastModifedDate;
    }

    /**
     * @return Returns the e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param e-mail
     *            The e-mail of the person who submitted the ticket.
     */
        public String getEmail() {
        return email;
    }

    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            The status of the ticket.
     */
    public void setStatus(String status) {
        this.status = status;
    }

 }
