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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
   <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
   <link href="https://fonts.googleapis.com/css?family=Google+Sans:medium" rel="stylesheet">
<!-- CSS only -->
<link rel="stylesheet" href="css/styles_game.css">
<title>TrainGame</title>
</head>

 <body onkeydown="checkKeyDown(event);" onkeypress="checkKeyPress(event)">
	<jsp:include page="../menu.jsp"></jsp:include>
	
 <div id="start-page" style="background-color: #ceead6; height:100vh" class="page full-page title-bg">         
                    <img class="title-image title-image-left title-image-top" style="position:absolute" src="https://snake.googlemaps.com/static/img/home/upper_left.png">      
                    <img class="title-image title-image-left title-image-ycenter" style="position:absolute; bottom: 25%" src="https://snake.googlemaps.com/static/img/home/mid_left.png">       
                    <img class="title-image title-image-right title-image-ycenter" style="position:absolute; bottom:25%; right: 0px;" src="https://snake.googlemaps.com/static/img/home/mid_right.png">       
                    <img class="title-image title-image-train-left" style="position:absolute; bottom: 46%" src="https://snake.googlemaps.com/static/img/train/tokyo-full.png">       
                    <img class="title-image title-image-train-right" style="position:absolute; top: 15%; right: 0px; transform: rotate(180deg); transform: scaleX(-1);" src="https://snake.googlemaps.com/static/img/train/world-full.png">      
                     <img class="title-image title-image-person-3" style="position:absolute; bottom: 10%; right: 10%" src="https://snake.googlemaps.com/static/img/person/Pegman_1.png">   
                     <img class="title-image title-image-person-1" style="position:absolute; top:28%; left:59%" src="https://snake.googlemaps.com/static/img/person/Pegman_2.png">           
                      <img class="title-image title-image-person-2"style="position:absolute; bottom:75%; right:56%" src="https://snake.googlemaps.com/static/img/person/Pegman_3.png">     
                     <div class="centered-flex title-container" style="position:absolute; top:20%; left:45%">         
                     <div class="title-block">                   
                         <h1 class="title pixel-font" style="font-size: 6rem; color:#9E579D">Snake</h1>        
                          </div>         
                            </div>    
                            <div class="centered-flex" style="position:absolute; bottom:20%; left:45%">          
                             <button onClick="location.href='/TrainViewer/trainGame/Game.jsp'" style="background-color: #9E579D;color: white;box-shadow: 0 4px 0 #9E579D;border: none;display: block; font-size: .875rem;font-weight: 500;height: 36px;margin: 12px;min-width: 200px;padding: 0px 24px;" id="title-start-btn" class="btn primary-btn" dir="auto">Inizia</button>
                               </div>   
                                   </div>
</body>

</html>