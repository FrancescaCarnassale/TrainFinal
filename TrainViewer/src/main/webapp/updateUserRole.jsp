<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Strategy db = new StrategyDB();
Collection<?> users = (Collection<?>) db.getUsersWithRole("client");
%>
<!DOCTYPE html>
<html>
<head>
<link  rel="icon"  href="https://cdn-icons-png.flaticon.com/128/821/821354.png">
<meta charset="ISO-8859-1">
<title>Users Roles</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
 <script>
    setTimeout(function(){
        document.getElementById("loader").style.display = "none";
        document.getElementById("list").style.display = "block";
    }, 1000);
</script> 
  <link rel="stylesheet" href="css/styles.css">
</head>
<% 
        	String user = (String)session.getAttribute("user");
			String role = (String)session.getAttribute("role");
if (user != null && role.equals("admin")) {%>

<body class="bg-dark">

	<jsp:include page="menuLogged.jsp"></jsp:include>

	<div class="container">
	<% 
			if(users == null && users.size() == 0) {
				%>
				
				<!-- Loading screen when waiting for the list -->
				
				<div id="loader" style="align-items: center; justify-content: center; display: flex;">
		  		<img src="https://thumbs.gfycat.com/InferiorDecentAsianporcupine-max-1mb.gif" alt="Loading...">
		  		<h3 style="color:white">Loading...</h3>
			</div>
			<%
			}
		%>
		<div id="loader" style="align-items: center; justify-content: center; display: flex; flex-direction:row; padding-top: 20%">
			<div style="align-items: center; display: flex; flex-direction: column;">
		  		<img src="https://thumbs.gfycat.com/InferiorDecentAsianporcupine-max-1mb.gif" style="padding-left: 5rem; width: 25rem" alt="Loading...">
		  		<h3 style="color:white; font-size:3rem">Loading...</h3>
			</div>
		</div>
		<div id="list" style="display: none;" >
	
		<h1 class="py-4 text-center text-white bg-dark">Users roles</h1>
		<form action="/TrainViewer/UpdateUserRoleServlet" method="GET">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">Email</th>
						<th scope="col">Name</th>
						<th scope="col">Role</th>
						<th scope="col">Assign</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
						if (users != null && users.size() != 0) {
							Iterator<?> it = users.iterator();
							while (it.hasNext()) {
								User a = (User) it.next();
						%>
						<td><%=a.getEmail()%></td>
						<td><%=a.getName()%></td>
						
						<td>
								<select name="newRole" id="newRole">
								<option>admin</option>
								<option>factory</option>
								<option>conductor</option>
								
						</td>
						<td><input type="checkbox" name="checkRole"
							value="<%=a.getEmail()%>"></td>
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