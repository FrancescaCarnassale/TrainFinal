<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<c:set var="trip" value="${requestScope.tripId}" />
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css">
<meta charset="ISO-8859-1">
<title>Acquisto biglietto</title>
</head>
<body class="body-acquisto"
	style="height: 100vh; display: flex; align-items: center; background: linear-gradient(to right, #574B90, #9E579D); margin-top: 0px !important; justify-content: center">
	<div class="container" style="margin: 0">
		<div class="card2"
			style="display: flex; padding: 20px; align-items: center; text-align: center; margin-top: 0px !important">
			<a href="/TrainViewer" style="display: inline-block;"> <img
				src="http://localhost:8080/TrainViewer/registrazioneLogin/img/arrow.png"
				alt="Indietro"
				style="max-width: 100%; position:absolute; left: 20px; top: 20px;">
			</a>
			<form id="ricercaBiglietto-form" style="width: 100%"
				action="/TrainViewer/buyingTickets/search" method="POST" style="margin-top: 60px">

				<div style="text-align: center;">
					<h1 style="color: white">Trova il biglietto giusto per te</h1>
				</div>
				<table class="tableTrip"
					style="color: white; text-align: center; width: 100%; margin-top: 25px; border-collapse: collapse; font-size: 15px;">
					<thead>
						<tr>
							<th style="font-size: 18px; width: 25%">Partenza</th>
							<th style="font-size: 18px; width: 25%">Arrivo</th>
							<th style="font-size: 18px; width: 15">Orario di Partenza</th>
							<th style="font-size: 18px; width: 15">Orario d'Arrivo</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${trip.getDeparture().getCountryName()}</td>
							<td>${trip.getArrive().getCountryName()}</td>
							<td>${trip.getTimeDeparture()}</td>
							<td>${trip.getTimeArrive()}</td>
							<td><a style="color: white; text-decoration: none"
								href="/TrainViewer/buyingTickets/buyingPage?tripId=${trip.getIdTrip()}">
									Compra!</a></td>
						</tr>
						<c:set var="counter" value="${counter + 1}" />

					</tbody>
				</table>
				<script>
					if ("${msg}" != "")
						alert("${msg}");
				</script>
			</form>
		</div>
	</div>
</body>
</html>

