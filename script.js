
function startTravel(){
    document.getElementById('mainMoment').style.overflow = 'scroll';

    let serviciosContainer = document.getElementById('serviciosLandingContainer');
    serviciosContainer.scrollIntoView({ behavior: 'smooth' });

    let startTravel = document.getElementById('startTravel');
    startTravel.style.display = "none";  
}

// Obtenemos todos los íconos
let icons = document.querySelectorAll('.columna i');

// Agregamos un evento de clic a cada ícono
icons.forEach(function(icon) {
    icon.addEventListener('click', function() {
        // Verificamos cuál ícono fue clickeado y realizamos las acciones correspondientes
        if (icon.classList.contains('ico1')) {
            // Ocultamos el ícono 1 y mostramos el ícono 2
            icon.style.display = 'none';
            document.querySelector('.ico2').style.display = 'block';
        } else if (icon.classList.contains('ico2')) {
            // Ocultamos el ícono 2 y mostramos el ícono 1
            icon.style.display = 'none';
            document.querySelector('.ico1').style.display = 'block';
        } else if (icon.classList.contains('ico3')) {
            // Ocultamos el ícono 3 y mostramos el ícono 4
            icon.style.display = 'none';
            document.querySelector('.ico4').style.display = 'block';
        } else if (icon.classList.contains('ico4')) {
            // Ocultamos el ícono 4 y mostramos el ícono 3
            icon.style.display = 'none';
            document.querySelector('.ico3').style.display = 'block';
        }
    });
});



const textToType = "AGENDA TU CITA CON NOSOTROS!";

// Function to type the text
function typeText(element, text, delay = 0) {
    setTimeout(() => {
      for (let i = 0; i <= text.length; i++) {
        setTimeout(() => {
          element.textContent = text.slice(0, i);
          if (i === text.length) {
            element.insertAdjacentHTML('beforeend', '<span id="cursor"></span>');
          }
        }, i * 100); // Ajustar la velocidad de tipeado aquí (100 milisegundos)
      }
    }, delay);
  }

// Find the element to type into
const typingHeading = document.getElementById('subMainTitle');

// Start typing
typeText(typingHeading, textToType);
