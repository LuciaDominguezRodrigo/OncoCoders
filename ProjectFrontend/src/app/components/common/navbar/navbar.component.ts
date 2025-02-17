import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { UserService } from '../../../services/user.service';
import { ActionbuttonComponent } from "../../buttons/actionbutton/actionbutton.component";
import { ABOUT_SCREEN, HOME_SCREEN, LOGIN_SCREEN, REGISTER_SCREEN } from '../../../routes';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  imports: [CommonModule, ReactiveFormsModule, RouterLink, ActionbuttonComponent]
})
export class NavbarComponent implements OnInit {
  isAuthenticated = false;
  menuOpen = false;
  userRole: string | null = null;
  showHelpPopup = false;

  /**
    * Constructor for the NavbarComponent class.
    * @param authService Authentication service to manage user session.
    * @param userService User service to retrieve user information.
    * @param router Navigation service to handle page redirections.
    */
  constructor(
    private authService: AuthService,
    private userService: UserService,
    private router: Router
  ) { }

  /**
   * Component initialization method.
   * Checks if the user is authenticated and retrieves their role.
   */
  ngOnInit(): void {
    this.isAuthenticated = !!this.authService.getToken();
    this.getUserRole();
  }

  /**
   * Retrieves the user's role from the user service.
   */
  getUserRole(): void {
    this.userService.getUserRole().subscribe(
      role => {
        this.userRole = role;
      },
      error => {
        console.error('Error retrieving user role', error);
      }
    );
  }

  /**
   * Toggles the visibility of the navigation menu.
   */
  toggleMenu(): void {
    this.menuOpen = !this.menuOpen;
  }

  /**
   * Handles user authentication status.
   * Logs out if the user is authenticated.
   * Redirects to the login page if not authenticated.
   */
  toggleAuth(): void {
    if (this.showHelpPopup) {
      document.body.style.overflow = 'hidden';
    } else {
      document.body.style.overflow = 'auto';
    }
    if (this.isAuthenticated) {
      this.authService.logout().subscribe(
        () => {
          localStorage.removeItem('token');
          this.isAuthenticated = false;
          this.router.navigate(['/login']);
        },
        (error) => {
          console.error('Error during logout:', error);
        }
      );
    } else {
      this.router.navigate(['/login']);
    }
  }

  /**
   * Displays the help popup if the user's role is "USER".
   */
  openHelpPopup(): void {
    if (this.userRole && this.userRole.trim().toUpperCase() === 'USER') {
      this.showHelpPopup = true;
    }
  }

  /**
   * Closes the help popup.
   */
  closeHelpPopup(): void {
    this.showHelpPopup = false;
  }

  redirectToRegister() {
    this.router.navigate([REGISTER_SCREEN]);
  }

  redirectToLogin() {
    this.router.navigate([LOGIN_SCREEN]);
  }

  redirectToAboutUs() {
    this.router.navigate([ABOUT_SCREEN]);
  }

  redirectToHome() {
    this.router.navigate([HOME_SCREEN]);
  }
}
