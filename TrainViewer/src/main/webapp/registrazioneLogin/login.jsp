<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Login</title>

</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<%
	String user = (String)request.getAttribute("user");
	%>
	<div align="center">
		<form id="login-form" action="/TrainViewer/LoginServlet" method="POST">
			<label for="email" required>Indirizzo email:</label> <br> <input
				type="email" id="email" name="email"> <br> <label
				for="password">Password:</label> <br> <input type="password"
				id="password" name="password" required><br> <br> <input
				type="submit" value="Entra">
		</form>
		<br> <a href="/TrainViewer/registrazioneLogin/registrazione.jsp">Non sei registrato? Registrati!</a>

		<c:set var="msg" value="${requestScope.msg}" />
        <script>
        if("${msg}"!="")
            alert("${msg}");
        </script>
       
       </div>
</body>

</html>