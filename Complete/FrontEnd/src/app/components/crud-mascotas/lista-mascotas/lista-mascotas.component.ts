import { Component, OnInit } from '@angular/core';
import { Mascota } from '../../../models/mascota';
import { MascotasService } from '../../../services/mascotas.service';

@Component({
  selector: 'app-lista-mascotas',
  templateUrl: './lista-mascotas.component.html',
  styleUrls: ['./lista-mascotas.component.css']
})
export class ListaMascotasComponent implements OnInit {
  mascotasList!: Mascota[];

  constructor(private mascotaService: MascotasService) { }

  mostrarForm: boolean = false;

  //atributos
  selectedMascota!: Mascota;

  ngOnInit(): void {
    //this.studentList = this.studentService.findAll();
    this.mascotaService.findAll().subscribe(
      data => this.mascotasList = data
    )
  }

  //metodos
  mostrarMascota(mascota: Mascota){
    this.selectedMascota = mascota;
  }

  //este metodo se llama cuando se emite un evento desde el hijo.
  agregarMascota(mascota: Mascota){
      this.mascotasList.push(mascota);
      this.mascotaService.addMascota(mascota);
  }

  /*eliminarEstudiante(cliente: Cliente){
    var index = this.clientesList.indexOf(cliente);
    this.clientesList.splice(index, 1);
    this.clienteService.deleteById(cliente.id);
    console.log(cliente.id)
  }*/

  mostrarFormulario(){
    this.mostrarForm = true;
  }

  ocultarFormulario(mostrar: boolean){
    this.mostrarForm = false;    
  }
  }



  


