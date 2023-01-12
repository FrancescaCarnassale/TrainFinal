<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

<<<<<<< HEAD:TrainViewer/src/main/webapp/registrazione.jsp
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

	<body class="body-registration">
		<script src="handlerRegistrazione.js"></script>
		<jsp:include page="menu.jsp"></jsp:include>
		<div align="center" class="card-registration">
			<form id="registration-form" onsubmit="return handleSubmit()">
				<h1 class="py-4 text-center text-white" id="title-registration">Registrazione</h1>
				<label class="mb-1 text-center text-white" for="name">Nome Utente:</label> <br>
				<input type="text" id="name" name="name" required> <br>
				<label class="mb-1 text-center text-white" for="email" required>Indirizzo email:</label> <br>
				<input type="email" id="email" name="email"> <br>
				<label class="mb-1 text-center text-white" for="password">Password:</label>
				<br>
				<input type="password" id="password" name="password" required> <br> <br>
				<div class="div-submit">
					<input type="submit" id="input-submit" value="Registrati">
					<br>
					<a href="login.jsp" class="text-center text-white" id="already-registered">Gia' registrato?
						Accedi!</a>
				</div>
			</form>

		</div>
	</body>

	</html>
=======
  <link rel="stylesheet" href="css/styles.css">
<title>Registration</title>
</head>
<body class="bg-dark">
	<script src="handlerRegistrazione.js"></script>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div align="center">
		<form id="registration-form" onsubmit="return handleSubmit()" action="/TrainViewer/RegistrazioneServlet" method="POST">
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
		<br> <a href="/TrainViewer/registrazioneLogin/login.jsp" class="py-4 text-center text-white bg-dark">Gia' registrato? Accedi!</a>
	</div>
</body>
</html>
>>>>>>> cd9d02c09e45179f5db33a88829db434453b36ff:TrainViewer/src/main/webapp/registrazioneLogin/registrazione.jsp
