<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="trip" value="${requestScope.tripId}" />
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
<meta charset="ISO-8859-1">
<title>Acquisto biglietto</title>
</head>
 <%  	        	String user = (String)session.getAttribute("user");
if (user != null) {%>
<body onload="loadFlag()">
<jsp:include page="../menuLogged.jsp"></jsp:include>
<table>
  <tr>
    <th>Partenza</th>
    <th>Arrivo</th>
    <th>Orario di Partenza</th>
    <th>Orario d'Arrivo</th>
    <th>Numero biglietti</th>
  </tr>
    <tr>
    <form action = "/TrainViewer/buyingTickets/buy" method = "POST">
      <td><img id="depImg" src="" width="30" height="30"> ${trip.getDeparture().getCountryName()}</td> 
      <td><img id="arrImg" src="" width="30" height="30"> ${trip.getArrive().getCountryName()}</td>
      <td>${trip.getTimeDeparture()}</td>
      <td>${trip.getTimeArrive()}</td>
      <td><input type="number" id="seats" name="seats" min="1"></td>
      <input type="hidden" name="tripId" value="${trip.getIdTrip()}"/>
      <td>
		<input type="submit" value="Compra"/>
	  </td>
     </form>
    </tr>
</table>
     <div class="d-none">
                    <input id="dep" type="hidden" value="${trip.getDeparture().getAlpha2code().toLowerCase()}">
                    <input id="arr" type="hidden" value="${trip.getArrive().getAlpha2code().toLowerCase()}">
                </div>
                <script type="text/javascript" src="js/flag.js"></script>        
</body>
<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
</html>
