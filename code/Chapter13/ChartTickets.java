package com.projst.ticket.web;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import com.projst.ticket.dto.TicketDBData;

/**
 * Servlet implementation class for Servlet: ChartTickets
 *
 * @web.servlet name="ChartTickets"
 * display-name="ChartTickets"
 * description="Servlet to create a chart of existing trouble tickets"
 *
 * @web.servlet-mapping url-pattern="/ChartTickets"
 *
 * @web.servlet-init-param name="status" value="open"
 * description="Ticket type to include in chart"
 *
 */
public class ChartTickets
       extends javax.servlet.http.HttpServlet
       implements javax.servlet.Servlet {

    // Variable to hold the location of the temporary directory
    private String tempDir = "";

    /**
     * Initialization method called once during the servlet life cycle
     */
    public void init() throws ServletException {
        super.init();
        tempDir = this.getServletContext().getRealPath(".");
    }

    /**
     * Respond to HTTP GET requests
     */
    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        doProcess(arg0, arg1);
    }

    /**
     * Respond to HTTP POST requests
     */
    protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        doProcess(arg0, arg1);
    }

    /**
     * Process HTTP requests
     */
    protected void doProcess(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {

        String strEmail = arg0.getParameter("email");
        String strStatus = arg0.getParameter("status");
        if (strStatus==null) {
            strStatus = this.getServletConfig().getInitParameter("status");

        }

        // set the MIME type
        arg1.setContentType("text/html");

        // retrieve object for writing response
        PrintWriter out = arg1.getWriter();

        // write the response
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Chart Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3 align=\"center\">Chart Servlet</h3>");
        out.println("<br /><br />");
        out.println("Email: " + strEmail);
        out.println("<br />");
        out.println("Status: " + strStatus);
        out.write("<br/>");

        createChart(out, arg0.getSession().getId(), strStatus, strEmail);

        out.println("</body>");
        out.println("</html>");
    }

    private void createChart(PrintWriter out, String sid, 
                                           String status, String email) {
        try {
            TicketDBData data = new TicketDBData();
            CategoryDataset dataset = data.getDataset(status, email);

            // Create the chart object
            JFreeChart chart = ChartFactory.createBarChart3D(
                    "", "Ticket Status", "", dataset,
                    PlotOrientation.VERTICAL, true, true, false);
            chart.setBackgroundPaint(java.awt.Color.white);

            // Create a temporary image file
            String filePath = tempDir + "/images/";
            File outfile = new File(filePath + sid + ".jpg");
            outfile.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(outfile);
            ChartUtilities.writeChartAsJPEG(fos, 1.0f, chart, 300, 200);
            fos.flush();
            fos.close();

            //Reference the temporary file in the generated HTML
            out.println("<br/><img src=\"" + outfile.getAbsolutePath() + "\">");

        } catch (Exception e) {
            out.println("Error: Unable to create chart");
            e.printStackTrace(System.out);
        }
    }
}
