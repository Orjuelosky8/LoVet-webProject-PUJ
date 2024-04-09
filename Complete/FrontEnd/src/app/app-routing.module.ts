import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaMascotasComponent } from './components/crud-mascotas/lista-mascotas/lista-mascotas.component';
import { CrearMascotaComponent } from './components/crud-mascotas/crear-mascota/crear-mascota.component';
import { DetallesMascotaComponent } from './components/crud-mascotas/detalles-mascota/detalles-mascota.component';
import { LandingPageComponent } from './components/home/landing-page/landing-page.component';
import { ServiciosComponent } from './components/home/servicios/servicios.component';
import { PersonalComponent } from './components/home/personal/personal.component';
import { ListaClientesComponent } from './components/crud-clientes/lista-clientes/lista-clientes.component';
import { CrearClienteComponent } from './components/crud-clientes/crear-cliente/crear-cliente.component';
import { DetallesClienteComponent } from './components/crud-clientes/detalles-cliente/detalles-cliente.component';
import { LoginComponent } from './components/authentication/login/login.component';
import { LogupComponent } from './components/authentication/logup/logup.component';
// Importa otros componentes que necesitas para las rutas

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'LoVet' },
  { path: 'LoVet', component: LandingPageComponent},
  { path: 'clientes/login', component: LoginComponent},
  { path: 'clientes/agregar', component: CrearClienteComponent},
  { path: 'Servicios', component: ServiciosComponent},
  { path: 'mascotas', component: ListaMascotasComponent },
  { path: 'mascotas/agregar', component: CrearMascotaComponent },
  { path: 'mascotas/:id', component: DetallesMascotaComponent },
  { path: 'clientes', component: ListaClientesComponent },
  { path: 'cliente/:id', component: DetallesClienteComponent },
  // { path: 'clientes/mascotas/:id', component: DetallesClienteComponent },
  { path: 'Personal', component: PersonalComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
