<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:set var="trip" value="${requestScope.tripId}" />
<html>
<head>
<link rel="stylesheet" href="../css/styles.css">
<meta charset="ISO-8859-1">
<title>Acquisto biglietto</title>
</head>
<body>
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
      <td>${trip.getDeparture().getCountryName()}</td>
      <td>${trip.getArrive().getCountryName()}</td>
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

</body>
</html>