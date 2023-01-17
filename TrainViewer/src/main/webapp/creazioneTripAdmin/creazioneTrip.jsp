<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.beans.*,com.manager.strategy.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%

Strategy db = new StrategyDB();
Collection<?> trains = (Collection<?>) db.getAllTrains();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/styles.css">
<title>Creazione Trip</title>
</head>
<% 
        	String user = (String)session.getAttribute("user");
			String role = (String)session.getAttribute("role");
if (user != null && role .equals("train manager")) {%>
<body>
	<script src="handlerCreazioneTrip.js"></script>
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	 <div align="center">
	<form id="creazioneTrip-form" onsubmit="return handleSubmit()" action = "/TrainViewer/CreazioneTripServlet" method = "POST" >
		<select name="idTrain" id="idTrain">
		<% 
			if(trains != null && trains.size() != 0) {
				Iterator<?> it = trains.iterator();
				while(it.hasNext()) {
					Train c = (Train) it.next();
		%>
					<option value="<%=c.getIdTrain()%>"><%=c.getBrand()%> <%=c.getSerialNumber()%></option >
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
		</select>
		<br>
		<label for="departure" required>Partenza:</label>
		<input type="text" id="departure" name="departure">
		<label for="arrive" required>Arrivo:</label>
		<input type="text" id="arrive" name="arrive">
		<br>
		<label for="start">Orario di partenza:</label>
       	<input type="datetime-local" id="start" name="start" value="<%=sdf.format(today)%>" oninput="getTrainsFromDb()">
		<label for="end">Orario di arrivo:</label>
       	<input type="datetime-local" id="end" name="end" value="<%=sdf.format(later)%>" oninput="getTrainsFromDb()">
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
	<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
</html>