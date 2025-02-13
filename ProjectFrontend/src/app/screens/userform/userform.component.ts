import { Component } from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, Validators} from '@angular/forms';
import { FormService } from '../../services/form.service';
import {UserService} from '../../services/user.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-userform',
  imports: [
    FormsModule
  ],
  templateUrl: './userform.component.html',
})
export class UserformComponent {
  formData = {
    cancer_mama: " ",
    edad: " ",
    sexo: "",
    zona_vivienda: "",
    hospital: " ",
    dis_hospital: " ",
    bulto: " ",
    dolor_senos_axilas: " ",
    nivel_dolor: " ",
    cambios_hinchazon_piel_senos: " ",
    pezones_rectacion_secrecion: " ",
    tipo_secrecion: " ",
    ganglios_inflamados_dolor: " ",
    perdida_peso_inexplicada: " ",
    fatiga_persistente_cansancio_inexplicado: " ",
    fiebre_inexplicada: " ",
    hinchazon_brazos_manos: " ",
    cambio_apetito: " ",
    cambio_apetito_tipo: " ",
    dolor_huesos_articulaciones_inexplicado: " ",
    dolor_huesos_tipo: " ",
    sudoracion_nocturna_excesiva: " ",
    diagnostico_previo: " ",
    familiares_diagnosticados: " ",
    num_familiares_diagnosticados: null,
    tratamiento_actualmente: " ",
    tipos_tratamineto: " ",
    recaidas: " ",
    primera_menstruacion: " ",
    edad_menopausia: " ",
    hijos: " ",
    hijos_lactancia: " ",
    anticonceptivos_hormonales_5: " ",
    terapia_remplazo_hormonal_postmenopausia: " ",
    act_fisica: " ",
    frequencia_act_fisica: " ",
    consumo_alcohol: " ",
    frecuencia_alcohol: " ",
    fumar: " ",
    sobrepeso_obesidad: " ",
    grasas_saturadas: " ",
    grasas_saludables: " ",
    fruta_verdura: " ",
    ultraprocesados: " ",
    incorporacion_fibra: " ",
    hipertension_diabetes: " ",
    mamografia: " ",
    tipo_tratamiento: " ",
    radioterapia_pecho: " "
  };

  puedeEnviar: boolean = true;

  constructor(private http: HttpClient, private formService: FormService) {
  }

  transformarDatos(data: any): any {
    return {
      edad: data.edad,
      sexo: data.sexo === "Masculino" ? "Femenino" : data.sexo,  // Cambiar sexo si es necesario
      bulto: data.bulto === "Sí" ? "Sí" : "No",
      dolor_senos_axilas: data.dolor_senos_axilas === "Sí" ? "No" : "Sí",
      cambios_hinchazon_piel_senos: data.cambios_hinchazon_piel_senos === "Sí" ? "Sí" : "No",
      pezones_rectacion_secrecion: data.pezones_rectacion_secrecion === "Sí" ? "Sí" : "No",
      ganglios_inflamados_dolor: data.ganglios_inflamados_dolor === "Sí" ? "Sí" : "No",
      perdida_peso_inexplicada: data.perdida_peso_inexplicada === "Sí" ? "No" : "Sí",
      fatiga_persistente_cansancio_inexplicado: data.fatiga_persistente_cansancio_inexplicado === "Sí" ? "Sí" : "No",
      fiebre_inexplicada: data.fiebre_inexplicada === "Sí" ? "No" : "Sí",
      hinchazon_brazos_manos: data.hinchazon_brazos_manos === "Sí" ? "Sí" : "No",
      dolor_huesos_articulaciones_inexplicado: data.dolor_huesos_articulaciones_inexplicado === "Sí" ? "No" : "Sí",
      sudoracion_nocturna_excesiva: data.sudoracion_nocturna_excesiva === "Sí" ? "Sí" : "No",
      diagnostico_previo: data.diagnostico_previo === "Sí" ? "No" : "Sí",
      familiares_diagnosticados: data.familiares_diagnosticados === "Sí" ? "Sí" : "No",
      num_familiares_diagnosticados: data.num_familiares_diagnosticados,
      tratamiento_actualmente: data.tratamiento_actualmente === "Sí" ? "Sí" : "No",
      tipos_tratamiento: data.tipos_tratamiento,
      primera_menstruacion: data.primera_menstruacion,
      edad_menopausia: data.edad_menopausia,
      hijos: data.hijos === "Sí" ? "Sí" : "No",
      hijos_lactancia: data.hijos_lactancia === "Sí" ? "Sí" : "No",
      anticonceptivos_hormonales_5: data.anticonceptivos_hormonales_5 === "Sí" ? "Sí" : "No",
      terapia_remplazo_hormonal_postmenopausia: data.terapia_remplazo_hormonal_postmenopausia === "Sí" ? "Sí" : "No",
      frequencia_act_fisica: data.frequencia_act_fisica,
      frecuencia_alcohol: data.frecuencia_alcohol,
      fumar: data.fumar === "Sí" ? "No" : "Sí",
      sobrepeso_obesidad: data.sobrepeso_obesidad === "Sí" ? "Sí" : "No",
      grasas_saturadas: data.grasas_saturadas,
      grasas_saludables: data.grasas_saludables,
      fruta_verdura: data.fruta_verdura === "Sí" ? "Sí" : "No",
      incorporacion_fibra: data.incorporacion_fibra === "Sí" ? "Sí" : "No",
      hipertension_diabetes: data.hipertension_diabetes === "Sí" ? "No" : "Sí",
      radioterapia_pecho: data.radioterapia_pecho === "Sí" ? "Sí" : "No"
    };
  }

  /*
    ngOnInit() {
      this.verificarUltimoEnvio();
    }

    verificarUltimoEnvio() {
      const ultimoEnvio = localStorage.getItem('ultimoEnvioFormulario');
      if (ultimoEnvio) {
        const fechaUltimoEnvio = new Date(ultimoEnvio);
        const fechaActual = new Date();
        const diferenciaDias = (fechaActual.getTime() - fechaUltimoEnvio.getTime()) / (1000 * 60 * 60 * 24);

        if (diferenciaDias < 7) {
          this.puedeEnviar = false;
        }
      }
    }*/
  enviarFormulario() {
    if (!this.puedeEnviar) {
      alert('Debes esperar 7 días antes de enviar nuevamente el formulario.');
      return;
    }

    const token = localStorage.getItem('token');
    if (!token) {
      alert('No tienes token de autenticación');
      return;
    }

    // Transformar los datos antes de enviarlos
    const formDataTransformada = this.transformarDatos(this.formData);

    this.formService.sendForm(formDataTransformada, token).subscribe(
      response => {
        console.log('Respuesta del servidor:', response);
        alert('Formulario enviado correctamente');
        localStorage.setItem('ultimoEnvioFormulario', new Date().toISOString());
        this.puedeEnviar = true;
      },
      error => {
        console.error('Error en el envío:', error);
        console.log('Respuesta del servidor:', error);
        alert('Hubo un error en el envío. Revisa la consola para más detalles.');
      }
    );


  }
}
