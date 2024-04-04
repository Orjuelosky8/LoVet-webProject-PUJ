import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/clientes.service';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {
  cliente: Cliente = {
    userName: '',
    password: '',
    correoElectronico: '',
    nombres: '',
    apellidos: '',
    telefono: '',
    telefonoAux: ''
  };
  esNuevo = true;

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const clienteId = this.route.snapshot.paramMap.get('id');
    if (clienteId) {
      this.esNuevo = false;
      this.clienteService.obtenerClientes().subscribe(clientes => {
        this.cliente = clientes.find(c => c.id === +clienteId) || this.cliente;
      });
    }
  }

  guardarCliente(): void {
    if (this.esNuevo) {
      this.clienteService.agregarCliente(this.cliente).subscribe(() => {
        this.router.navigate(['/clientes']);
      });
    } else {
      this.clienteService.actualizarCliente(this.cliente).subscribe(() => {
        this.router.navigate(['/clientes']);
      });
    }
  }

}
