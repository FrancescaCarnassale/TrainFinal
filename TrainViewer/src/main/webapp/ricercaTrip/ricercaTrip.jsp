<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
Strategy db = new StrategyDB();
Collection<Country> countries = db.getAllCountries();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css">
<title>Ricerca Trip</title>
</head>
<body style="background: linear-gradient(to right, #574B90, #9E579D); margin-top: 0px!important">
	<form id="ricercaBiglietto-form"
		action="/TrainViewer/buyingTickets/search" method="POST">

		<a href="/TrainViewer" style="display: inline-block;"> <img
			src="http://localhost:8080/TrainViewer/registrazioneLogin/img/arrow.png"
			alt="Indietro"
			style="max-width: 100%; margin-top: 70%; margin-left: 80%">
		</a>
		<div style="text-align: center;">
			<h1 style="color: white">TROVA IL BIGLIETTO GIUSTO PER TE</h1>
		</div>
		<table class="tableTrip"
			style="color: white; width: 100%; margin-top: 50px; border-collapse: collapse; border: 3px solid white; font-size: 15px;">
			<thead>
				<tr>
					<th style="font-size: 22px; width: 25%">Partenza</th>
					<th style="font-size: 22px; width: 25%">Arrivo</th>
					<th style="font-size: 22px; width: 15">Orario di Partenza</th>
					<th style="font-size: 22px; width: 15">Orario d'Arrivo</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="counter" value="0" />
				<c:set var="tripsJSP" value="${requestScope.trips}" /> 
				<c:forEach items="${tripsJSP}" var="trip">
					<tr>
						<td>${trip.getDeparture().getCountryName()}</td>
						<td>${trip.getArrive().getCountryName()}</td>
						<td>${trip.getTimeDeparture()}</td>
						<td>${trip.getTimeArrive()}</td>
						<td><a
							href="/TrainViewer/buyingTickets/buyingPage?tripId=${trip.getIdTrip()}">
								Compra!</a></td>
					</tr>
					<c:set var="counter" value="${counter + 1}" />
				</c:forEach>

			</tbody>
		</table>

	</form>
</body>
</html>