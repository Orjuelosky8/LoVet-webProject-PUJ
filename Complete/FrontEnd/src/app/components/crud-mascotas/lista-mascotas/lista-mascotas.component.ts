import { Component, OnInit } from '@angular/core';
import { Mascota } from '../../../models/mascota';
import { MascotaMockService } from '../../../services/mascotas/mascota-mock.service';

@Component({
  selector: 'app-lista-mascotas',
  templateUrl: './lista-mascotas.component.html',
  styleUrls: ['./lista-mascotas.component.css']
})
export class ListaMascotasComponent implements OnInit {
  mascotas!: Mascota[];

  constructor(private mascotaService: MascotaMockService) { }

  ngOnInit() {
    this.mascotaService.obtenerMascotas().subscribe(data => {
      this.mascotas = data;
    });
  }
}
