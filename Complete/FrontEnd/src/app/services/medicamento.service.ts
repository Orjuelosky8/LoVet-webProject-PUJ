import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 import { Observable, of } from 'rxjs';
import { Medicamento } from '../models/medicamento';

@Injectable({
  providedIn: 'root'
})
export class MedicamentoService {
  constructor(
    private http: HttpClient
  ) { 

    console.log('enter test')
  }

  findAll(): Observable<Medicamento[]>{
    return this.http.get<Medicamento[]>('http://localhost:8090/medicamentos/listar');
  }
}
