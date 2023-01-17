<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
	String user = (String)session.getAttribute("user");
	String role = (String)session.getAttribute("role");
	%>
	 <c:set var = "role" scope = "session" value = "${role}"/>
    <!-- componente HTML da mostrare se loggati -->
        	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        	  <div class="container-fluid">
        	    <a class="navbar-brand" href="/TrainViewer">TrainViewer</a>
        	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        	      <span class="navbar-toggler-icon"></span>
        	    </button>
        	    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        	      <ul class="navbar-nav">
        	        <li class="nav-item">
        	          <a class="nav-link active" aria-current="page" href="#"></a>
        	        </li>

				<li class="nav-item"></li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#">Prenota il Biglietto</a></li>

				<li class="nav-item">
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/trainGame/trainGame.jsp">Gioco del treno</a>
        	        </li>
        	           
        	       <c:if test = "${role == 'train factory' }">
        	        <li class="nav-item">
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTrenoAdmin/creazioneTreno.jsp">CreazioneTreno</a>
        	        </li>
        	          </c:if>
        	          
        	          
        	          
        	          <c:if test = "${role == 'train manager' }">
        	         <li class="nav-item">
        	        </li>
         	          <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTripAdmin/creazioneTrip.jsp">CreazioneTrip</a>
        	         
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
        	         
  					</c:if>
        	      

        	       </ul>
        	    </div>
        	  </div>
        	  
        	  <a class="navbar-brand my-2 my-lg-0" aria-current="page" href="/TrainViewer/registrazioneLogin/login.jsp">Benvenuto, <%= user%></a>
        	      
        	</nav>

