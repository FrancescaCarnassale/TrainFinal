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
	
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
<title>Welcome</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<%String user = (String)request.getAttribute("user");%>
	 <div align="center">
	<p>Benvenuto  <%= user %></p>
	</div>
</body>
</html>