<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Registrazione</title>
</head>

<body class="bg-dark">
	<script src="handlerRegistrazione.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container">

		<h1 class="py-4 text-center text-white bg-dark">Registrazione</h1>

		<form id="registration-form"
			class="d-flex align-items-center flex-column"
			onsubmit="return handleSubmit()">
			<label for="name" class="mb-1 text-center text-white">Nome
				utente</label> <input type="text" id="name" name="name" required> <label
				for="email" class="mb-1 text-center text-white" required>Indirizzo
				email</label> <input type="email" id="email" name="email"> <label
				for="password" class="mb-1 text-center text-white">Password</label>

			<input type="password" class="mb-2" id="password" name="password"
				required> <input type="submit" class="btn btn-outline-light"
				value="Registrati">
		</form>
	</div>
</body>

</html>