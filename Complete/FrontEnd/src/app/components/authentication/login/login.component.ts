import { Component } from '@angular/core';
import { ClienteService } from './../../../services/clientes.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userName!: string;
  password!: string;

  constructor(private clienteService: ClienteService) {}

  login() {
    this.clienteService.verificarCredenciales(this.userName, this.password).subscribe(
      (resultado: any) => {
        if (resultado) {
          // Login exitoso, navegar a la página principal o dashboard
          console.log("Login exitoso");
        } else {
          // Credenciales incorrectas, mostrar mensaje de error
          console.log("Credenciales incorrectas");
        }
      },
      (error) => {
        alert("Error al verificar credenciales");
      }
    );
  }
}
