import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/clientes.service';

@Component({
  selector: 'app-detalles-cliente',
  templateUrl: './detalles-cliente.component.html',
  styleUrls: ['./detalles-cliente.component.css']
})
export class DetallesClienteComponent implements OnInit {
  cliente?: Cliente;
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private clienteService: ClienteService
  ) {}

  ngOnInit(): void {
    const clienteId = this.route.snapshot.paramMap.get('id');
    if (clienteId) {
      this.clienteService.obtenerClientePorId(+clienteId).subscribe(
        (data) => {
          this.cliente = data;
          this.loading = false;
        },
        (error) => {
          // Manejar el error adecuadamente
          this.loading = false;
        }
      );
    }
  }
}
