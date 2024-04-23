import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Mascota } from 'src/app/models/mascota';
import { MascotasService } from 'src/app/services/mascotas.service';

@Component({
  selector: 'app-editar-mascota',
  templateUrl: './editar-mascota.component.html',
  styleUrls: ['./editar-mascota.component.css']
})
export class EditarMascotaComponent implements OnInit {
  editMascotaForm: FormGroup;
  mascotaId!: number; 

  constructor(
    private formBuilder: FormBuilder,
    private mascotasService: MascotasService, // Asume que tienes este servicio.
    private route: ActivatedRoute,
    private router: Router
  ) {
    // Inicializa el formulario con los controles y las validaciones necesarias.
    this.editMascotaForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      raza: ['', Validators.required],
      edad: ['', Validators.required],
      imagen: ['', Validators.required],
      permanencia: ['', Validators.required],
      altura: ['', Validators.required],
      peso: ['', Validators.required],
      antecedentes: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // this.route.params.subscribe(params => {
    //   this.mascotaId = +params['idMascota']; // Obtén el id de la ruta.
    //   if (this.mascotaId) {
    //     // Carga la información de la mascota para editar.
    //     this.mascotasService.obtenerMascotasPorIds([this.mascotaId]).subscribe(mascota => {
    //       if (mascota) {
    //         this.editMascotaForm.patchValue(mascota);
    //       } else {
    //         // Si no hay mascota, redirige al usuario a otro lugar o maneja como veas conveniente.
    //         this.router.navigate(['/mascotas']);
    //       }
    //     });
    //   }
    // });
  }

  // guardarMascota(): void {
  //   if (this.editMascotaForm.valid) {
  //     const formValue = this.editMascotaForm.value;
  //     const mascotaActualizada: Mascota = {
  //       id: this.mascotaId, // Asegúrate de que el ID esté asignado.
  //       ...formValue
  //     };
      
  //     this.mascotasService.actualizarmascota(mascotaActualizada).subscribe({
  //       next: () => {
  //         // Si la actualización es exitosa, navega a la lista de mascotas.
  //         this.router.navigate(['/mascotas']);
  //       },
  //       error: (error) => {
  //         // Manejo del error.
  //         console.error(error);
  //       }
  //     });
  //   }
  // }
}
