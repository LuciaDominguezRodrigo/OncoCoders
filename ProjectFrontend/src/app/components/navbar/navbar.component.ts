import { Component, OnInit } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service'; // Asegúrate de que el servicio esté importado correctamente
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterLink]
})
export class NavbarComponent implements OnInit {
  isAuthenticated = false;
  menuOpen = false;
  userRole: string | null = null;
  showHelpPopup = false;

  constructor(
    private authService: AuthService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Verificar si el token existe en localStorage
    this.isAuthenticated = !!this.authService.getToken();
    this.getUserRole();
  }

  getUserRole(): void {
    this.userService.getUserRole().subscribe(role => {
      this.userRole = role;
    }, error => {
      console.error('Error al obtener el rol del usuario', error);
    });
  }

  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  toggleAuth() {
    if (this.isAuthenticated) {
      this.authService.logout().subscribe(() => {
        localStorage.removeItem('token');
        this.isAuthenticated = false;
        this.router.navigate(['/login']);
      }, (error) => {
        console.error('Error en logout:', error);
      });
    } else {
      this.router.navigate(['/login']);
    }
  }

  openHelpPopup(): void {
    if (this.userRole && this.userRole.trim().toUpperCase() === 'USER') {
      this.showHelpPopup = true;
    }
  }


  closeHelpPopup(): void {
    this.showHelpPopup = false;
  }
}
