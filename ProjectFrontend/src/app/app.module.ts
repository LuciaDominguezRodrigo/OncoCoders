import {ApplicationConfig, NgModule, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routing';
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';


@NgModule({
  declarations: [],
  imports: [],
  providers: [],
  bootstrap: [] })

export class AppModule {}
