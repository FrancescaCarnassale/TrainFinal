<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.beans.*,com.strategy.*"%>
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
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	 <div align="center">
	<form id="ricercaTreno-form" action = "/TrainViewer/RicercaTrenoServlet" method = "POST" >
		PARTENZA:
		<select name="departures" id="departures">
		<% 
			if(countries != null && countries.size() != 0) {
				Iterator<?> it = countries.iterator();
				while(it.hasNext()) {
					Country c = (Country) it.next();
		%>
					<option value="<%=c%>"><%=c.getCountryName()%></option >
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
					<option value="<%=c%>"><%=c.getCountryName()%></option >
				<%
			}
	
		}
		%>
		</select>
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
		
		
		<table>
    <thead>
        <tr>
            <th>Id Treno</th>
            <th>Partenza</th>
            <th>Arrivo</th>
            <th>Orario Partenza</th>
            <th>Orario Arrivo</th>
        </tr>
    </thead>
    <tbody>
    	<% Collection<Trip> trips = (Collection<Trip>) request.getAttribute("trips"); %>
        <% for (Trip trip : trips) { %>
            <tr>
                <td><%= trip.getIdTrain() %></td>
                <td><%= trip.getDeparture().getCountryName() %></td>
                <td><%= trip.getArrive().getCountryName() %></td>
                <td><%= trip.getTimeDeparture() %></td>
                <td><%= trip.getTimeArrive() %></td>
            </tr>
        <% } %>
    </tbody>
</table>

	</form>
	</div>
</body>
</html>