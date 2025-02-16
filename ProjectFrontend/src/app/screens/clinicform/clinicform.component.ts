import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Router} from '@angular/router';
import {FormService} from '../../services/form.service';

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
    estadoMitotico: '',
    estructuraGeneral: ''
  };

  // Función para enviar el formulario
  enviarFormulario(): void {
    if (this.isValidForm()) {
      console.log('Formulario Enviado:', this.formData);
      // Aquí puedes agregar la lógica para enviar los datos del formulario a un servidor o API
    } else {
      console.log('Formulario incompleto o con errores');
    }
  }

  // Verificación básica del formulario
  isValidForm(): string {
    // Verificar si algunos de los campos obligatorios están vacíos
    return this.formData.patientEmail && this.formData.edad && this.formData.etnia &&
      this.formData.edadMenstruacion && this.formData.edadMenopausia &&
      this.formData.hormonaER && this.formData.hormonaPR && this.formData.hormonaHER2 &&
      this.formData.subtipoMolecular && this.formData.tamannioTumor &&
      this.formData.estructuraTubular && this.formData.estadoMitotico &&
      this.formData.estructuraGeneral;
  }

}
