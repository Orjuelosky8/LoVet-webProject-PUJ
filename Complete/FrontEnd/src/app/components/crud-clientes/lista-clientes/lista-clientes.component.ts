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
}
