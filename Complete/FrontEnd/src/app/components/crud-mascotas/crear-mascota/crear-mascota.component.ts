import { Component } from '@angular/core';
import { Mascota } from '../../../models/mascota';
import { MascotaMockService } from '../../../services/mascotas/mascota-mock.service';

@Component({
  selector: 'app-crear-mascota',
  templateUrl: './crear-mascota.component.html',
  styleUrls: ['./crear-mascota.component.css']
})
export class CrearMascotaComponent {
  nuevaMascota: Mascota = {
    nombre: '',
    raza: '',
    edad: 0,
    imagen: '',
    permanencia: 0,
    altura: 0,
    peso: 0,
    antecedentes: '',
    estado: ''
  };

  constructor(private mascotaService: MascotaMockService) {}

  agregarMascota() {
    this.mascotaService.agregarMascota(this.nuevaMascota).subscribe(result => {
      console.log('Mascota agregada', result);
      // Aquí puedes redirigir al usuario o actualizar la vista como sea necesario
    });
  }
}

