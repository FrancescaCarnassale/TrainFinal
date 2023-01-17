<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="css/styles.css">
<title>TrainViewer</title>
</head>
<body>
<% 
	String user = (String)session.getAttribute("user");
if (user != null) {%>
	<jsp:include page="menuLogged.jsp"></jsp:include>
	<% 
}else{ %>
	<jsp:include page="menu.jsp"></jsp:include>
	<% 
}; %>
<div id="carouselExampleIndicators" class="carousel slide" style="margin-top:6%">
  <div class="carousel-indicators">
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
                        <p class="card-text">L’offerta è valida sui treni AV Frecciarossa, Frecciargento e sul Frecciabianca, su tutti i livelli di servizio. Puoi acquistare l’offerta fino al giorno precedente la partenza del treno.</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-winter-inMONTAGNAconFRECCE.jpg" class="card-img-top" alt="London">
                    <div class="card-body">
                        <h5 class="card-title">In montagna con le Frecce e Freccialink</h5>
                        <p class="card-text">L’inverno è il periodo perfetto per scoprire le più belle località di montagna: sai che puoi raggiungerle con le Frecce e Freccialink? Scopri i collegamenti e organizza la tua vacanza invernale!</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-we-taxi.jpg" class="card-img-top" alt="New York">
                    <div class="card-body">
                        <h5 class="card-title">Wetaxi e Trenitalia: l’integrazione che sempliﬁca il viaggio</h5>
                        <p class="card-text">Grazie alla collaborazione tra Trenitalia e Wetaxi la velocità e il comfort dei treni si unisce alla capillarità del servizio taxi per realizzare una vera e propria esperienza door-to-door.</p>
                        <a href="#" class="btn btn-primary">Scopri</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/325x350/325x350-bardonecchia-HP.jpg" class="card-img-top" alt="London">
                    <div class="card-body">
                        <h5 class="card-title">In montagna con Intercity rispetti l’ambiente e viaggi sicuro</h5>
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
                        <p class="card-text">Cortina Link è il servizio combinato treno + bus, grazie al quale Trenitalia e Dolomiti Bus ti offrono la possibilità di raggiungere Cortina d’Ampezzo con un unico biglietto direttamente dalla stazione di Calalzo.</p>
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
    
    
   <img src="https://www.trenitalia.com/content/dam/tcom/restyling/homepage/1920x410/1920x410-Reg-GUIDE-GIUNTI-12-21.jpg"" class="img-fluid w-100" alt="Immagine" style="margin: 5% 0px 5% 0px">
	
	<div style="background: linear-gradient(to right, #574B90, #9E579D);">
	
	</div>
</body>
</html>
