/**Handler to check if registration is correct */
function handleSubmit() {
	var form = document.getElementById('registration-form');

  const name = form.elements.name.value;
  const email = form.elements.email.value;
  const password = form.elements.password.value;
  // Controls
  if (name.length < 4) {
    alert("Il nome deve essere lungo almeno 4 caratteri");
    return false;;
  }

  if (!(/^\w+([.-]?\w+)@\w+([.-]?\w+)(.\w{2,3})+$/.test(email))){
       alert("L'indirizzo email che hai inserito non e' valido");
       return false;
    }

  if (password.length < 8) {
    alert("La password deve essere lunga almeno 8 caratteri");
    return false;
  }
  // If controls are passed , send data to server
  const data = { name, email, password };
}