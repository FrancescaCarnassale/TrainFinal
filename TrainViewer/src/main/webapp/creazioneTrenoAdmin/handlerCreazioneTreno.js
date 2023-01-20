
function handleSubmit() {
	var form = document.getElementById('creazioneTreno-form');

  const produttore = form.elements.produttore.value;
  const serialNumber = form.elements.serialNumber.value;

  // If controls are passed , send data to server
  const data = { produttore, serialNumber};
}