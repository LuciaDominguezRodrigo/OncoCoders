import { Component } from '@angular/core';
import {RouterModule, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';  // Importar MatDialog
import { SidebarComponent } from './components/common/sidebar/sidebar.component';
import { NavbarComponent } from './components/common/navbar/navbar.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterModule,
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule,
    NavbarComponent,
    SidebarComponent
  ]
})
export class AppComponent { }
