// function validatedForm() {
    
//     /*let timerInterval;
//     Swal.fire({
//         title: "Registro exitoso!",
//         html: "Redirigiendo a lista de clientes.",
//         icon: "success",
//         timer: 2000,
//         timerProgressBar: true,
//         didOpen: () => {
//             Swal.showLoading();
//             const timer = Swal.getPopup().querySelector("b");
//             timerInterval = setInterval(() => {
//                 timer.textContent = `${Swal.getTimerLeft()}`;
//             }, 100);
//         },
//         willClose: () => {
//             clearInterval(timerInterval);
//         }
//     }).then((result) => {
//         /* Read more about handling dismissals below *//*
//         if (result.dismiss === Swal.DismissReason.timer) {
//             console.log("I was closed by the timer");
//         }
//     });*/
// }

function validatedForm() {
    let timerInterval;
    Swal.fire({
        title: "Registro exitoso!",
        html: "Redirigiendo a lista de clientes.",
        icon: "success",
        timer: 2000,
        timerProgressBar: true,
        didOpen: () => {
            Swal.showLoading();
            const b = Swal.getHtmlContainer().querySelector('b');
            timerInterval = setInterval(() => {
              b.textContent = Swal.getTimerLeft();
            }, 100);
        },
        willClose: () => {
            clearInterval(timerInterval);
        }
    }).then((result) => {
        /* Read more about handling dismissals below */
        if (result.dismiss === Swal.DismissReason.timer) {
            console.log("La alerta se cerró por el temporizador");
            // Coloca aquí la redirección
            window.location.href = "/clientes/all"; // Ajusta esto a tu ruta deseada
        }
    });
}
