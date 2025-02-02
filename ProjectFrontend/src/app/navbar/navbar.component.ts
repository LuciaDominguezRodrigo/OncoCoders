import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isAuthenticated = false;  // Estado de autenticación del usuario
  menuOpen = false;  // Estado del menú móvil
  username = 'Juan Pérez';  // Nombre del usuario (esto es solo un ejemplo)

  // Método para alternar la visibilidad del menú móvil
  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  // Método para alternar el estado de autenticación
  toggleAuth() {
    this.isAuthenticated = !this.isAuthenticated;
  }
}

