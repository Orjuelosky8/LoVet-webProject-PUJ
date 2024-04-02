import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaMascotasComponent } from './components/crud-mascotas/lista-mascotas/lista-mascotas.component';
import { CrearMascotaComponent } from './components/crud-mascotas/crear-mascota/crear-mascota.component';
import { DetallesMascotaComponent } from './components/crud-mascotas/detalles-mascota/detalles-mascota.component';
import { LandingPageComponent } from './components/home/landing-page/landing-page.component';
import { ServiciosComponent } from './components/home/servicios/servicios.component';
import { PersonalComponent } from './components/home/personal/personal.component';
// Importa otros componentes que necesitas para las rutas

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'LoVet' },
  { path: 'LoVet', component: LandingPageComponent},
  { path: 'Servicios', component: ServiciosComponent},
  { path: 'mascotas', component: ListaMascotasComponent },
  { path: 'mascotas/agregar', component: CrearMascotaComponent },
  { path: 'mascotas/:id', component: DetallesMascotaComponent },
  { path: 'Personal', component: PersonalComponent },
  // Agrega rutas para otros componentes como editar o eliminar
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
