import { Component } from '@angular/core';
import { SectiontitleComponent } from '../../../components/tags/sectiontitle/sectiontitle.component';
import { AdviceComponent } from '../../../components/tags/advice/advice.component';
import {UserDiagnosis} from '../../../services/diagnosis.service';
import {UserService} from '../../../services/user.service';
import {NgIf} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-diagnosis',
  imports: [NgIf, FormsModule, SectiontitleComponent, AdviceComponent],
  templateUrl: './diagnosis.component.html',
  styleUrl: './diagnosis.component.css'
})
export class DiagnosisComponent {
  userId!: number;
  diagnosis?: UserDiagnosis;
  errorMessage?: string;
  userRole!: string | null;
  selectedUserId?: number; // Para cuando un MEDCIUSER selecciona un usuario

  constructor( private userService: UserService) {}

  ngOnInit() {
    const token = localStorage.getItem('token'); // Obtener el token almacenado

    if (token) {
      this.userService.getCurrentUser(token).subscribe({
        next: (user) => {
          this.userId = user.id;

          // Si `roles` es un array, tomamos el primer rol (o ajustamos según necesidad)
          this.userRole = user.roles.length > 0 ? user.roles[0] : null;
        },
        error: (err) => {
          console.error('Error al obtener el usuario:', err);
        }
      });
    } else {
      console.error('No se encontró un token en el localStorage.');
    }
    }



  fetchDiagnosis(userIdToFetch?: number) {
    const idToUse = this.userRole === 'USER' ? this.userId : userIdToFetch ?? this.selectedUserId;

    if (!idToUse) {
      this.errorMessage = "Seleccione un usuario válido.";
      return;
    }

    this.userService.getLatestCompleteDiagnosis(idToUse).subscribe({
      next: (data) => {
        this.diagnosis = data;
        this.errorMessage = undefined;
      },
      error: () => {
        this.diagnosis = undefined;
        this.errorMessage = 'No se encontró un diagnóstico completo para este usuario.';
      }
    });
  }

}
