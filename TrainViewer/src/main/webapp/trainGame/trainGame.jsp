<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*"%>

<%
Strategy db = new StrategyDB();
Collection<?> scores = (Collection<?>) db.getGameData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet" href="css/styles.css">
<title>TrainGame</title>
</head>
<body id="b01" class="bg-dark" onkeydown="checkKeyDown(event);"
	onkeypress="checkKeyPress(event)">
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container">
		<input type="button" onclick="play()" value="Play" class="btnPlay"></input>
		  <audio id="myAudio" src="audio1/videoplayback.mp3" loop></audio>
		<br>
		<br>
		<div id="pianoGioco"></div>
	</div>
	
	<div class="container">
		<div id="counter"></div>
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
						<td><%=gs.getUser().getUsername()%></td>		
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