import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AutheticationComponent } from './components/authetication/authetication.component';
import { LandingPageComponent } from './components/general/landing-page/landing-page.component';
import { LoginComponent } from './components/authentication/login/login.component';
import { LogupComponent } from './components/authentication/logup/logup.component';
import { NavBarComponent } from './components/home/nav-bar/nav-bar.component';
import { FooterComponent } from './components/home/footer/footer.component';
import { ProfileComponent } from './components/general-views/profile/profile.component';
import { EditProfileComponent } from './components/general-views/edit-profile/edit-profile.component';
import { ShopComponent } from './components/client-views/shop/shop.component';
import { ContactComponent } from './components/client-views/contact/contact.component';
import { CheckPetsComponent } from './components/vet-views/check-pets/check-pets.component';
import { AddInfoPetComponent } from './components/vet-views/add-info-pet/add-info-pet.component';
import { ManageVetsComponent } from './components/admin/manage-vets/manage-vets.component';
import { ManageClientsComponent } from './components/admin/manage-clients/manage-clients.component';
import { ManagePetsComponent } from './components/admin/manage-pets/manage-pets.component';

@NgModule({
  declarations: [
    AppComponent,
    AutheticationComponent,
    LandingPageComponent,
    LoginComponent,
    LogupComponent,
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
    ManagePetsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
