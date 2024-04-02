import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { Mascota } from './../../models/mascota';

@Injectable({
  providedIn: 'root'
})
export class MascotaMockService {
  private mascotas: Mascota[] = [
    // Tus datos mockeados aquí
  ];
  private idCounter = 1; // Simula un autoincremento del ID

  constructor() { }

  obtenerMascotas(): Observable<Mascota[]> {
    return of(this.mascotas);
  }

  obtenerMascotaPorId(id: number): Observable<Mascota> {
    const mascota = this.mascotas.find(m => m.id === id);
    if (mascota) {
      return of(mascota);
    } else {
      // Devuelve un Observable que emite un error si no se encuentra la mascota
      return throwError(() => new Error('Mascota no encontrada'));
    }
  }

  agregarMascota(mascota: Mascota): Observable<Mascota> {
    mascota.id = this.idCounter++;
    this.mascotas.push(mascota);
    return of(mascota);
  }

  actualizarMascota(mascotaActualizada: Mascota): Observable<Mascota> {
    const index = this.mascotas.findIndex(m => m.id === mascotaActualizada.id);
    if (index !== -1) {
      this.mascotas[index] = mascotaActualizada;
    }
    return of(mascotaActualizada);
  }

  eliminarMascota(id: number): Observable<any> {
    this.mascotas = this.mascotas.filter(m => m.id !== id);
    return of({}); // Simula la respuesta del servidor al eliminar un recurso
  }
}
