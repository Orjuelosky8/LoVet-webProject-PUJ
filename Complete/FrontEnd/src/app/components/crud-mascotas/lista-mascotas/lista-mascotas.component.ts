import { Component, OnInit } from '@angular/core';
import { Mascota } from '../../../models/mascota';
import { MascotasService } from '../../../services/mascotas.service';

@Component({
  selector: 'app-lista-mascotas',
  templateUrl: './lista-mascotas.component.html',
  styleUrls: ['./lista-mascotas.component.css']
})
export class ListaMascotasComponent implements OnInit {
  mascotasList!: Mascota[];

  constructor(private mascotaService: MascotasService) { }

  ngOnInit() {
    this.mascotaService.obtenermascotas().subscribe(mascotas => {
      this.mascotasList = mascotas;
    });
  }
  
    cargarMascotas(): void {
      this.mascotaService.obtenermascotas().subscribe(mascotas => {
        this.mascotasList = mascotas;
        alert(mascotas);
      });
    }
    eliminarMascota(id: number): void {
      if (confirm('¿Estás seguro de que quieres eliminar la mascota #' + id + '?')) {
      this.mascotaService.eliminarmascota(id).subscribe(() => {
        this.cargarMascotas(); // Asume que tienes una función cargarClientes que obtiene todos los clientes
      });
    }
  }
  }
  


