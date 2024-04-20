import { Component } from '@angular/core';
import { ClienteService } from 'src/app/services/clientes.service';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrls: ['./lista-clientes.component.css']
})
export class ListaClientesComponent  {
  mostrarForm: boolean = false;

  //atributos
  selectedClient!: Cliente;

  //Base de datos falsa con varios estudiantes.
  clientesList!: Cliente[];

  constructor(
    private clienteService: ClienteService
  ) {
  }

  ngOnInit(): void {
    //this.studentList = this.studentService.findAll();
    this.clienteService.findAll().subscribe(
      data => this.clientesList = data
    )
  }

  //metodos
  mostrarCLiente(cliente: Cliente){
    this.selectedClient = cliente;
  }

  //este metodo se llama cuando se emite un evento desde el hijo.
  agregarCliente(cliente: Cliente){
      this.clientesList.push(cliente);
      this.clienteService.addStudent(cliente);
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

