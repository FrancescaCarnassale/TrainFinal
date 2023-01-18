<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.strategy.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Strategy db = new StrategyDB();
Collection<?> trains = (Collection<?>) db.getAllTrains();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
   <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
<title>TrainViewer</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	
	
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" style="margin-top:6%">
  <div class="carousel-indicators">
  <div class="carousel-caption" style="position: absolute;top: 50%; left: 52%;transform: translate(-50%, -50%);color: white;text-align: center; ">
    <div align="center" style="position: absolute; display: inline-block; bottom:50px; left:-80%; width: 1080px;">
		<form id="creazioneTrip-form" onsubmit="return handleSubmit()"
			action="/TrainViewer/CreazioneTripServlet" method="POST">
			<select name="idTrain" id="idTrain" style="width: 150px; height:30px">
				<%
				if (trains != null && trains.size() != 0) {
					Iterator<?> it = trains.iterator();
					while (it.hasNext()) {
						Train c = (Train) it.next();
				%>
				<option value="<%=c.getIdTrain()%>"><%=c.getBrand()%>
					<%=c.getSerialNumber()%></option>
				<%
				}

				}
				%>
				<%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				Date today = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(today);
				calendar.add(Calendar.MINUTE, 30);
				Date later = calendar.getTime();
				%>
			</select>
				<input type="text" id="departure" name="departure" placeholder="Partenza" style="width: 400px; height: 50px; border: 3px solid #9E579D;">
                <input type="text" id="arrive"name="arrive" placeholder="Arrivo" style="width: 400px; border: 3px solid #9E579D; height: 50px;">
				<input type="datetime-local" id="start" name="start"value="<%=sdf.format(today)%>" style="width: 650px; border: 3px solid #9E579D;">
				<input type="datetime-local" id="end" name="end"value="<%=sdf.format(later)%>" style="width: 650px; border: 3px solid #9E579D;"> 
				<input type="submit" value="CREA TRIP!" style="width:400px; background: linear-gradient(to right, #574B90, #9E579D); color: white; height:40px">
		</form>
		<c:set var="msg" value="${requestScope.msg}" />
		<script>
			if ("${msg}" != "")
				alert("${msg}");
		</script>
	</div>
	</div>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/1920x580/1920x580-DOLCEZZA23-CRUSCOTTO-1.jpg" class="d-block w-100 img-fluid" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/768x726/1920x580-FR-Milano-Roma-Coll_90_02-23.jpg" class="d-block w-100 img-fluid" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/1920x580/1920x580-Me-you--08-22.jpg" class="d-block w-100 img-fluid" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/1920x580/1920x580-ICN-Servizi-06-2022.jpg" class="d-block w-100 img-fluid" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden"></span>
</button>
<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden"></span>
</button>
</div>

<div class="TitlePricing" style="margin:4% 14%">
    <h2>Offerte e Servizi</h2>
    </div>
    
     <div class="container">
        <div class="row g-4">
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-AR-in-Giornata-venezia%20st.jpg" class="card-img-top" alt="A Street in Europe">
                    <div class="card-body">
                        <h5 class="card-title">Speciale A/R in giornata -70%</h5>
                        <p class="card-text">L'offerta è valida sui treni AV Frecciarossa, Frecciargento e sul Frecciabianca, su tutti i livelli di servizio. Puoi acquistare l'offerta fino al giorno precedente la partenza del treno.</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-winter-inMONTAGNAconFRECCE.jpg" class="card-img-top" alt="London">
                    <div class="card-body">
                        <h5 class="card-title">In montagna con le Frecce e Freccialink</h5>
                        <p class="card-text">L'inverno è il periodo perfetto per scoprire le più belle località di montagna: sai che puoi raggiungerle con le Frecce e Freccialink? Scopri i collegamenti e organizza la tua vacanza invernale!</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-we-taxi.jpg" class="card-img-top" alt="New York">
                    <div class="card-body">
                        <h5 class="card-title">Wetaxi e Trenitalia: l'integrazione che semplifica il viaggio</h5>
                        <p class="card-text">Grazie alla collaborazione tra Trenitalia e Wetaxi la velocità e il comfort dei treni si unisce alla capillarità del servizio taxi per realizzare una vera e propria esperienza door-to-door.</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-bardonecchia-HP.jpg" class="card-img-top" alt="London">
                    <div class="card-body">
                        <h5 class="card-title">In montagna con Intercity rispetti l'ambiente e viaggi sicuro</h5>
                        <p class="card-text">Scegliere il treno è il primo passo per una vera vacanza rispettosa della natura e dei luoghi da visitare e per tutti gli appassionati ciclisti, che siano amatori o professionisti, con Intercity puoi anche trasportare la tua bicicletta montata.</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-Reg-VENETO-CORTINA-LINK.jpg" class="card-img-top" alt="London">
                    <div class="card-body">
                        <h5 class="card-title">Cortina Link</h5>
                        <p class="card-text">Cortina Link è il servizio combinato treno + bus, grazie al quale Trenitalia e Dolomiti Bus ti offrono la possibilità di raggiungere Cortina d'Ampezzo con un unico biglietto direttamente dalla stazione di Calalzo.</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-Reg-VENETO-GARDA-LINK.jpg" class="card-img-top" alt="London">
                    <div class="card-body">
                        <h5 class="card-title">Garda Link</h5>
                        <p class="card-text">Garda Link è il servizio combinato treno + bus che, a partire dal 13 giugno, collega la stazione ferroviaria di Verona Porta Nuova ad alcune delle località più rinomate del Lago di Garda</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
<div id="carouselExampleIndicators" class="carousel slide">
  <div class="carousel-inner">
    <div class="col-md-12" style="padding-bottom: 6rem;">
         <div class="d-flex align-items-center justify-content-center img-overlay">
   			<img src="https://knowledge.wharton.upenn.edu/wp-content/uploads/2019/01/country-flags-rankings.jpg" class="img-fluid w-100" alt="Immagine" style="margin: 5% 0px 5% 0px; height: 28rem;">
   			  <div class="bg-black" style="width:100%;height:28rem; position:absolute;opacity:0.5;z-index:0;"></div>
            <h2 class="position-absolute" style="margin-bottom: 10%; color:white">Scopri i paesi in cui puoi viaggiare</h2>
            <button type="button" class="position-absolute btn btn-dark btn-lg" onClick="location.href=#">Scopri di più</button>
        </div>
      </div>
    </div>
</div>

	
	<div style="background: linear-gradient(to right, #574B90, #9E579D); padding-bottom:30px; border-top-left-radius: 20px;border-top-right-radius: 20px;">
	<div align="left" style="margin-left: 10%;">
	      <img src="img/logo.jpg" class="" alt="logo" style="margin-top:50px; margin-bottom:50px; width:25rem; border-radius:10px;">
	      </div>
	 <div class="container d-flex flex-row" >
  <div class="col-4 mr-5">
    <a href="#" class ="FinalText"><strong>Contatti e Assistenza</strong></a>
    <a href="#" class ="FinalText2">Call center 892021</a>
    <a href="#" class ="FinalText2">Chat Online</a>
    <a href="#" class ="FinalText2">Guida all'acquisto</a>
    <a href="#" class ="FinalText2">FAQ</a>
    <a href="#" class ="FinalText2">Reclami</a>
  </div>
  <div class="col-4 mr-5">
    <a href="#" class ="FinalText"><strong>La sostenibilità</strong></a>
    <a href="#" class ="FinalText"><strong>Infomobilità</strong></a>
    <a href="#" class ="FinalText2">In caso di sciopero</a>
    <a href="#" class ="FinalText2">Viaggiatreno</a>
    <a href="#" class ="FinalText"><strong>La Freccia Mag</strong></a>
    <a href="#" class ="FinalText"><strong>Lavora con noi</strong></a>
  </div>
  <div class="col-4">
<p style="color:white; font-size: 30px;text-decoration: none; margin-bottom: 20px;display: block;"><strong>Seguici su</strong></p>
    <div class="container d-flex">
        <a href="#" style="margin-right: 10px;" ><img src="https://cdn-icons-png.flaticon.com/128/1384/1384005.png"  alt="Facebook" style="width:35px; "></a>
        <a href="#" style="margin-right: 10px;"><img src="https://cdn-icons-png.flaticon.com/128/1384/1384015.png" alt="Instagram" style="width:35px"></a>
        <a href="#"style="margin-right: 10px;"><img src="https://cdn-icons-png.flaticon.com/128/2168/2168336.png" alt="Twitter" style="width:35px"></a>
        <a href="#"style="margin-right: 10px;"><img src="https://cdn-icons-png.flaticon.com/128/1384/1384012.png" alt="YouTube" style="width:35px"></a>
    </div><div class="container d-flex justify-content-center">
</div>    <a href="#" class ="FinalText">Scarica App</a>
  </div>
</div>
	</div>
	
	
</body>
</html>

