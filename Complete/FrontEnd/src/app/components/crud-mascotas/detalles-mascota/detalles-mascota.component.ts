import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Mascota } from '../../../models/mascota';
import { MascotaMockService } from '../../../services/mascotas/mascota-mock.service';

@Component({
  selector: 'app-detalles-mascota',
  templateUrl: './detalles-mascota.component.html',
  styleUrls: ['./detalles-mascota.component.css']
})
export class DetallesMascotaComponent implements OnInit {
  mascota!: Mascota;

  constructor(
    private route: ActivatedRoute,
    private mascotaService: MascotaMockService
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.mascotaService.obtenerMascotaPorId(+id).subscribe(data => {
        this.mascota = data;
      });
    } else {
      // Manejar el caso de que 'id' sea null
      // Por ejemplo, redirigir al usuario a otra página o mostrar un mensaje de error
    }
  }
}
