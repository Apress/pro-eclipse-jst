package com.projst.ticket.ws;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.projst.ticket.dto.*;

/**
 * @author hshittu
 */
public class TicketWebService {

    /**
     * Constructor
     */
    public TicketWebService() {
        super();
    }

    /**
     * Retrieves a specific ticket based on the ticket identifier
     *
     * @param id The id of the trouble ticket
     */
    public Ticket getTicket(int id) {
        String sql = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Ticket ticket = new Ticket();

        try {
            sql = "SELECT * FROM TICKET WHERE ID = ?";
            conn = configureConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                ticket = getData(resultSet);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ticket = null;
        }
        return ticket;
    }

    /**
     * Retrieves all open tickets within the system
     *
     * @param status  The type of trouble tickets to retrieve
     */
    public Ticket[] getTickets(String status) {
        String sql = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Ticket tickets[];
        ArrayList list = new ArrayList();

        try {
            if (status == null || status.equals("")) {
                status = "%";
            }
            sql = "SELECT * FROM TICKET WHERE STATUS LIKE ?";
            conn = configureConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                list.add(getData(resultSet));
            }
            conn.close();

            tickets = new Ticket[list.size()];
            for (int i = 0; i < list.size(); i++) {
                tickets[i] = (Ticket) list.get(i);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            tickets = null;
        }
        return tickets;
    }

    private Connection configureConnection() throws Exception {
        String dbUrl = System.getProperty("ticketdb.url",
                                         "jdbc:derby:net://localhost:1527/ticket");
        String dbDriver =System.getProperty("ticketdb.driver",
                                           "org.apache.derby.jdbc.EmbeddedDriver");
       String dbUser = System.getProperty("ticketdb.user", "sa");
       String dbPassword = System.getProperty("ticketdb.password", "sa");
        Connection conn = null;

        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            throw new Exception("Failed to load database driver.");
        }
        return conn;
    }

    private Ticket getData(ResultSet resultSet) {
        if (resultSet == null)
            return null;
        Ticket ticket = new Ticket();

        try {
            ticket.setOid(resultSet.getInt("ID"));
            ticket.setEmail(resultSet.getString("EMAIL"));
            ticket.setStatus(resultSet.getString("STATUS"));
            ticket.setSummary(resultSet.getString("SUMMARY"));
            ticket.setSubmittedDate(resultSet.getTimestamp("SUBMITTED"));
            ticket.setLastModifedDate(resultSet.getTimestamp("LASTMODIFIED"));
            ticket.setDetail(resultSet.getString("DETAIL"));
        } catch (Exception ex) {
            ex.printStackTrace();
            ticket = null;
        }
        return ticket;
    }
}
