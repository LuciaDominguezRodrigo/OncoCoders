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
      hospitalReferencia: ['', [Validators.required]],
      consentFirm: [false, [Validators.requiredTrue]]
    });
  }

  ngOnInit(): void {}



  onSubmit() {

      if (this.registerForm.valid) {
        const {
          name,
          email,
          password,
          confirmPassword,
          comunidadAutonoma,
          hospitalReferencia,
          consentFirm
        } = this.registerForm.value;

        if (password !== confirmPassword) {
          alert('Passwords do not match');
          return;
        }


        this.authService.register(name, email, password, comunidadAutonoma, hospitalReferencia, consentFirm).subscribe(
          (response) => {
            let message = 'User signed up correctly! ';

            // Verificar el rol devuelto por el backend
            if (response.role === 'MEDICUSER' || response.role === 'RESEARCHERUSER') {
              message += ' Welcome to oncocoders.';
            } else {
              if (response.medicoAsignado) {
                message += ` Assigned to the doctor: ${response.medicoAsignado.name}.`;
              } else {
                message += ' No available doctor was assigned.';
              }
            }

            alert(message);
            this.router.navigate(['/login']);
          },
          (error) => {
            alert(error.error?.error || 'Error in register');
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
