import { Component } from '@angular/core';
import { Tratamiento } from 'src/app/models/tratamiento';
import { TratamientoService } from 'src/app/services/tratamiento.service';

@Component({
  selector: 'app-list-tratamientos',
  templateUrl: './list-tratamientos.component.html',
  styleUrls: ['./list-tratamientos.component.css']
})
export class ListTratamientosComponent {
  tratamientosList!: Tratamiento[];
  constructor(private tratamientoService: TratamientoService) { }

  ngOnInit(): void {
    //this.studentList = this.studentService.findAll();
    this.tratamientoService.findAll().subscribe(
      data => this.tratamientosList = data
    );
  }
  
  
}
