import { Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },  // Redirigir al login si no se especifica ruta
  { path: '**', redirectTo: '/login' }  // Redirigir cualquier ruta no válida a login
];
