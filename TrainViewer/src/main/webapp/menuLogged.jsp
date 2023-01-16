<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
	String user = (String)request.getAttribute("user");
	%>
    <!-- componente HTML da mostrare se loggati -->
        	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        	  <div class="container-fluid">
        	    <a class="navbar-brand" href="#">TrainViewer</a>
        	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        	      <span class="navbar-toggler-icon"></span>
        	    </button>
        	    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        	      <ul class="navbar-nav">
        	        <li class="nav-item">
        	          <a class="nav-link active" aria-current="page" href="#"></a>
        	        </li>	
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/trainGame/trainGame.jsp">TrainGame</a>
        	        </li>
        	        <li class="nav-item">
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTrenoAdmin/creazioneTreno.jsp">CreazioneTreno</a>
        	        </li>
        	                	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTripAdmin/creazioneTrip.jsp">CreazioneTrip</a>
        	        </li>
        	        <li style="float:right"><a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/login.jsp">Benvenuto, <%= user%></a></li>
        	      </ul>
        	    </div>
        	    
        	  </div>
        	</nav>
