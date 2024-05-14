import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/clientes.service';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css']
})
export class EditarClienteComponent implements OnInit{
    editClienteForm: FormGroup;
    clienteId!: number; 
  
    constructor(
      private formBuilder: FormBuilder,
      private clienteService: ClienteService,  //Asume que tienes este servicio.
      private route: ActivatedRoute,
      private router: Router
    ) {
       //Inicializa el formulario con los controles y las validaciones necesarias.
      this.editClienteForm = this.formBuilder.group({
        userName: ['', Validators.required],
        password: ['', Validators.required],
        correoElectronico: ['', Validators.required],
        nombres: ['', Validators.required],
        apellidos: ['', Validators.required],
        telefono: ['', Validators.required]
      });
    }
    
  
    ngOnInit(): void {
      this.route.paramMap.subscribe(params => {
        const id = Number(params.get('id'));  //Obtén el id de la ruta.
         
            //Carga la información de la mascota para editar.
           this.clienteService.findById(id).subscribe(cliente => {
             if (cliente) {
               this.editClienteForm.patchValue(cliente);
             } else {
                //Si no hay mascota, redirige al usuario a otro lugar o maneja como veas conveniente.
               this.router.navigate(['/clientes']);
             }
           });
         
   });
    }
  
     guardarCliente(): void {
       if (this.editClienteForm.valid) {
         const formValue = this.editClienteForm.value;
         const clienteActualizado: Cliente = {
           id: this.clienteId,  //Asegúrate de que el ID esté asignado.
           ...formValue
         };
        
         /*this.mascotasService.actualizarMascota(id).subscribe({
           next: () => {
              //Si la actualización es exitosa, navega a la lista de mascotas.
             this.router.navigate(['/mascotas']);
           },
           error: (error) => {
              //Manejo del error.
             console.error(error);
           }
         });*/
       }
      }
  }
  
