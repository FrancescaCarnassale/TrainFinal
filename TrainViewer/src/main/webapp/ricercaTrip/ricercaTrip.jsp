<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.beans.*,com.manager.strategy.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
		Strategy db = new StrategyDB();
		Collection<Country> countries = db.getAllCountries();
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Trip</title>
</head>
<body style="background: linear-gradient(to right, #574B90, #9E579D)">
		<form id="ricercaBiglietto-form" action = "/TrainViewer/buyingTickets/search" method = "POST">
				
		<a href="/TrainViewer" style="display: inline-block;">
    <img src="https://cdn-icons-png.flaticon.com/128/507/507257.png" alt="Indietro" style="max-width: 25%; margin-top:10%; margin-left:10%">
</a>
<div style="text-align: center;">
    <h1 style="color:white">TROVA IL BIGLIETTO GIUSTO PER TE</h1>
</div>		<table class="tableTrip" style="color:white; width:100%; margin-top:50px; border-collapse: collapse; border: 3px solid white; font-size:15px; ">
			<thead>
				<tr>
    <th style="font-size:22px; width:25%">Partenza</th>
    <th style="font-size:22px; width:25%">Arrivo</th>
    <th style="font-size:22px; width:15">Orario di Partenza</th>
    <th style="font-size:22px; width:15">Orario d'Arrivo</th>
  </tr>
			</thead>
			<tbody>
				<c:set var="counter" value="0" />
<c:forEach items="${tripsJSP}" var="trip">
    <tr>
      <td>${trip.getDeparture().getCountryName()}</td>
      <td>${trip.getArrive().getCountryName()}</td>
      <td>${trip.getTimeDeparture()}</td>
      <td>${trip.getTimeArrive()}</td>
		<td>
		<a href="/TrainViewer/buyingTickets/buyingPage?tripId=${trip.getIdTrip()}"> Compra!</a>
		</td>
    </tr>
    <c:set var="counter" value="${counter + 1}" />
</c:forEach>

			</tbody>
		</table>

	</form>
</body>
</html>