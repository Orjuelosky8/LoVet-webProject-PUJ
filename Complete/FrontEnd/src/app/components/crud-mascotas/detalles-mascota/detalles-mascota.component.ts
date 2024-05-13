
import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Mascota } from '../../../models/mascota';
import { mergeMap } from 'rxjs';
import { MascotasService } from 'src/app/services/mascotas.service';


@Component({
  selector: 'app-detalles-mascota',
  templateUrl: './detalles-mascota.component.html',
  styleUrls: ['./detalles-mascota.component.css']

})
export class DetallesMascotaComponent  {
  @Input()
  mascota!: Mascota;

  constructor(
    private mascotaService: MascotasService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    console.log("ngOnInit de detail");
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id'));
      console.log("ID", id );
      this.mascotaService.findById(id)
        .subscribe(
          (data) => {
            this.mascota = data;
            console.log("Mascota cargada:", this.mascota);
            return this.mascotaService.findById(this.mascota.id);
          },
          (error) => {
            console.error("Error al obtener datos:", error);
          }
        );
    });
  }

  ngOnChanges(): void {
    console.log("ngOnChanges de detail");
  }

  
}

/*
+++++++++++++++++


import { HomeworkService } from 'src/app/services/homework.service';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent {

  @Input()
  student!:Student;

  //Inyectar dependencias
  constructor(
    private studentService: StudentService,
    private homeworkService: HomeworkService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  //Se llama una única vez cuando el componente se renderiza en pantalla
  ngOnInit(): void {
    console.log("ngOnInit de detail");
    //LLamar un API
    this.route.paramMap.subscribe(params => {
      const id = Number(params.get('id')); 
      this.studentService.findById(id).pipe(
        mergeMap(
          (data) => {
            this.student = data;
            return this.homeworkService.findStudentHomework(this.student.id);
          }
        )).subscribe(
          (data) => {
            this.student.tareas = data
          }
        )
    })
  }

  //Dado que el componente tiene una propiedad input se llama despues del constructor
  ngOnChanges(): void {
    console.log("ngOnChanges de detail");
  }

  siguiente(){
    let nextID = this.student.id + 1;
    this.router.navigate(['/student/detail', nextID]);
  }
}
*/