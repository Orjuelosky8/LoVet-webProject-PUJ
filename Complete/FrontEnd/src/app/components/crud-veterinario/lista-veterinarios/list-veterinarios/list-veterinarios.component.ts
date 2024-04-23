import { Component } from '@angular/core';
import { Veterinario } from 'src/app/models/veterinario';
import { MascotasService } from 'src/app/services/mascotas.service';
import { VeterinarioService } from 'src/app/services/veterinario.service';

@Component({
  selector: 'app-list-veterinarios',
  templateUrl: './list-veterinarios.component.html',
  styleUrls: ['./list-veterinarios.component.css']
})
export class ListVeterinariosComponent {
  veterinariosList!: Veterinario[];
  constructor(private veterinarioService: VeterinarioService) { }

  ngOnInit(): void {
    //this.studentList = this.studentService.findAll();
    this.veterinarioService.findAll().subscribe(
      data => this.veterinariosList = data
    );
    console.log(this.veterinarioService.findAll());
  }


}
