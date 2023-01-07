//gestione dell'evento onkeydown:
function checkKeyDown(e) {
	e = e || window.event;
	switch (e.keyCode) {
		case 39: destra(); break;
		case 40: giu(); break;
		case 37: sinistra(); break;
		case 38: su(); break;
	}
	//alert ("The Unicode character code is (key down): " + e.keyCode);   
}

// gestione dell'evento onkey press:
function checkKeyPress(event) {
	var chCode = ('charCode' in event) ? event.charCode : event.keyCode;

	switch (chCode) {
		case 100: destra(); break;
		case 115: giu(); break;
		case 97: sinistra(); break;
		case 119: su(); break;
	}
	//alert ("The Unicode character code is (key press): " + chCode);   
}

var biglietto = new Audio("audio1/ka-ching.mp3");
var nemico = new Audio("audio1/kids.mp3");
Audio.prototype.rewindAndPlay = function () {
	this.currentTime = 0.0;
	this.play();
}

var username = null;
var om1 = new OggettoInMovimento(3, 0, 10, false, "nemico1");
var om2 = new OggettoInMovimento(0, 9, 10, true, "nemico4");
var om3 = new OggettoInMovimento(6, 0, 10, false, "nemico3");
var om4 = new OggettoInMovimento(0, 4, 10, true, "nemico2");
var om5 = new OggettoInMovimento(0, 14, 10, true, "nemico5");
var idInterval1;			//used in clearInterval, prevents enemies movement after game over
var idInterval2;			//null assigned in play() function
var idInterval3;			
var idInterval4;
var idInterval5;
function stopEnemies(){
	if(idInterval1 != null){
		clearInterval(idInterval1)
	}
	if(idInterval2 != null){
		clearInterval(idInterval2)
	}
	if(idInterval3 != null){
		clearInterval(idInterval3)
	}
	if(idInterval4 != null){
		clearInterval(idInterval4)
	}
	if(idInterval5 != null){
		clearInterval(idInterval5)
	}
	
	
}
function incrementaDiff(){
	if(punteggio <= 80){
		switch(punteggio){
			case 5:
				//introduci primo nemico
				idInterval1 = setInterval("om1.muovi()", 800);
				break;
			case 10:
				//introduci secondo nemico
				idInterval2 = setInterval("om2.muovi()", 800);
				break;
			case 20:
				//introduci terzo nemico nemico
				idInterval3 = setInterval("om3.muovi()", 800);
				break;
			case 30:
				
				//aumenta velocità nemico 1 e 3(nemici orizzontali)
				
				idInterval1 = setInterval("om1.muovi()", 600);
				idInterval3 = setInterval("om3.muovi()", 600);
				break;
			case 40:
				//introduci quarto nemico
				idInterval4 = setInterval("om4.muovi()", 800);
				break;
			case 50:
				//aumenta velocita' nemici verticali
				idInterval4 = setInterval("om4.muovi()", 600);
				idInterval2 = setInterval("om2.muovi()", 600);
				break;
			case 60:
				//introduci quinto nemico
				idInterval5 = setInterval("om5.muovi()", 600);
				break;
			case 80:
				//difficoltà massima
				idInterval1 = setInterval("om1.muovi()", 400);
				idInterval2 = setInterval("om2.muovi()", 400);
				idInterval3 = setInterval("om3.muovi()", 400);
				idInterval4 = setInterval("om4.muovi()", 400);
				idInterval5 = setInterval("om5.muovi()", 400);
				break;
			default:
				break;
		}
	}
}
function gameOver(){
	stopEnemies();
	while(username == null || username == "") {
		 username = prompt("Enter your username to continue");
	} 
	alert("Hello " + username + " you scored: " + punteggio);
}

var punteggio = 0;
function getPunteggio(){
	return punteggio;
}

function controllaCella(x, y) {
	controllaGameOver(x, y);
	const val = piano[x][y];
	switch (val) {
		case MURO:
			return false;
			break;
		case PILLOLA:
			biglietto.rewindAndPlay(); 
			generaOggetto(PILLOLA);
			punteggio++;
			piano[x][y] = testa;
			sposta(ominoX,ominoY,x,y);  //il treno non si allunga piu', basta spostarlo
			incrementaDiff(); 			//incrementa la difficolta' del gioco
			const abcdf = document.getElementById("punteggioUtente");
			const efgt = document.createElement(" "+ punteggio);
			abcdf.append(efgt);
			console.log(abcdf)
			return false;
			break;
		case NEMICO:
			nemico.rewindAndPlay();
			gameOver();
			alert("Hai investito un passante!");
			return false;
			break;
		default:
			if (val  >= 1 && val <= testa-1) { // toccato il serpente
				//alert("Ti sei mangiato le mani, eheheh");
				gameOver();
				return false;
			}
			 else {
				piano[x][y] = testa+1;
				return true;
			}
	}
}




function sposta(daX, daY, aX, aY) {

	if (controllaCella(aX, aY)) {

		var daSrc = "c" + daX + "_" + daY;
		var aSrc = "c" + aX + "_" + aY;

		console.log(daSrc + " " + aSrc);

		for (var i = 0; i < R; i++) {
			for (var j = 0; j < C; j++) {
				if (piano[i][j] > 0) {
					piano[i][j] = piano[i][j]-1;
					disegnaCella(i, j);
				}
			}
		}
		// cancella l'omino e disegna lo sfondo
		ominoX = aX;
		ominoY = aY;
		//mostraMatriceHTML();
		disegnaCellaSpeciale(ominoX, ominoY, omino);
	
	}
}

function su() {
	var newX = (ominoX - 1 + R) % R;
	direzione = "N";
	sposta(ominoX, ominoY, newX, ominoY);
}
function giu() {
	var newX = (ominoX + 1 + R) % R;
	direzione = "S";
	sposta(ominoX, ominoY, newX, ominoY);
}

function sinistra() {
	var newY = (ominoY - 1 + C) % C;
	direzione = "W";
	sposta(ominoX, ominoY, ominoX, newY);
}

function destra() {
	var newY = (ominoY + 1 + C) % C;
	direzione = "E";
	sposta(ominoX, ominoY, ominoX, newY);
}

function controllaGameOver(x, y) {
	var check = true;

	check = check && (piano[(ominoX - 1 + R) % R][y] > 0||piano[(ominoX - 1 + R) % R][y] ==NEMICO); // su
	check = check && (piano[(ominoX + 1 + R) % R][y] > 0||piano[(ominoX + 1 + R) % R][y] ==NEMICO); // giu
	check = check && (piano[x][(ominoY - 1 + C) % C] > 0||piano[x][(ominoY - 1 + C) % C] ==NEMICO); // sinistra	
	check = check && (piano[x][(ominoY + 1 + C) % C] > 0||piano[x][(ominoY + 1 + C) % C] ==NEMICO); // destra		
	check= check &&  (piano[ominoX][ominoY]==NEMICO);
	if (check) {
		//alert("Game over!" + punteggio);
		gameOver();
	}
}

function controllaGameOverNemico(x,y) {
	var check = true;

	check= check &&  (piano[x][y] > 0);
	if (check) {
		//alert("Game over!" + punteggio);
		gameOver();
	}
}

// costruttore: 
function OggettoInMovimento(x, y, punti, direzione, nome) {
	this.punti = punti;		// se l'oggetto dasse punti ogni volta che viene raccolto (tbd)
	this.dir = direzione; 	// verticale true, orizzontale false
	this.incrementa = true; //true omino si muove verso destra, arrivato a fine riga diventa false e andra' verso sinstra
	this.x = x;
	this.y = y;
	this.nome = nome;
}


OggettoInMovimento.prototype.muovi = function () {

	//var id = "c" + this.x + "_" + this.y; 
	//var e = document.getElementById(id).src = pathImg + SFONDO + ".jpg" ; 	
	piano[this.x][this.y] = SFONDO;
	disegnaCella(this.x, this.y);
	if (this.dir) {
		if (this.incrementa) { this.x = this.x + 1; }
		else { this.x = this.x - 1; }
		if (this.x == R - 1) { this.incrementa = false; }
		if (this.x == 0) { this.incrementa = true; }
	} else {
		if (this.incrementa) { this.y = this.y + 1; }
		else { this.y = this.y - 1; }
		if (this.y == C - 1) { this.incrementa = false; }
		if (this.y == 0) { this.incrementa = true; }
	}
	if(piano[this.x][this.y] == PILLOLA){
		generaOggetto(PILLOLA);
	}

	controllaGameOverNemico(this.x,this.y);
	piano[this.x][this.y] = NEMICO;
	disegnaCella(this.x, this.y);

	//mostraMatriceHTML();
	var id = "c" + this.x + "_" + this.y;
}


