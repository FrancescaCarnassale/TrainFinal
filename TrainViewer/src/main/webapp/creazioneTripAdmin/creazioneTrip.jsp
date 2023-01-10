<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.beans.*,com.strategy.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

Strategy db = new StrategyDB();
Collection<?> trains = (Collection<?>) db.getAllTrains();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creazione Trip</title>
</head>
<body>
	<script src="handlerCreazioneTrip.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	 <div align="center">
	<form id="creazioneTrip-form" onsubmit="return handleSubmit()"  action = "/TrainViewer/CreazionTripServlet" method = "POST"	>
		<select name="idTrain" id="idTrain">
		<% 
			if(trains != null && trains.size() != 0) {
				Iterator<?> it = trains.iterator();
				while(it.hasNext()) {
					Train c = (Train) it.next();
		%>
					<option ><%=c.getBrand()%> <%=c.getSerialNumber()%></option >
				<%
			}
	
		}
		%>
		</select>
		<br>
		<label for="departure" required>Partenza:</label>
		<input type="text" id="departure" name="departure">
		<label for="arrive" required>Arrivo:</label>
		<input type="text" id="arrive" name="arrive">
		<br>
		<label for="start">Orario di partenza:</label>
		<input type="datetime-local" id="start" name="start"
       	value="2018-07-22T19:00"
       	min="2018-01-01" max="2018-12-31">
       	<br>
		<label for="end">Orario di arrivo:</label>
		<input type="datetime-local" id="end" name="end"
       	value="2018-07-22T19:30"
       	min="2018-01-01" max="2018-12-31">
       	<br>
		<input type="submit" value="Crea trip!">
	</form>
	
	<c:set var="msg" value="${requestScope.msg}" />
        <script>
        if("${msg}"!="")
            alert("${msg}");
        </script>
	</div>
</body>
</html>