<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Strategy db = new StrategyDB();
Collection<?> trains = (Collection<?>) db.getAllTrains();
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

<link rel="stylesheet" href="../css/styles.css">
<title>Creazione Trip</title>
</head>
<body class="body-createTrip">
	<script src="handlerCreazioneTrip.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div align="center">
		<form id="creazioneTrip-form" onsubmit="return handleSubmit()"
			action="/TrainViewer/CreazioneTripServlet" method="POST">
			<select name="idTrain" id="idTrain">
				<%
				if (trains != null && trains.size() != 0) {
					Iterator<?> it = trains.iterator();
					while (it.hasNext()) {
						Train c = (Train) it.next();
				%>
				<option value="<%=c.getIdTrain()%>"><%=c.getBrand()%>
					<%=c.getSerialNumber()%></option>
				<%
				}

				}
				%>
				<%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				Date today = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(today);
				calendar.add(Calendar.MINUTE, 30);
				Date later = calendar.getTime();
				%>
			</select> <br> <label for="departure" required>Partenza:</label> <input
				type="text" id="departure" name="departure"> <label
				for="arrive" required>Arrivo:</label> <input type="text" id="arrive"
				name="arrive"> <br> <label for="start">Orario
				di partenza:</label> <input type="datetime-local" id="start" name="start"
				value="<%=sdf.format(today)%>" oninput="getTrainsFromDb()">
			<label for="end">Orario di arrivo:</label> <input
				type="datetime-local" id="end" name="end"
				value="<%=sdf.format(later)%>" oninput="getTrainsFromDb()">
			<br> <input type="submit" value="Crea trip!">
		</form>
		<c:set var="msg" value="${requestScope.msg}" />
		<script>
			if ("${msg}" != "")
				alert("${msg}");
		</script>
	</div>
</body>
</html>