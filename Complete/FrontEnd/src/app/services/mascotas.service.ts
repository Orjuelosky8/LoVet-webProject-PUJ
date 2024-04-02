// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Mascota } from './mascota'; // Asegúrate de definir una interfaz o clase Mascota

// @Injectable({
//   providedIn: 'root'
// })
// export class MascotasService {
//   private apiUrl = 'http://localhost:8090/mascotas'; // URL del backend

//   constructor(private http: HttpClient) { }

//   obtenerMascotas(): Observable<Mascota[]> {
//     return this.http.get<Mascota[]>(`${this.apiUrl}/all`);
//   }

//   obtenerMascotaPorId(id: number): Observable<Mascota> {
//     return this.http.get<Mascota>(`${this.apiUrl}/find/${id}`);
//   }

//   agregarMascota(mascota: Mascota): Observable<Mascota> {
//     return this.http.post<Mascota>(`${this.apiUrl}/agregar`, mascota);
//   }

//   actualizarMascota(id: number, mascota: Mascota): Observable<Mascota> {
//     return this.http.post<Mascota>(`${this.apiUrl}/update/${id}`, mascota);
//   }

//   eliminarMascota(id: number): Observable<any> {
//     return this.http.get(`${this.apiUrl}/delete/${id}`);
//   }
// }
