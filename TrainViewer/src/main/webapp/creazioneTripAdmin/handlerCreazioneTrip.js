
function handleSubmit() {
	var form = document.getElementById('creazioneTrip-form');

  const produttore = form.elements.produttore.value;
  const serialNumber = form.elements.serialNumber.value;

  // Se i controlli sono superati, inviare i dati al server
  const data = { produttore, serialNumber};
}