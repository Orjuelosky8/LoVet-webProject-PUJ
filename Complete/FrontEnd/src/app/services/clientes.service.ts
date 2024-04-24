import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente } from 'src/app/models/cliente';
import { HttpClient } from '@angular/common/http';
import axios from 'axios';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(
    private http: HttpClient
  ) { }

  findAll(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>('http://localhost:8090/clientes/all');
  }

  async findById(id:number): Promise<Cliente>{
    const cliente = await axios.get<Cliente>("http://localhost:8090/clientes/find/" + id);
    return cliente.data;
  }

  deleteById(id:number){
    console.log("ID:" + id)
    this.http.delete("http://localhost:8090/clientes/delete/" + id).subscribe();
  }

  addStudent(cliente:Cliente){
    this.http.post("http://localhost:8090/clientes/add", cliente).subscribe();
  }

 /* async findClienteByCredentials(usuario: string, contraseña: string): Promise<Cliente | null> {
    const clientes = await this.findAll().toPromise(); // Obtener todos los clientes
    // Buscar cliente con las credenciales proporcionadas
    const clienteEncontrado = clientes?.find(cliente => cliente.userName === usuario && cliente.password === contraseña);
    return clienteEncontrado || null; // Devolver el cliente encontrado o null si no se encuentra ninguno
  }*/
}

