import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { LoginResponse } from '../../services/LoginResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  imports: [CommonModule, ReactiveFormsModule, RouterLink]
})
export class LoginComponent {
  loginForm: FormGroup;
  showPassword = false;


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
          console.log('User authenticated:', response);

          // Aquí accedes a user y token desde la respuesta
          localStorage.setItem('USER', JSON.stringify(response.user));
          this.authService.saveToken(response.token);

          this.router.navigate(['/home']);
        },
        error: (error) => {
          console.error('Error en el login', error);
          alert(error.error?.error || 'Login errorr');
        }
      });
    }
  }


  togglePassword() {
    this.showPassword = !this.showPassword;
  }
}
