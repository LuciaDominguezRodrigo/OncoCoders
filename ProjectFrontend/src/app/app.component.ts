import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';  // Importar MatDialog


@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <router-outlet></router-outlet>`,
  imports: [
    RouterOutlet,
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule
  ]
})
export class AppComponent { }
