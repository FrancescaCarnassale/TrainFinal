<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- componente HTML da mostrare se loggati -->
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
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#" style="color: white; font-size: 20px">Chi Siamo</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#" style="color: white; font-size: 20px">Siti del gruppo</a>
				</li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#" style="color: white; font-size: 20px">Supporto</a></li>
			</ul>
		</div>
		<div class="btn-group dropstart"
			style="width: 50px; height: 50px; margin-right: 30px">
			<img src="img/user.png" type="button" class="btn dropdown-toggle"
				data-bs-toggle="dropdown" aria-expanded="false" alt="dropstart">
			<ul class="dropdown-menu">
				<li><a class="nav-link" aria-current="page"
					href="/TrainViewer/registrazioneLogin/registrazione.jsp"
					style="color: #574B90">Registrazione</a></li>
				<hr>
				<li><a class="nav-link" aria-current="page"
					href="/TrainViewer/registrazioneLogin/login.jsp"
					style="color: #574B90">Login</a></li>
			</ul>
		</div>
	</div>
</nav>
