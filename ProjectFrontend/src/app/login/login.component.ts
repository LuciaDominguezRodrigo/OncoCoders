import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { AuthService } from '../services/auth.service';
import {Router, RouterLink} from '@angular/router';
import {LoginResponse} from '../services/LoginResponse';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterLink]
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
        next: (response: LoginResponse) => {
          console.log('Usuario autenticado:', response);

          // Aquí accedes a user y token desde la respuesta
          localStorage.setItem('USER', JSON.stringify(response.user));
          this.authService.saveToken(response.token);

          this.router.navigate(['/']);
        },
        error: (error) => {
          console.error('Error en el login', error);
          alert(error.error?.error || 'Error en el inicio de sesión');
        }
      });
    }
  }
}
