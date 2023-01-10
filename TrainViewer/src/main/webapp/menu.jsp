<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="admin" value="${requestScope.admin}" />
<c:choose>
  <c:when test="${admin == false}">
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
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/registrazione.jsp">Registrazione</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/login.jsp">Login</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTrenoAdmin/creazioneTreno.jsp">CreazioneTreno</a>
        	        </li>
        	      </ul>
        	    </div>
        	  </div>
        	</nav>
  </c:when>
  <c:when test="${admin == true}">
    <!-- componente HTML da mostrare siamo admin -->
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
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/countryList.jsp">CountryList</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/admin.jsp">ApproveAliases Admin</a>
        	        </li> 	
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/trainGame/trainGame.jsp">TrainGame</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/registrazione.jsp">Registrazione</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/login.jsp">Login</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTrenoAdmin/creazioneTreno.jsp">CreazioneTreno</a>
        	        </li>
        	      </ul>
        	    </div>
        	  </div>
        	</nav>
  </c:when>
    <c:otherwise>
    <!-- componente HTML da mostrare negli altri casi -->
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
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/countryList.jsp">CountryList</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/admin.jsp">ApproveAliases Admin</a>
        	        </li> 	
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/trainGame/trainGame.jsp">TrainGame</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/registrazione.jsp">Registrazione</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/registrazioneLogin/login.jsp">Login</a>
        	        </li>
        	        <li class="nav-item">
        	          <a class="nav-link" aria-current="page" href="/TrainViewer/creazioneTrenoAdmin/creazioneTreno.jsp">CreazioneTreno</a>
        	        </li>
        	      </ul>
        	    </div>
        	  </div>
        	</nav>
  </c:otherwise>
</c:choose>

