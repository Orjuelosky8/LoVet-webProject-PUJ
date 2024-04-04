// src/app/services/cliente.service.ts
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() { }

  verificarCredenciales(userName: string, password: string): Observable<boolean> {
    // Simulación de una base de datos de usuarios
    const usuariosSimulados = [
      { userName: 'usuario1', password: 'contraseña1' },
      { userName: 'usuario2', password: 'contraseña2' }
    ];

    const usuarioEncontrado = usuariosSimulados.find(usuario => usuario.userName === userName && usuario.password === password);
    return of(!!usuarioEncontrado); // Retorna 'true' si el usuario fue encontrado, 'false' en caso contrario
  }
}
