import { Component } from '@angular/core';
import { ClienteService } from './../../../services/clientes.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'
import { AuthService } from '../../../auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 // userName!: string;
 // password!: string;

 // constructor(private clienteService: ClienteService, private router: Router) {}

 // login() {/*
    /*this.clienteService.findClienteByCredentials(this.userName, this.password).subscribe({
      next: (resultado: any) => {
        if (resultado) {
          console.log("Login exitoso");
          this.router.navigate(['/clientes']);
        } else {
          Swal.fire({
            title: 'Error!',
            text: 'Usuario y/o contraseña incorrectos, intentelo nuevamente.',
            icon: 'error',
            confirmButtonText: 'Aceptar'
          });
          console.log("Credenciales incorrectas");
        }
      },
      error: (error: any) => {
        console.error("Error al verificar credenciales", error);
        alert("Error al verificar credenciales");
      }
    });*/
  username: string = '';
  password: string = '';
  error: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.username, this.password).subscribe({
      next: (user) => {
        alert('Login exitoso :)');
        Swal.fire({
          icon: "success",
          title: "Login Exitoso, bienvenido!" + user.role,
          showConfirmButton: false,
          timer: 2000
        });
        // Redireccionar a la página de inicio o dashboard, por ejemplo
        this.router.navigate(['/Servicios']);
      },
      error: (error) => {
        Swal.fire({
          icon: "error",
          title: "Login Fallido...",
          text: "Al parecer ingresaste mal tus credenciales!, intentalo nuevamente."
        });
        // console.error('Error durante el login', error);
      }
    });
  }
}
