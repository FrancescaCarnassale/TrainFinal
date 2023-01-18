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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
<title>Ricerca Trip</title>
</head>
<body class="body-searchTrain" style="background: rgb(2, 0, 36);background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(224, 85, 255, 1) 0%, rgba(123, 0, 255, 1) 100%);">
	<jsp:include page="../menu.jsp"></jsp:include>
    <div align="center" class="card2" style="border-radius: 20px;margin-left: auto;margin-right: auto; margin-top: 50px;background-color: rgba(0, 0, 0, 0.5);height: 100%;width: 60%;">	
    <h1 class="py-4 text-center text-white">Ricerca Treno</h1>
	<form id="ricercaTreno-form" action = "/TrainViewer/buyingTickets/search" method = "POST" style="display: flex;flex-direction: column;align-items: center;justify-content: center; color:white">
	<div>
		PARTENZA:
		<select name="departures" id="departures">
		<% 
			if(countries != null && countries.size() != 0) {
				Iterator<?> it = countries.iterator();
				while(it.hasNext()) {
					Country c = (Country) it.next();
		%>
					<option><%=c.getCountryName()%></option >
				<%
			}
	
		}
		%>
		</select>
		
		ARRIVO:
		<select name="arrives" id="arrives">
		<% 
			if(countries != null && countries.size() != 0) {
				Iterator<?> it = countries.iterator();
				while(it.hasNext()) {
					Country c = (Country) it.next();
		%>
					<option><%=c.getCountryName()%></option >
				<%
			}
	
		}
		%>
		</select>
		</div>
		<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.MINUTE, 30);
		Date later = calendar.getTime();
		%>
		<br>
		<label for="start">Orario di partenza:</label>
       	<input type="datetime-local" id="timeDeparture" name="timeDeparture" value="<%=sdf.format(today)%>" oninput="getTrainsFromDb()">
		<br>
		<input type="submit" value="Cerca viaggi"/>
		
		
		
<c:set var="tripsJSP" value="${requestScope.trips}" />
<table>
  <tr>
    <th>Partenza</th>
    <th>Arrivo</th>
    <th>Orario di Partenza</th>
    <th>Orario d'Arrivo</th>
  </tr>
  <c:forEach items="${tripsJSP}" var="trip">
    <tr>
    <form action = "/TrainViewer/buyingTickets/buy" method = "POST">
      <td>${trip.getDeparture().getCountryName()}</td>
      <td>${trip.getArrive().getCountryName()}</td>
      <td>${trip.getTimeDeparture()}</td>
      <td>${trip.getTimeArrive()}
      <td>
      	<input type="hidden" name="tripId" value="${trip.getIdTrip()}"/>
		<input type="submit" value="Compra biglietto!"/>
		</td>
     </form>
    </tr>
  </c:forEach>
</table>


	</form>
	</div>
</body>
</html>