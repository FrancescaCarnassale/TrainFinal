<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>

<%
Strategy db = new StrategyDB();
Collection<?> scores = (Collection<?>) db.getGameData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="../css/styles.css">
<title>TrainGame</title>
</head>
<body id="b01" class="bg-dark" onkeydown="checkKeyDown(event);"
	onkeypress="checkKeyPress(event)">
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<input type="button" onclick="play()" value="Play" class="btnPlay"></input>
		  <audio id="myAudio" src="audio1/videoplayback.mp3" loop></audio>
		<br>
		<br>
		<div id="pianoGioco"></div>
	</div>
	
	<div class="container">
	
		<h1 class="py-4 text-center text-white bg-dark">Best Scores</h1>
		<form action="GameServlet" method="GET">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">Username</th>
						<th scope="col">Score</th>
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
						<td><%=gs.getUser()%></td>		
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
	<br>
	<br>
	<p id="posizioneOmino"></p>
	<p id="messaggioDebug"></p>
	
	<script type="text/javascript" src="js/mappa.js"></script>
	<script type="text/javascript" src="js/movimento.js"></script>
	
</body>
</html>