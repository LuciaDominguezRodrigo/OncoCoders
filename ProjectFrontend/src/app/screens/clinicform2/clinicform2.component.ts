import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {ClinicFormService} from '../../services/clinicForm.service';

@Component({
  selector: 'app-clinicform2',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './clinicform2.component.html'
})
export class Clinicform2Component {

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
    operacion: '',
    operacion_tipo: '',
    tratamientoActualmente: '',
    tipos_tratamiento: '',
    sobrepeso_obesidad: '',
    tratamientoPrevio: '',
    cancer_mama_antes: ''

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
        operacion: this.formData.operacion || '',
        operacion_tipo: this.formData.operacion_tipo || '',
        tratamientoActualmente: this.formData.tratamientoActualmente || '',
        tipos_tratamiento: this.formData.tipos_tratamiento || '',
        sobrepeso_obesidad: this.formData.sobrepeso_obesidad || '',
        tratamientoPrevio: this.formData.tratamientoPrevio || '',
        cancer_mama_antes: this.formData.cancer_mama_antes || ''
      };

      // 🔹 Verificar JSON antes de enviar
      console.log('Datos JSON enviados:', JSON.stringify(this.formData, null, 2));
      console.log('Formulario Enviado:', this.formData);

      const token = localStorage.getItem('token');
      if (!token) {
        alert('No tienes token de autenticación');
        return;
      }

      // Usar FormService para enviar los datos al backend
      this.formService.sendForm2(token, this.formData).subscribe(
        response => {
          console.log('Server response:', response);
          alert('Form submitted correctly ');
          // Redirigir a otra página si es necesario
          this.router.navigate(['/profile']);
        },
        error => {
          alert('It has ocurred an error while sending the form');
          console.log('Server response', error);
        }
      );
    } else {
      console.log('Formulario incompleto o con errores');
      alert('Please, complete all the form questions');
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
      this.formData.estructuraGeneral && this.formData.familiaresDiagnosticados
      && this.formData.mutacionBRCA2 && this.formData.mutacionBRCA1;
  }
}
