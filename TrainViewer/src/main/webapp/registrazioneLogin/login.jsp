<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Login page -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link  rel="icon"  href="https://cdn-icons-png.flaticon.com/128/821/821354.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css">
<title>Login</title>

</head>

<body class="body-login">
	<%
	String user = (String) request.getAttribute("user");
	%>
	<div class="web">
		<div align="center" class="card2">
			<a href="/TrainViewer" style="display: inline-block;"> <img
				src="img/arrow.png"
				alt="Indietro" style="max-width: 2%; position: absolute; left: 27%;">
			</a>
			<h1 class="py-4 text-center text-white">Login</h1>
			<form id="login-form" action="/TrainViewer/LoginServlet"
				method="POST">
				<label class="mb-1 text-center text-white" for="email" required>Indirizzo
					email:</label> <br> <input type="email" id="email" class="mb-1"
					name="email"> <br> <label for="password"
					class="mb-1 text-center text-white">Password:</label> <br> <input
					type="password" id="password" name="password" required><br>
				<br>
				<div class="div-submit">
					<input type="submit" class="input-submit" value="Login"> <br>
					<a href="/TrainViewer/registrazioneLogin/registrazione.jsp" class="text-center text-white" id="already-registered">Non sei
						registrato? Registrati!</a>
				</div>
			</form>
            
		</div>
	</div>
	<div class="mobile">
		<div align="center" class="card2">
			<a href="/TrainViewer" style="display: inline-block;"> <img
				src="https://cdn-icons-png.flaticon.com/128/507/507257.png"
				alt="Indietro" style="max-width: 20px; position: absolute; left: 20px;">
			</a>
			<h1 class="py-4 text-center text-white">Login</h1>
			<form id="login-form" action="/TrainViewer/LoginServlet"
				method="POST">
				<label class="mb-1 text-center text-white" for="email" required>Indirizzo
					email:</label> <br> <input type="email" id="email" class="mb-1"
					name="email"> <br> <label for="password"
					class="mb-1 text-center text-white">Password:</label> <br> <input
					type="password" id="password" name="password" required><br>
				<br>
				<div class="div-submit">
					<input type="submit" class="input-submit" value="Login"> <br>
					<a href="/TrainViewer/registrazioneLogin/registrazione.jsp" class="text-center text-white" id="already-registered">Non sei
						registrato? Registrati!</a>
				</div>
			</form>

		</div>
	</div>
	<c:set var="msg" value="${requestScope.msg}" />
				<script>
				if ("${msg}" != "")
					alert("${msg}");
			</script>
</body>

</html>