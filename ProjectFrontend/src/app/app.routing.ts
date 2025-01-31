import { Routes } from '@angular/router';
import { MainPageComponent } from './mainPage/mainPage.component';
import { LoginComponent } from './login/login.component';
import {RegisterComponent} from './register/register.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', component: MainPageComponent, pathMatch: 'full' },  // Redirige al índice
  { path: '**', redirectTo: '' }  // Redirigir cualquier ruta no válida al índice
];
