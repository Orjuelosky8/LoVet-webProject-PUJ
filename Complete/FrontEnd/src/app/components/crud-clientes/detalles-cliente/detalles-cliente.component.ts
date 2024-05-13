import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Cliente } from 'src/app/models/cliente';
import { Mascota } from 'src/app/models/mascota';
import { mergeMap } from 'rxjs';
import { ClienteService } from 'src/app/services/clientes.service';
import { MascotasService } from 'src/app/services/mascotas.service';

@Component({
  selector: 'app-detalles-cliente',
  templateUrl: './detalles-cliente.component.html',
  styleUrls: ['./detalles-cliente.component.css']
})
export class DetallesClienteComponent  {
  @Input()
  cliente!: Cliente;
  mascotas!: Mascota[];
  loading = true; // Puedes mantener una sola bandera de carga si eso tiene sentido para tu UI

  constructor(
    private route: ActivatedRoute,
    private clienteService: ClienteService,
    private mascotasService: MascotasService // Este servicio necesita el método obtenerMascotasPorIds()
  ) {}

  ngOnInit(): void {
    console.log("ngOnInit de detail");
    //LLamar un API
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id')); 
      this.clienteService.findById(id).pipe(
        mergeMap(
          (data) => {
            this.cliente = data;
            return this.mascotasService.findMascotasByStudent(this.cliente.id);
          }
        )).subscribe(
          (data) => {
            this.cliente.mascotasIds = data
          }
        )
    })
  }

  
}