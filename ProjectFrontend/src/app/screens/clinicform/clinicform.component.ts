import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Router} from '@angular/router';
import {FormService} from '../../services/form.service';
import {ClinicFormService} from '../../services/clinicForm.service';

@Component({
  selector: 'app-clinicform',
    imports: [
        FormsModule,
        ReactiveFormsModule
    ],
  templateUrl: './clinicform.component.html',
  styleUrl: './clinicform.component.css'
})
export class ClinicformComponent {

  constructor(private router: Router, private formService: ClinicFormService) { }

  formData = {
    patientEmail: '',
    edad: '',
    etnia: '',
    edadMenstruacion: '',
    edadMenopausia: '',
    hormonaER: '',
    hormonaPR: '',
    hormonaHER2: '',
    subtipoMolecular: '',
    tamannioTumor: '',
    estructuraTubular: '',
    capacidadEstadoMiotico: '',
    estructuraGeneral: '',
    mutacionBRCA1: '',
    mutacionBRCA2: '',
    familiaresDiagnosticados: '',
    radioterapiaAnterior: '',
    cancerMama: '',
  };


  enviarFormulario(): void {
    if (this.isValidForm()) {
      this.formData = {
        patientEmail: this.formData.patientEmail || '',
        edad: this.formData.edad || '',
        etnia: this.formData.etnia || '',
        edadMenstruacion: this.formData.edadMenstruacion || '',
        edadMenopausia: this.formData.edadMenopausia || '',
        hormonaER: this.formData.hormonaER || '',
        hormonaPR: this.formData.hormonaPR || '',
        hormonaHER2: this.formData.hormonaHER2 || '',
        subtipoMolecular: this.formData.subtipoMolecular || '',
        tamannioTumor: String(this.formData.tamannioTumor),
        estructuraTubular: this.formData.estructuraTubular || '',
        capacidadEstadoMiotico: this.formData.capacidadEstadoMiotico || '',
        estructuraGeneral: this.formData.estructuraGeneral || '',
        mutacionBRCA1: this.formData.mutacionBRCA1 || '',
        mutacionBRCA2: this.formData.mutacionBRCA2 || '',
        familiaresDiagnosticados: String(this.formData.familiaresDiagnosticados), 
        radioterapiaAnterior: this.formData.radioterapiaAnterior || '',
        cancerMama: this.formData.cancerMama || '',
      };

      // 🔹 Verificar JSON antes de enviar
      console.log('Datos JSON enviados:', JSON.stringify(this.formData, null, 2));
      console.log('Formulario Enviado:', this.formData);

      // Usar FormService para enviar los datos al backend
      this.formService.sendForm(this.formData).subscribe(
        response => {
          console.log('Respuesta del servidor:', response);
          alert('Formulario enviado correctamente');
          // Redirigir a otra página si es necesario
          this.router.navigate(['/profile']);
        },
        error => {
          alert('Hubo un error en el envío del formulario');
          console.log('Respuesta del servidor:', error);
        }
      );
    } else {
      console.log('Formulario incompleto o con errores');
      alert('Por favor, completa todos los campos del formulario correctamente');
    }
  }

  // Verificación básica del formulario
  isValidForm(): string {
    // Verificar si algunos de los campos obligatorios están vacíos
    return this.formData.patientEmail && this.formData.edad && this.formData.etnia &&
      this.formData.edadMenstruacion && this.formData.edadMenopausia &&
      this.formData.hormonaER && this.formData.hormonaPR && this.formData.hormonaHER2 &&
      this.formData.subtipoMolecular && this.formData.tamannioTumor &&
      this.formData.estructuraTubular && this.formData.capacidadEstadoMiotico &&
      this.formData.estructuraGeneral && this.formData.cancerMama && this.formData.familiaresDiagnosticados
      && this.formData.mutacionBRCA2 && this.formData.mutacionBRCA1;
  }

}
