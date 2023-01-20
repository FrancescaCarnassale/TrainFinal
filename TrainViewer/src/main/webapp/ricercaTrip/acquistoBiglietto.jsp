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
 <%  	        	String user = (String)session.getAttribute("user");
if (user != null) {%>
<body class="body-acquisto"
	style="height: 100vh; display: flex; align-items: center; background: linear-gradient(to right, #574B90, #9E579D); margin-top: 0px !important; justify-content: center">
	<div class="container" style="margin: 0">
	<div style="text-align: center; margin-bottom:30px">
					<h1 style="color: white">Trova il biglietto giusto per te</h1>
				</div>
		<div class="card2"
			style="display: flex; padding: 20px; align-items: center; text-align: center; margin-top: 0px !important">
			<a href="/TrainViewer" style="display: inline-block;"> <img
				src="http://localhost:8080/TrainViewer/registrazioneLogin/img/arrow.png"
				alt="Indietro"
				style="max-width: 100%; position:absolute; left: 20px; top: 20px;">
			</a>
				
				<table class="tableTrip"
					style="color: white; text-align: center; width: 100%; margin-top: 25px; border-collapse: collapse; font-size: 15px;">
					<thead>
						<tr>
							<th style="font-size: 18px; width: 20%">Partenza</th>
							<th style="font-size: 18px; width: 20%">Arrivo</th>
							<th style="font-size: 18px; width: 20%">Orario di Partenza</th>
							<th style="font-size: 18px; width: 20%">Orario d'Arrivo</th>
							<th style="font-size: 18px; width: 15%">Numero biglietti</th>
						</tr>
					</thead>
					<tbody>
						 <tr>
						    <form action = "/TrainViewer/buyingTickets/buy" method = "POST">
						      <td> ${trip.getDeparture().getCountryName()}</td> 
						      <td> ${trip.getArrive().getCountryName()}</td>
						      <td>${trip.getTimeDeparture()}</td>
						      <td>${trip.getTimeArrive()}</td>
						      <td><input type="number" id="seats" name="seats" min="1" style="width: 60%"></td>
						      <input type="hidden" name="tripId" value="${trip.getIdTrip()}"/>
						      <td>
						        <input type="submit"value="Compra"/>
						      </td>
						     </form>
						    </tr>
						<c:set var="counter" value="${counter + 1}" />

					</tbody>
				</table>
				<script>
					if ("${msg}" != "")
						alert("${msg}");
				</script>
		</div>
	</div>
</body>
<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
</html>