<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>
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
<link  rel="icon"  href="https://cdn-icons-png.flaticon.com/128/821/821354.png">
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
<title>Creazione Trip</title>
</head>
<%
String user = (String) session.getAttribute("user");
String role = (String) session.getAttribute("role");
if (user != null && role.equals("conductor")) {
%>
<body class="body-createTrip">
	<script src="handlerCreazioneTrip.js"></script>
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	<div align="center" class="card2">
		<h1 class="py-4 text-center text-white">Creazione Viaggio</h1>
		<form id="creazioneTrip-form" class="pb-4 text-center text-white createTripForm" onsubmit="return handleSubmit()" action="/TrainViewer/CreazioneTripServlet" method="POST">
    <div class="form-group" style="display: grid; grid-template-columns: 1fr 2fr;">
        <label for="idTrain" required>Treno:</label>
        <select name="idTrain" id="idTrain" style="width: 35%; margin-bottom: 5%">
						<!-- Load all created trains -->
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
        </select>
                    <%
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date today = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.MINUTE, 30);
            Date later = calendar.getTime();
            %>
        <label for="departure" required >Partenza:</label>
        <input type="text" id="departure" name="departure" style=" margin-bottom: 5%">
        <label for="arrive" required>Arrivo:</label>
        <input type="text" id="arrive" name="arrive" style=" margin-bottom: 5%">
        <label for="start">Orario di partenza:</label>
        <input type="datetime-local" id="start" name="start" value="<%=sdf.format(today)%>" style="width: 35%; margin-bottom: 5%">
        <label for="end">Orario di arrivo:</label>
        <input type="datetime-local" id="end" name="end" value="<%=sdf.format(later)%>" style="width: 35%; margin-bottom: 5%">
    </div>
    <input type="submit" class="input-submit" value="Crea viaggio!">
</form>

	</div>
</body>
<%
} else {
%>
<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
<%
}
;
%>
</html>