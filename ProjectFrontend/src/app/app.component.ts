import { Component } from '@angular/core';
import {Router, RouterModule, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';  // Importar MatDialog
import { SidebarComponent } from './components/common/sidebar/sidebar.component';
import { NavbarComponent } from './components/common/navbar/navbar.component';
import {NgxChartsModule} from '@swimlane/ngx-charts';


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
    SidebarComponent,
    NgxChartsModule,
  ]
})

export class AppComponent {

  constructor(private router: Router) {}

  isLoginOrRegister(): boolean {
    const currentRoute = this.router.url;
    return currentRoute === '/login' || currentRoute === '/register';
  }

  isHidden(): boolean {
    const currentRoute = this.router.url;
    return currentRoute === '/login' || currentRoute === '/register' || currentRoute === '/profile' || currentRoute === '/about';
  }


}
