// const textToType = "AGENDA TU CITA CON NOSOTROS!";
// Function to type the text
function typeText(element, text, delay = 0) {
  setTimeout(() => {
    for (let i = 0; i <= text.length; i++) {
      setTimeout(() => {
        element.textContent = text.slice(0, i);
        // La condicion es para que el cursor aparezca solo cuando ya acabo de escribir 
        // if (i === text.length && text != "AGENDA TU CITA CON NOSOTROS!") {
          element.insertAdjacentHTML('beforeend', '<span id="cursor"></span>');
        // }
        // Condicion en caso de que las secciones (exceptuando la landing) queden muy poco serias o raras con el cursor parpadeando al final (como si llama mucho la atencion xd)
        // if(i === text.length && text != "AGENDA TU CITA CON NOSOTROS!"){
        //   element.innerHTML = text;
        // }
      }, i * 100); // Ajustar la velocidad de tipeado aquí (100 milisegundos)
    }
  }, delay);
}

document.addEventListener('DOMContentLoaded', (event) => {
  // Encuentra todos los elementos que puedan tener el texto a tipear
  const elementsToType = document.querySelectorAll('[data-text]');

  elementsToType.forEach(element => {
    const textToType = element.getAttribute('data-text');
    if (textToType) {
      typeText(element, textToType);
    }
  });
});

// Find the element to type into
// const typingHeading = document.getElementById('subMainTitle');

// Start typing
// typeText(typingHeading, textToType);


let signUp = document.getElementById("signUp");
let signIn = document.getElementById("signIn");
let title = document.getElementById("title");
let nameInput = document.getElementById("nameInput");
