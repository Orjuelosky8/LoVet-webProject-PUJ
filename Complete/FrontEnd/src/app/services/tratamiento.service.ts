import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tratamiento } from '../models/tratamiento';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class TratamientoService {

  constructor(
    private http: HttpClient
  ) { }

  findAll(): Observable<Tratamiento[]>{
    return this.http.get<Tratamiento[]>('http://localhost:8090/tratamientos');
  }

  async findById(id:number): Promise<Tratamiento>{
    const tratamiento = await axios.get<Tratamiento>("http://localhost:8090/tratamientos/" + id);
    return tratamiento.data;
  }

  deleteById(id:number){
    console.log("ID:" + id)
    this.http.delete("http://localhost:8090/tratamientos/" + id).subscribe();
  }

  addStudent(tratamiento:Tratamiento){
    this.http.post("http://localhost:8090/tratamientos", tratamiento).subscribe();
  }

}
