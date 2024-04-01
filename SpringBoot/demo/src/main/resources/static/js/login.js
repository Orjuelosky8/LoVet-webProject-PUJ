let userName = document.getElementById("userNameLogin");
let mail = document.getElementById("emailLogin");
let pass = document.getElementById("passwordLogin");


// // or via CommonJS
// const Swal = require('sweetalert2')

// document.getElementById("msgIncorrectLogin-p").addEventListener("click", (event) => {
//     alert("hola")
// })


document.addEventListener('DOMContentLoaded', (event) => {
    const errorMessage = document.getElementById('msgIncorrectLogin-p');
    if (errorMessage && errorMessage.textContent.trim() !== '') {
        // // Aquí puedes mostrar el mensaje como prefieras, por ejemplo, usando alert o modificando el DOM para mostrarlo en la página
        // alert(errorMessage.textContent);
        // // O mostrar el div y aplicarle estilos
        // errorMessage.style.display = 'block';
        // errorMessage.style.color = 'red'; // Agrega más estilos según necesites
        Swal.fire({
            title: 'Error!',
            text: 'Usuario y/o contraseña incorrectos, intentelo nuevamente.',
            icon: 'error',
            confirmButtonText: 'Aceptar'
        });
    }
});

