import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormService } from '../../services/form.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-userform',
  imports: [],
  templateUrl: './userform.component.html',
  styleUrl: './userform.component.css'
})
export class UserformComponent {
  userForm!: FormGroup;
  token: string | null = '';

  constructor(private fb: FormBuilder, private formService: FormService, private userService : UserService) {}

  ngOnInit(): void {
    this.token = this.userService.getToken();
    this.userForm = this.fb.group({
      edad: ['', Validators.required],
      sexo: ['', Validators.required],
      bulto: [0, Validators.required],
      dolor_senos_axilas: [0, Validators.required],
      cambios_hinchazon_piel_senos: [0, Validators.required],
      pezones_rectacion_secrecion: [0, Validators.required],
      ganglios_inflamados_dolor: [0, Validators.required],
      perdida_peso_inexplicada: [0, Validators.required],
      fatiga_persistente_cansancio_inexplicado: [0, Validators.required],
      fiebre_inexplicada: [0, Validators.required],
      hinchazon_brazos_manos: [0, Validators.required],
      dolor_huesos_articulaciones_inexplicado: [0, Validators.required],
      sudoracion_nocturna_excesiva: [0, Validators.required],
      diagnostico_previo: [0, Validators.required],
      familiares_diagnosticados: [0, Validators.required],
      num_familiares_diagnosticados: [0, Validators.required],
      tratamiento_actualmente: [0, Validators.required],
      tipos_tratamiento: [0, Validators.required],
      primera_menstruacion: [0, Validators.required],
      edad_menopausia: [0, Validators.required],
      hijos: [0, Validators.required],
      hijos_lactancia: [0, Validators.required],
      anticonceptivos_hormonales_5: [0, Validators.required],
      terapia_remplazo_hormonal_postmenopausia: [0, Validators.required],
      frequencia_act_fisica: [0, Validators.required],
      frecuencia_alcohol: [0, Validators.required],
      fumar: [0, Validators.required],
      sobrepeso_obesidad: [0, Validators.required],
      grasas_saturadas: [0, Validators.required],
      grasas_saludables: [0, Validators.required],
      fruta_verdura: [0, Validators.required],
      incorporacion_fibra: [0, Validators.required],
      hipertension_diabtetes: [0, Validators.required],
      radioterapia_pecho: [0, Validators.required],
    });
  }

  onSubmit(): void {
    if (this.userForm.valid) {
      this.formService.sendForm(this.userForm.value, this.token).subscribe({
        next: (response) => alert('Formulario enviado con éxito'),
        error: (error) => alert('Error al enviar el formulario'),
      });
    } else {
      alert('Completa todos los campos');
    }
  }
}
