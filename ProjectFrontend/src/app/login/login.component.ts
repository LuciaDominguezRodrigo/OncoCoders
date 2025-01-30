import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { User } from '../models/user.model';
import { CommonModule } from '@angular/common';  // Importar CommonModule
import { ReactiveFormsModule } from '@angular/forms';  // Importar ReactiveFormsModule

@Component({
  selector: 'app-login',
  standalone: true,  // Este es un componente standalone
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [CommonModule, ReactiveFormsModule]  // Aquí se importan los módulos necesarios
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.authService.login(email, password).subscribe({
        next: (user: User) => {
          console.log('Usuario autenticado:', user);
          localStorage.setItem('user', JSON.stringify(user)); // Guarda en localStorage
          this.router.navigate(['/dashboard']);
        },
        error: (error) => {
          console.error('Error en el login', error);
        }
      });
    }
  }
}
