import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Veterinario } from '../models/veterinario';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class VeterinarioService {
  constructor(
    private http: HttpClient
  ) { }

  findAll(): Observable<Veterinario[]>{
    return this.http.get<Veterinario[]>('http://localhost:8090/tratamientos');
  }

  async findById(id:number): Promise<Veterinario>{
    const veterinario = await axios.get<Veterinario>("http://localhost:8090/tratamientos/" + id);
    return veterinario.data;
  }

  deleteById(id:number){
    console.log("ID:" + id)
    this.http.delete("http://localhost:8090/clientes/delete/" + id).subscribe();
  }

  addStudent(veterinario:Veterinario){
    this.http.post("http://localhost:8090/clientes/add", veterinario).subscribe();
  }
}
