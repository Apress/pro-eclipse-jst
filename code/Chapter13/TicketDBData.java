package com.projst.ticket.dto;


import java.sql.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class TicketDBData {

    private Connection configureConnection() throws Exception {
        String dbUrl = System.getProperty("ticketdb.driver", 
                                                                "jdbc:derby:net://localhost:1527/sample");
        String dbDriver = System.getProperty("ticketdb.driver", 
                                                            "org.apache.derby.jdbc.EmbeddedDriver");
        String dbUser = System.getProperty("ticketdb.user", "");
        String dbPassword = System.getProperty("ticketdb.password", "");
        Connection conn = null;

        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            throw new Exception("Failed to load database driver.");
        }
        return conn;
    }

    public DefaultCategoryDataset getDataset(String status, String email)
            throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (email == null || email.equals("")) {
            email = "%";
        }

        int open = retrieveDataCount("open", email);
        int closed = retrieveDataCount("closed", email);

        if (status.equals("all")) {
            dataset.addValue(new Integer(open + closed), "Total", "");
            dataset.addValue(new Integer(open), "Open", "");
            dataset.addValue(new Integer(closed), "Closed", "");
        } else if (status.equals("open")) {
            dataset.addValue(new Integer(open), "Open", "");
        } else if (status.equals("closed")) {
            dataset.addValue(new Integer(closed), "Closed", "");
        }

        return dataset;
    }

    private int retrieveDataCount(String status, String email) throws Exception {
        int count = 0;
        String sql = "SELECT * FROM TICKET WHERE STATUS LIKE ? AND EMAIL LIKE ?";

        Connection conn = configureConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, status);
        stmt.setString(2, email);

        ResultSet result = stmt.executeQuery();
        if (result.next())
            count = result.getInt(1);

        conn.close();
        return count;
    }


}
