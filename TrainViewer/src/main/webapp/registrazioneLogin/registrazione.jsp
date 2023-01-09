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
	<script src="handlerRegistrazione.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div align="center">
		<form id="registration-form" onsubmit="return handleSubmit()">
			<h1 class="py-4 text-center text-white bg-dark" >Registrazione</h1>
			<label class="mb-1 text-center text-white" for="name">Nome Utente:</label> <br> 
			<input type="text"
				id="name" name="name" required> <br> 
				<label class="mb-1 text-center text-white" for="email"
				required>Indirizzo email:</label> <br> 
				<input type="email"
				id="email" name="email"> <br>
				<label class="mb-1 text-center text-white" for="password">Password:</label>
			<br> 
			<input type="password" id="password" name="password"
				required> <br> <br> <input type="submit"
				value="Registrati">
		</form>
		<br> <a href="login.jsp" class="py-4 text-center text-white bg-dark">Gia' registrato? Accedi!</a>
	</div>
</body>
</html>