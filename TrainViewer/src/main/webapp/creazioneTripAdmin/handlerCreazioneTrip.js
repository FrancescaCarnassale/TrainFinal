function handleSubmit() {
	var form = document.getElementById('creazioneTrip-form');
	const date = new Date();
  const idTrain = form.elements.idTrain.value;
  const departure = form.elements.departure.value;
  const arrive = form.elements.arrive.value;
  const start=form.elements.start.value;
  const end=form.elements.end.value;
	// Create Date objects from the input values
	const startDate = new Date(start);
	const endDate = new Date(end);
 //Controls
  if(startDate.getTime() >= endDate.getTime()){
	alert("La partenza deve essere successiva all'arrivo!");
    return false;
  }
  if(departure===arrive){
	  alert("La partenza non può essere uguale all'arrivo!");
    	return false;
  }
     // If controls are passed , send data to server
  const data = { idTrain, departure,arrive,start,end};
}