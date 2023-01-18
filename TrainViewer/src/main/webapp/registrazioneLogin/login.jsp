<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Login page -->
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

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
<title>Login</title>

</head>
<body class="body-login">
	<jsp:include page="../menu.jsp"></jsp:include>
	<%
	String user = (String)request.getAttribute("user");
	%>
	<div align="center" class="card2" style="border-radius: 20px;margin-left: auto;margin-right: auto; margin-top: 50px;background-color: rgba(0, 0, 0, 0.5);height: 100%;width: 60%;">
	<h1 class="py-4 text-center text-white">Login</h1>
		<form id="login-form" action="/TrainViewer/LoginServlet" method="POST">
			<label class="mb-1 text-center text-white" for="email" required>Indirizzo email:</label> <br> <input
				type="email" id="email" class="mb-1" name="email"> <br> 
				<label
				for="password" class="mb-1 text-center text-white">Password:</label> <br> 
				<input type="password"
				id="password" name="password" required><br> <br> 
		<div class="div-submit">
					<input type="submit" class="input-submit" value="Login">
					<br>
					<a href="registrazione.jsp" class="text-center text-white" id="already-registered">Non sei registrato? Registrati!</a>
		</div>
		</form>
		<c:set var="msg" value="${requestScope.msg}" />
        <script>
        if("${msg}"!="")
            alert("${msg}");
        </script>
       
       </div>
</body>

</html>