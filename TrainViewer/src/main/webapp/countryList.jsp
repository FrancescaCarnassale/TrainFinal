<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>

<%

Strategy db = new StrategyDB();
Collection<?> countries = (Collection<?>) db.getAllCountries();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <script>
    setTimeout(function(){
        document.getElementById("loader").style.display = "none";
        document.getElementById("list").style.display = "block";
    }, 1000);
</script> 
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

  <!-- CSS only -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
<title>TrainViewer</title>
</head>
       <%  	        	String user = (String)session.getAttribute("user");
      					 String role = (String)session.getAttribute("role");
if (user != null && role.equals("admin")) {%>
<body class="bg-dark">


	<jsp:include page="menuLogged.jsp"></jsp:include>

	<!-- Table of countries -->

	<div class="container">

		<% 
			if(countries == null && countries.size() == 0) {
				%>
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
		
		<h1 class="py-4 text-center text-white bg-dark">Country Table</h1>

		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">Country</th>
					<th scope="col">Alpha Code</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<% 
					
			if(countries != null && countries.size() != 0 ) {
				Iterator<?> it = countries.iterator();
				while(it.hasNext()) {
					Country c = (Country) it.next();
		%>
					<td><%=c.getCountryName()%></td>
					<td><%=c.getAlpha2code()%></td>
				</tr>
				<%
			}
	
		}
		%>

			</tbody>
		</table>	
		
		</div>
	</div>
</body>
<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
	
</html>