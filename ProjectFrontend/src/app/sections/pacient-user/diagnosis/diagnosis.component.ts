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
          console.error('Error getting user:', err);
        }
      });
    } else {
      console.error('A token was not found in the localStorage.');
    }
    }



  fetchDiagnosis(userIdToFetch?: number) {
    const idToUse = this.userRole === 'USER' ? this.userId : userIdToFetch ?? this.selectedUserId;

    if (!idToUse) {
      this.errorMessage = "Select a valid user.";
      return;
    }

    this.userService.getLatestCompleteDiagnosis(idToUse).subscribe({
      next: (data) => {
        this.diagnosis = data;
        this.errorMessage = undefined;
      },
      error: () => {
        this.diagnosis = undefined;
        this.errorMessage = 'No complete diagnosis was found for this user.';
      }
    });
  }

  getFriendlyMessage(value: string | number): string {
    // Si el valor es una cadena con "%", lo convertimos a número
    const numericValue = typeof value === "string" ? parseFloat(value.replace("%", "").trim()) : value;

    if (isNaN(numericValue)) {
      return "Invalid value";
    }

    if (numericValue < 30) {
      return "Very low probability";
    } else if (numericValue < 50) {
      return "Low probability";
    } else if (numericValue < 75) {
      return "Moderate probability";
    } else {
      return "Consult your doctor immediately";
    }
  }



}
