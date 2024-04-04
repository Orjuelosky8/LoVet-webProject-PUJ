import { Component, OnInit } from '@angular/core';
import { ClienteService } from './../../../services/clientes.service';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrls: ['./lista-clientes.component.css']
})
export class ListaClientesComponent implements OnInit {
  clientesList: Cliente[] = [];

  constructor(private clienteService: ClienteService) {}

  ngOnInit() {
    this.clienteService.obtenerClientes().subscribe(clientes => {
      this.clientesList = clientes;
    });
  }

  cargarClientes(): void {
    this.clienteService.obtenerClientes().subscribe(clientes => {
      this.clientesList = clientes;
    });
  }
  eliminarCliente(id: number): void {
    if (confirm('¿Estás seguro de que quieres eliminar este cliente?')) {
    this.clienteService.eliminarCliente(id).subscribe(() => {
      this.cargarClientes(); // Asume que tienes una función cargarClientes que obtiene todos los clientes
    });
  }
}
}

