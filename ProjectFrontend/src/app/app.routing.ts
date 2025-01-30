import { Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component'; // Componente standalone

export const routes: Routes = [
  { path: '', component: HomepageComponent }, // Página principal
  { path: '**', redirectTo: '' } // Redirige cualquier otra ruta a la principal
];
