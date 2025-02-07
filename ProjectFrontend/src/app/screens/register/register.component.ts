import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink]
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  showPassword = false;
  showConfirmPassword = false;


  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required]],
      comunidadAutonoma: ['', [Validators.required]],
      hospitalReferencia: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    if (this.registerForm.valid) {
      const { name, email, password, confirmPassword, comunidadAutonoma, hospitalReferencia } = this.registerForm.value;

      if (password !== confirmPassword) {
        alert('Las contraseñas no coinciden');
        return;
      }

      this.authService.register(name, email, password, comunidadAutonoma, hospitalReferencia).subscribe(
        (response) => {
          let message = 'Usuario registrado exitosamente.';

          // Verificar el rol devuelto por el backend
          if (response.role === 'MEDICUSER' || response.role === 'RESEARCHERUSER') {
            message += ' Bienvenido a Oncocoders.';
          } else {
            if (response.medicoAsignado) {
              message += ` Asignado al médico: ${response.medicoAsignado.name}.`;
            } else {
              message += ' No se asignó ningún médico disponible.';
            }
          }

          alert(message);
          this.router.navigate(['/login']);
        },
        (error) => {
          alert(error.error?.error || 'Error en el registro');
        }
      );
    }
  }
  togglePassword() {
    this.showPassword = !this.showPassword;
  }

  toggleConfirmPassword() {
    this.showConfirmPassword = !this.showConfirmPassword;
  }

  passwordsMatch(form: FormGroup) {
    return form.get('password')?.value === form.get('confirmPassword')?.value
      ? null
      : { mismatch: true };
  }

}
