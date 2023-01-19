<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css">
<title>Registration</title>
</head>

<body class="body-registration">
	<script src="handlerRegistrazione.js"></script>
	<div class="web">
		<div align="center" class="card2">
			<form id="registration-form" onsubmit="return handleSubmit()">
				<a href="/TrainViewer" style="display: inline-block;"> <img
					src="https://cdn-icons-png.flaticon.com/128/507/507257.png"
					alt="Indietro"
					style="max-width: 2%; position: absolute; left: 27%;">
				</a>
				<h1 class="py-4 text-center text-white" id="title-registration">Registrazione</h1>
				<label class="mb-1 text-center text-white" for="name">Nome
					Utente:</label> <br> <input type="text" class="username mb-1"
					id="name" name="name" required> <br> <label
					class="mb-1 text-center text-white" for="email" required>Indirizzo
					email:</label> <br> <input type="email" class="mb-1" id="email"
					name="email"> <br> <label
					class="mb-1 text-center text-white" for="password">Password:</label>
				<br> <input type="password" id="password" name="password"
					required> <br> <br>
				<div class="div-submit">
					<input type="submit" class="input-submit" value="Registrati">
					<br> <a href="login.jsp" class="text-center text-white"
						id="already-registered">Gia' registrato? Accedi!</a>
				</div>
			</form>

		</div>

	</div>
	<div class="mobile">
		<div align="center" class="card2">
			<form id="registration-form" onsubmit="return handleSubmit()">
				<h1 class="py-4 text-center text-white" id="title-registration">Registrazione</h1>
				<label class="mb-1 text-center text-white" for="name">Nome
					Utente:</label> <br> <input type="text" class="username mb-1"
					id="name" name="name" required> <br> <label
					class="mb-1 text-center text-white" for="email" required>Indirizzo
					email:</label> <br> <input type="email" class="mb-1" id="email"
					name="email"> <br> <label
					class="mb-1 text-center text-white" for="password">Password:</label>
				<br> <input type="password" id="password" name="password"
					required> <br> <br>
				<div class="div-submit">
					<input type="submit" class="input-submit" value="Registrati">
					<br> <a href="login.jsp" class="text-center text-white"
						id="already-registered">Gia' registrato? Accedi!</a>
				</div>
			</form>
		</div>
	</div>
</body>

</html>

