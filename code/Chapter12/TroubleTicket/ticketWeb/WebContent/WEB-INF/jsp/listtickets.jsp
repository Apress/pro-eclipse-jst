<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <link rel="stylesheet" type="text/css" href="styles/default.css"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jstl-core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trouble Ticket Application</title>
</head>
<body>
<h2>Trouble Tickets</h2>
<table width="100%" border="0">
  <tr class="add">
    <td>
      <a href="/newTicket.do">
        <img src="images/add.gif" border="0" /> Add Ticket
      </a>
    </td>
  </tr>
</table>
<table width='100%'>
  <tr class="heading">
    <th>ID</th>
    <th>Summary</th>
    <th>Submitted Date</th>
  </tr>
<c:forEach items="${tickets}" var="ticket">
  <tr class="row">
    <td>&nbsp;<c:out value="${ticket.id}"/></td>
    <td>&nbsp;<c:out value="${ticket.summary}"/></td>
    <td>&nbsp;<c:out value="${ticket.submitted}"/></td>    
  </tr>
</c:forEach>
</table>
<table width="100%" border="0">
  <tr class="add">
    <td>
      <a href="/newTicket.do">
        <img src="images/add.gif" border="0" /> Add Ticket
      </a>
    </td>
  </tr>
</table>

</body>
</html>