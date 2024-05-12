import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';  // Asegúrate de importar Router
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { TratamientoService } from 'src/app/services/tratamiento.service';
import { Tratamiento } from 'src/app/models/tratamiento';

@Component({
  selector: 'app-add-tratamiento',
  templateUrl: './add-tratamiento.component.html',
  styleUrls: ['./add-tratamiento.component.css']
})
export class AddTratamientoComponent implements OnInit {
  tratamientoForm!: FormGroup;

  constructor(private fb: FormBuilder, private tratamientoService: TratamientoService, private router: Router) { }

  ngOnInit() {
    this.tratamientoForm = this.fb.group({
      titulo: ['', Validators.required],
      descripcion: ['', Validators.required],
      estado: ['', Validators.required],
      mascota: this.fb.group({
        id: [],
        nombre: ['', Validators.required],
      }),
      veterinario: this.fb.group({
        id: [],
        nombre: ['', Validators.required],
      }),
      medicamentos: this.fb.array([])
    });
  }

  get medicamentos(): FormArray {
    return this.tratamientoForm.get('medicamentos') as FormArray;
  }

  agregarMedicamento() {
    const medicamentoForm = this.fb.group({
      id: [],
      nombre: ['', Validators.required],
      dosis: ['', Validators.required]
    });
    this.medicamentos.push(medicamentoForm);
  }

  guardarTratamiento() {
    if (this.tratamientoForm.valid) {
      this.tratamientoService.addTratamiento2(this.tratamientoForm.value).subscribe({
        next: () => this.router.navigate(['/tratamientos']),
        error: err => console.error('Error al guardar tratamiento: ', err)
      });
    } else {
      console.error('Formulario no válido');
    }
  }
}