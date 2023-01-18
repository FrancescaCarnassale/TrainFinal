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
	<div id="loader" style="align-items: center; justify-content: center; display: flex; flex-direction:row; padding-top: 10%">
			<div style="align-items: center; display: flex; flex-direction: column;">
		  		<img src="https://thumbs.gfycat.com/InferiorDecentAsianporcupine-max-1mb.gif" style="padding-left: 5rem; width: 25rem" alt="Loading...">
		  		<h3 style="color:black; font-size:3rem">Loading...</h3>
			</div>
		</div>
	<div id="outerContainer" style="background-color:white">
			
			
		<div class="container" id="container-game">
			<input id="btnPlay" type="button" onclick="play()" value="Play" class="btnPlay"></input>
			<audio id="myAudio" src="audio1/videoplayback.mp3" loop></audio>
			<br> <br>
			<div id="pianoGioco"></div>
		</div>

		<div class="container bg-dark" id="container-score" style="background: linear-gradient(to right, #574B90, #9E579D);">
			<div id="punteggio" name="punteggio"></div>
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
     <!-- 
		</div>
            <div class="centered-flex" style="position:absolute; bottom:20%; left:45%">          
                <button onClick="location.href='/TrainViewer/index.jsp" style="background-color: #1a73e8;color: white;box-shadow: 0 4px 0 #185abc;border: none;display: block; font-size: .875rem;font-weight: 500;height: 36px;margin: 12px;min-width: 200px;padding: 0px 24px;" id="title-start-btn" class="btn primary-btn" dir="auto">HomePage</button>
                -->	
              
			<a href= "/TrainViewer/leaderboardController/updateScore">Aggiorna il tuo Punteggio!!</a>
            </div>   
             	
	</div>
	<br>
	<br>
	<p id="posizioneOmino"></p>
	<p id="messaggioDebug"></p>

	<script type="text/javascript" src="js/mappa.js"></script>
	<script type="text/javascript" src="js/movimento.js"></script>
	
</body>
<% 
}else{ %>
	<jsp:include page="/registrazioneLogin/login.jsp"></jsp:include>
	<% 
}; %>
</html>