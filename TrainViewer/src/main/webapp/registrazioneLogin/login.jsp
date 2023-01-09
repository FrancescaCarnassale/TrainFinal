<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Registration</title>
</head>
<body class="bg-dark">
	<script src="handlerLogin.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div align="center">
		<h1 class="py-4 text-center text-white bg-dark">Login</h1>
		<form id="login-form" class="d-flex align-items-center flex-column" onsubmit="return handleSubmit()">
			<label class="mb-1 text-center text-white" for="email" class="mb-1 text-center text-white" required>Indirizzo email:</label>
			<input type="email" id="email" name="email">
			<label for="password" class="mb-1 text-center text-white">Password:</label>
			<input type="password" id="password" name="password" required><br>
			<input type="submit" value="Entra">
		</form>
	</div>
</body>
</html>