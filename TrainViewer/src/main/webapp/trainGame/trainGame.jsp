<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>

<%
Strategy db = new StrategyDB();
Collection<?> scores = (Collection<?>)db.getGameData();
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
<script>
    window.onload = function() {
        var div = document.getElementById("outerContainer");
        div.style.display = "none";
        setTimeout(function(){ 
            div.style.display = "block";
        }, 1000);
    };
</script>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
   <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
   <link href="https://fonts.googleapis.com/css?family=Google+Sans:medium" rel="stylesheet">
<!-- CSS only -->
<link rel="stylesheet" href="css/styles_game.css">
<title>Game</title>
</head>
<% 
        	String user = (String)session.getAttribute("user");
if (user != null) {%>
<body id="b01" class="bg-white" onkeydown="checkKeyDown(event);"
	onkeypress="checkKeyPress(event)">
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	
	<div id="start-page" style="background-color: #ceead6; height: 100vh"
		class="page full-page title-bg">
		<img class="title-image title-image-left title-image-top"
			style="position: absolute"
			src="https://snake.googlemaps.com/static/img/home/upper_left.png">
		<img class="title-image title-image-left title-image-ycenter"
			style="position: absolute; bottom: 25%"
			src="https://snake.googlemaps.com/static/img/home/mid_left.png">
		<img class="title-image title-image-right title-image-ycenter"
			style="position: absolute; bottom: 25%; right: 0px;"
			src="https://snake.googlemaps.com/static/img/home/mid_right.png">
		<img class="title-image title-image-train-left"
			style="position: absolute; bottom: 46%"
			src="https://snake.googlemaps.com/static/img/train/tokyo-full.png">
		<img class="title-image title-image-train-right"
			style="position: absolute; top: 15%; right: 0px; transform: rotate(180deg); transform: scaleX(-1);"
			src="https://snake.googlemaps.com/static/img/train/world-full.png">
		<img class="title-image title-image-person-3"
			style="position: absolute; bottom: 10%; right: 10%"
			src="https://snake.googlemaps.com/static/img/person/Pegman_1.png">
		<img class="title-image title-image-person-1"
			style="position: absolute; top: 28%; left: 59%"
			src="https://snake.googlemaps.com/static/img/person/Pegman_2.png">
		<img class="title-image title-image-person-2"
			style="position: absolute; bottom: 75%; right: 56%"
			src="https://snake.googlemaps.com/static/img/person/Pegman_3.png">
		<div class="div-container">
			<div class="div-title">
				<h1 class="title pixel-font" style="font-size: 6rem; color: #9E579D">Snake</h1>
			</div>
			<div class="container" id="container-game">
			
				<input id="btnPlay" style="position:relative; left: 200px;background-color: #9E579D; color: white; box-shadow: 0 4px 0 #9E579D; border: none; display: block; font-size: .875rem; font-weight: 500; height: 36px; margin: 12px; min-width: 200px; padding: 0px 30px;" type="button" onclick="play()" value="Play" class="btnPlay"></input>
				<audio id="myAudio" src="audio1/trainTankSountrack.mp3" loop></audio>
				<br> <br>
				<div id="pianoGioco" ></div>
			</div>
		<div class="container bg-dark" id="container-score" style="background: linear-gradient(to right, #574B90, #9E579D);">
			<div id="punteggio" name="punteggio" ></div><br>
			<a id="paginaUpdate" href= "/TrainViewer/leaderboardController/updateScore"></a> 
           
		
			<h1 class="py-4 text-center text-white bg-dark" id="title-score" style="background: linear-gradient(to right, #574B90, #9E579D);">Best
				Scores</h1>
			<form action="GameServlet" method="GET">
				<table class="table table-dark table-striped" id="score-table" >
					<thead>
						<tr>
							<th scope="col" style="background: linear-gradient(to right, #574B90, #9E579D);">Username</th>
							<th scope="col" style="background: linear-gradient(to right, #574B90, #9E579D);">Score</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<%
							if (scores != null && scores.size() != 0) {
								Iterator<?> it = scores.iterator();
								while (it.hasNext()) {
									Leaderboard gs = (Leaderboard) it.next();
							%>
							<td><%=gs.getUser().getName()%></td>
							<td><%=gs.getScore()%></td>
							
						</tr>
						<%
						}
						}
						%>
					</tbody>
				</table>

			</form>
     
              
			</div>   
		</div>
		
	
             	
		
	</div>


	
	
	<script type="text/javascript" src="js/mappa.js"></script>
	<script type="text/javascript" src="js/movimento.js"></script>
	
</body>
<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
</html>