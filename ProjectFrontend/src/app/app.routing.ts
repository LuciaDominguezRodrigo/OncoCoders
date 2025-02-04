import { Routes } from '@angular/router';
import { MainPageComponent } from './screens/mainPage/mainPage.component';
import {RegisterComponent} from './screens/register/register.component';
import { LoginComponent } from './screens/login/login.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', component: MainPageComponent, pathMatch: 'full' },  // Redirige al índice
  { path: '**', redirectTo: '' }  // Redirigir cualquier ruta no válida al índice
];
