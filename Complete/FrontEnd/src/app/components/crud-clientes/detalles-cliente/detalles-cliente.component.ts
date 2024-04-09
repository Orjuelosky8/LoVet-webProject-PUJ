import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Cliente } from 'src/app/models/cliente';
import { Mascota } from 'src/app/models/mascota';
import { ClienteService } from 'src/app/services/clientes.service';
import { MascotasService } from 'src/app/services/mascotas.service';

@Component({
  selector: 'app-detalles-cliente',
  templateUrl: './detalles-cliente.component.html',
  styleUrls: ['./detalles-cliente.component.css']
})
export class DetallesClienteComponent implements OnInit {
  cliente?: Cliente;
  mascotas: Mascota[] = [];
  loading = true; // Puedes mantener una sola bandera de carga si eso tiene sentido para tu UI

  constructor(
    private route: ActivatedRoute,
    private clienteService: ClienteService,
    private mascotasService: MascotasService // Este servicio necesita el método obtenerMascotasPorIds()
  ) {}

  ngOnInit(): void {
    const clienteId = this.route.snapshot.paramMap.get('id');
    if (clienteId) {
      this.loading = true; // Comienza la carga
      this.clienteService.obtenerClientePorId(+clienteId).subscribe(cliente => {
        this.cliente = cliente;
        if (cliente?.mascotasIds) {
          // Carga las mascotas si existen IDs
          this.mascotasService.obtenerMascotasPorIds(cliente.mascotasIds).subscribe(mascotas => {
            this.mascotas = mascotas;
            this.loading = false; // Termina la carga cuando las mascotas estén listas
          });
        } else {
          this.loading = false; // Termina la carga si no hay mascotas
        }
      }, error => {
        // Maneja el error
        this.loading = false; // Asegúrate de detener la carga en caso de error
      });
    }
  }
}