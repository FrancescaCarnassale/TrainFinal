<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Strategy db = new StrategyDB();
Collection<?> aliases = (Collection<?>) db.getUnapprovedAliases();
Collection<?> countries = (Collection<?>) db.getAllCountries();
%>

<!-- Admin page where the user can add aliases to the database or delete them -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="css/styles.css">
</head>
<% 
        	String user = (String)session.getAttribute("user");
			String role = (String)session.getAttribute("role");
if (user != null && role.equals("admin")) {%>

<body class="bg-dark">

	<jsp:include page="menuLogged.jsp"></jsp:include>

	<div class="container">
		<h1 class="py-4 text-center text-white bg-dark">Alias Table</h1>
		<form action="aliasApproving/approve" method="GET">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">Alias</th>
						<th scope="col">Country</th>
						<th scope="col">Approved</th>
						<th scope="col">Deleted</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
						if (aliases != null && aliases.size() != 0) {
							Iterator<?> it = aliases.iterator();
							while (it.hasNext()) {
								Alias a = (Alias) it.next();
						%>
						<td><%=a.getAlias()%></td>
						<td>
								<select name="newCountry" id="newCountry">
								<% 
									if(countries != null && countries.size() != 0) {
										Iterator<?> it2 = countries.iterator();
										while(it2.hasNext()) {
											Country c = (Country) it2.next();
								%>
											<option><%=c.getCountryName()%></option >
										<%
									}
							
								}
								%>
						</td>
						<td><input type="checkbox" name="checkAlias"
							value="<%=a.getAlias()%>"></td>
						<td><input type="checkbox" name="checkDelete"
							value="<%=a.getAlias()%>"></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
			<p class="text-center">
				<input class="btn btn-outline-light" id="btn-approve" type="submit" value="Approve">
			</p>
		</form>
		<c:set var="msg" value="${requestScope.msg}" />
        <script>
        if("${msg}"!="")
            alert("${msg}");
        </script>


	</div>
</body>
	<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
</html>