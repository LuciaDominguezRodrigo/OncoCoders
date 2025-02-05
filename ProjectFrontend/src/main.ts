import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app/app.component';
import { routes } from './app/app.routing';  // Importa las rutas
import { provideHttpClient } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';  // Importar provideHttpClient

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),  // Configura el enrutador
    provideHttpClient(), provideAnimationsAsync()  // Solo usa provideHttpClient sin interceptores
  ]
});
