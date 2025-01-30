import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';  // Importar HttpClientModule


@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <router-outlet></router-outlet>`,
  imports: [
    RouterOutlet, HttpClientModule
  ]
})
export class AppComponent { }
