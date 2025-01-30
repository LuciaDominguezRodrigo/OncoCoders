import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app/app.component';
import { routes } from './app/app.routing'; // Importa las rutas directamente

bootstrapApplication(AppComponent, {
  providers: [provideRouter(routes)] // Configura el router correctamente
});
