import { Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: HomepageComponent, pathMatch: 'full' },  // Redirige al índice
  { path: '**', redirectTo: '' }  // Redirigir cualquier ruta no válida al índice
];
