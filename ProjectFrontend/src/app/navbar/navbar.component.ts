import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import {AuthService} from '../services/auth.service';
import {CommonModule} from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';  // Importa Router para redirigir

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  imports :  [CommonModule, ReactiveFormsModule]
})
export class NavbarComponent implements OnInit {
  isAuthenticated = false;
  menuOpen = false;
  username = 'Perfil';

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    // Verificar si el token existe en localStorage
    this.isAuthenticated = !!this.authService.getToken();
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
}
