package com.projst.ticket.web.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projst.ticket.service.TicketServiceLocal;
import com.projst.ticket.service.TicketServiceUtil;

public class ListAllTicketsAction extends Action {
	
	private static final String SUCCESS_FORWARD = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
		TicketServiceLocal service = TicketServiceUtil.getLocalHome().create();
		Collection tickets = service.retrieveAllTickets();
		request.setAttribute("tickets",tickets);
		return mapping.findForward(SUCCESS_FORWARD); 
	}
	
}
