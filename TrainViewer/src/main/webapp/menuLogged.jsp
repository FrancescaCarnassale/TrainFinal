<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
	String user = (String)session.getAttribute("user");
	String role = (String)session.getAttribute("role");
	%>
	 
<nav class="navbar navbar-expand-lg"
	style="background: linear-gradient(to right, #574B90, #9E579D); width: 100%;">
	<div class="container-fluid">
		<a class="navbar-brand" href="/TrainViewer/index.jsp"> <img
			src="img/logo.jpg" alt="TrainViewer Icon"
			style="height: 3rem; border-radius: 50px">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#"></a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#"></a></li>
					
				<li class="nav-item">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/TrainViewer/trainGame/trainGame.jsp"
					style="color: white; font-size: 20px">Gioco del treno</a></li>
					<c:if test = "${role == 'client' }">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#" style="color: white; font-size: 20px">Chi Siamo</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#" style="color: white; font-size: 20px">Siti del gruppo</a>
				</li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#" style="color: white; font-size: 20px">Supporto</a></li>
					</c:if>
					<c:if test = "${role == 'factory' }">
         	          <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTrenoAdmin/creazioneTreno.jsp">Creazione Treno</a>
        	        </li>
        	        </c:if>
        	        <c:if test = "${role == 'conductor' }">
         	          <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTripAdmin/creazioneTrip.jsp">Creazione Viaggio</a>
        	        </li>
        				</c:if>
        				<c:if test = "${role == 'admin' }">
        	       
							<li class="nav-item">
        	        </li>
        	            <li class="nav-item" >
        	           
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/countryList.jsp">CountryList</a>
        	          
        	        </li>
        	        
        	        <li class="nav-item">
        	        </li>
        	            <li class="nav-item">
        	           
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/admin.jsp">Admin</a>
        	          
        	          <li class="nav-item" >
        	           
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/updateUserRole.jsp">Users Roles</a>
        	          
        	        </li>
        	         
  					</c:if>
			</ul>
		</div>
		        	  <a class="navbar-brand my-2 my-lg-0" aria-current="page" href="/TrainViewer/registrazioneLogin/login.jsp" style="color:white">Benvenuto, <%= user%></a>

	</div>
</nav>