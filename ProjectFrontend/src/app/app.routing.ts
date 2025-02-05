import { Routes } from '@angular/router';
import { MainPageComponent } from './screens/mainPage/mainPage.component';
import {RegisterComponent} from './screens/register/register.component';
import { LoginComponent } from './screens/login/login.component';
import {AboutComponent} from './screens/about/about.component';
import {ProfileComponent} from './sections/profile/profile.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {path: 'about', component: AboutComponent},
  {path: 'profile', component: ProfileComponent},
  { path: '', component: MainPageComponent, pathMatch: 'full' },  // Redirige al índice
  { path: '**', redirectTo: 'login' }  // Redirigir cualquier ruta no válida al índice
];
