<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Strategy db = new StrategyDB();
Collection<?> aliases = (Collection<?>) db.getUnapprovedAliases();
Collection<?> countries = (Collection<?>) db.getAllCountries();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<!-- CSS only -->
<link rel="stylesheet" href="css/styles.css">

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body class="bg-dark">

	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container">
		<h1 class="py-4 text-center text-white bg-dark">Alias Table</h1>
		<form action="AliasApprovingServlet" method="GET">
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
				<input class="btn btn-outline-light" type="submit" value="Approve">
			</p>
		</form>
		<c:set var="msg" value="${requestScope.msg}" />
        <script>
        if("${msg}"!="")
            alert("${msg}");
        </script>


	</div>
</body>
</html>