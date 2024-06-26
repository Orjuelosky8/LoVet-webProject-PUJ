import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';



import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/authentication/login/login.component';
import { LogupComponent } from './components/authentication/logup/logup.component';
import { NavBarComponent } from './components/home/nav-bar/nav-bar.component';
import { FooterComponent } from './components/home/footer/footer.component';
import { LandingPageComponent } from './components/home/landing-page/landing-page.component';
import { ProfileComponent } from './components/general-views/profile/profile.component';
import { EditProfileComponent } from './components/general-views/edit-profile/edit-profile.component';
import { ShopComponent } from './components/client-views/shop/shop.component';
import { HttpClientModule } from '@angular/common/http';
import { ContactComponent } from './components/client-views/contact/contact.component';
import { CheckPetsComponent } from './components/vet-views/check-pets/check-pets.component';
import { AddInfoPetComponent } from './components/vet-views/add-info-pet/add-info-pet.component';
import { ManageVetsComponent } from './components/admin/manage-vets/manage-vets.component';
import { ManageClientsComponent } from './components/admin/manage-clients/manage-clients.component';
import { ManagePetsComponent } from './components/admin/manage-pets/manage-pets.component';
import { ListaMascotasComponent } from './components/crud-mascotas/lista-mascotas/lista-mascotas.component';
import { DetallesMascotaComponent } from './components/crud-mascotas/detalles-mascota/detalles-mascota.component';
import { CrearMascotaComponent } from './components/crud-mascotas/crear-mascota/crear-mascota.component';
import { ServiciosComponent } from './components/home/servicios/servicios.component';
import { PersonalComponent } from './components/home/personal/personal.component';
//import { CrearClienteComponent } from './components/crud-clientes/crear-cliente/crear-cliente.component';
import { DetallesClienteComponent } from './components/crud-clientes/detalles-cliente/detalles-cliente.component';
import { ListaClientesComponent } from './components/crud-clientes/lista-clientes/lista-clientes.component';
import { ListTratamientosComponent } from './components/crud-tratamiento/lista-tratamientos/list-tratamientos/list-tratamientos.component';
import { ListVeterinariosComponent } from './components/crud-veterinario/lista-veterinarios/list-veterinarios/list-veterinarios.component';
import { NavBarVetsComponent } from './components/home/nav-bar-vets/nav-bar-vets.component';
import { AddTratamientoComponent } from './components/crud-tratamiento/add-tratamiento/add-tratamiento/add-tratamiento.component';
import { EditarMascotaComponent } from './components/crud-mascotas/editar-mascota/editar-mascota/editar-mascota.component';
import { EditarClienteComponent } from './components/crud-clientes/editar-cliente/editar-cliente/editar-cliente.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogupComponent,
    LandingPageComponent,
    NavBarComponent,
    FooterComponent,
    ProfileComponent,
    EditProfileComponent,
    ShopComponent,
    ContactComponent,
    CheckPetsComponent,
    AddInfoPetComponent,
    ManageVetsComponent,
    ManageClientsComponent,
    ManagePetsComponent,
    ListaMascotasComponent,
    DetallesMascotaComponent,
    CrearMascotaComponent,
    ServiciosComponent,
    PersonalComponent,
    //CrearClienteComponent,
    DetallesClienteComponent,
    ListaClientesComponent,
    ListTratamientosComponent,
    ListVeterinariosComponent,
    NavBarVetsComponent,
    AddTratamientoComponent,
    EditarMascotaComponent,
    EditarClienteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
