import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { routes } from './app.routing';
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { AppComponent } from './app.component'; // Importa el componente standalone

@NgModule({
  imports: [
    BrowserModule,
    AppComponent,  // Se importa en lugar de declararlo
  ],
  providers: [
    provideRouter(routes),
    provideClientHydration(withEventReplay())
  ],
})
export class AppModule {}
