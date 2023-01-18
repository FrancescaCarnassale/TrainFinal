<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Train factory page to create Train -->
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
<title>Creazione Treno</title>
</head>
<body class="body-createTrain">
<% 
        	String user = (String)session.getAttribute("user");
			String role = (String)session.getAttribute("role");
if (user != null && role.equals("train factory")) {%>
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	<script src="handlerCreazioneTreno.js"></script>
    <div align="center" class="card2" style="border-radius: 20px;margin-left: auto;margin-right: auto; margin-top: 50px;background-color: rgba(0, 0, 0, 0.5);height: 100%;width: 60%;">		<h1 class="py-4 text-center text-white">Creazione Treno</h1>
		<form id="creazioneTreno-form" onsubmit="return handleSubmit()"
			action="/TrainViewer/CreazionTrenoServlet" method="POST"
			class="pb-4 text-center text-white createTrainForm">
			<select name="produttore" id="produttore">
				<option style="display: none">-- Seleziona un brand --</option>
				<option>Frecciarossa</option>
				<option>Trenord</option>
			</select> <label for="serialNumber" class="mt-1" required>Numero seriale:</label> <input
				type="text" id="serialNumber" name="serialNumber"> <br>
			<input type="submit" class="input-submit" value="Crea treno!">
		</form>
		<c:set var="msg" value="${requestScope.msg}" />
		<script>
			if ("${msg}" != "")
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