<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
			crossorigin="anonymous"></script>

		<link rel="stylesheet" href="css/styles.css">
		<title>Registration</title>
	</head>

	<body>
		<script src="handlerLogin.js"></script>
		<jsp:include page="menu.jsp"></jsp:include>
		<div align="center" class="card-registration">
			<h1 class="py-4 text-center text-white">Login</h1>
			<form id="login-form" class="d-flex align-items-center flex-column" onsubmit="return handleSubmit()">
				<label class="mb-1 text-center text-white" for="email" class="mb-1 text-center text-white"
					required>Indirizzo email:</label>
				<input type="email" id="email" name="email">
				<label for="password" class="mb-1 text-center text-white">Password:</label>
				<input type="password" id="password" name="password" required><br>
				<div class="div-submit">
					<input type="submit" id="input-submit" value="Login">
					<br>
					<a href="registrazione.jsp" class="text-center text-white" id="already-registered">Utente nuovo?
						Registrati!</a>
				</div>
			</form>
		</div>
	</body>

	</html>