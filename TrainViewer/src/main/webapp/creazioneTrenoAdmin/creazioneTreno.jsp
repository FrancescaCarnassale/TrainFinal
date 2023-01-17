<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Creazione Treno</title>
</head>
<% 
        	String user = (String)session.getAttribute("user");
			String role = (String)session.getAttribute("role");
if (user != null && role.equals("train factory")) {%>
<body>
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	<script src="handlerCreazioneTreno.js"></script>
	
	 <div align="center">
	<form id="creazioneTreno-form" onsubmit="return handleSubmit()"  action = "/TrainViewer/CreazionTrenoServlet" method = "POST"	>
		<select name="produttore" id="produttore">
		   		<option style="display:none">--Seleziona un brand--</option>
			    <option >Frecciarossa</option>
			    <option >Trenord</option>
		</select>
		<label for="serialNumber" required>Numero seriale:</label>
		<input type="text" id="serialNumber" name="serialNumber">
		<br>
		<input type="submit" value="Crea treno!">
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