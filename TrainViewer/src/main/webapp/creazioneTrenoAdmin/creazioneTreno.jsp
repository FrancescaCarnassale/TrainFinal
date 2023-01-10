<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creazione</title>
</head>
<body>
	<script src="handlerCreazioneTreno.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	 <div align="center">
	<form id="creazioneTreno-form" onsubmit="return handleSubmit()"  action = "/TrainViewer/CreazionTrenoServlet" method = "POST"	>
		<select name="produttore" id="produttore">
		   		<option style="display:none">--Seleziona un brand--</option>
			    <option >Frecciarossa</option>
			    <option value="tn">Trenord</option>
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
</html>