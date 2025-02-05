import { Component, OnInit } from '@angular/core';  // Asegúrate de importar OnInit
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PopupComponent} from '../../components/popup/popup.component';

@Component({
  selector: 'app-profile',
  imports: [NavbarComponent, CommonModule, ReactiveFormsModule, FormsModule, PopupComponent],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: any = {};
  newName: string = '';
  newHospital: string = '';
  newZone: string = '';
  doctor: string = '';
  isEditingField: string | null = null;
  showPopup: boolean = false;


  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.getUserProfile().subscribe(
      (data) => {
        this.user = data;
        this.newName = data.name;
        this.doctor = data.doctor;
        this.newHospital = data.hospitalReferencia;
        this.newZone = data.comunidadAutonoma;
        console.log(data);
      },
      (error) => {
        console.error('Error al obtener perfil del usuario:', error);
      }
    );
  }

  editField(field: string): void {
    this.isEditingField = field;
    if (field === 'name') this.newName = this.user.name;
    if (field === 'hospital') this.newHospital = this.user.hospital;
    if (field === 'zone') this.newZone = this.user.zone;
  }

  saveField(field: string): void {
    // Si se cambia el nombre
    if (field === 'name' && this.newName !== this.user.name) {
      this.userService.updateUserName(this.newName).subscribe(
        () => {
          this.user.name = this.newName;
          this.showPopup = true;  // Mostramos el pop-up aquí
          this.isEditingField = null;  // Restablecemos la edición de campos
        },
        (error) => {
          console.error('Error al actualizar el nombre:', error);
        }
      );
    }

    // Si se cambia el hospital
    else if (field === 'hospital' && this.newHospital !== this.user.hospital) {
      this.userService.updateUserHospital(this.newHospital).subscribe(
        () => {
          this.user.hospital = this.newHospital;

          // Si no se ha cambiado la zona, asignamos la zona del médico
          if (this.newZone === this.user.zone && this.user.doctor && this.user.doctor.comunidadAutonoma) {
            this.user.zone = this.user.doctor.comunidadAutonoma;
          }

          this.showPopup = true;  // Mostramos el pop-up aquí
          this.isEditingField = null;  // Restablecemos la edición de campos
        },
        (error) => {
          console.error('Error al actualizar el hospital:', error);
        }
      );
    }

    // Si se cambia la zona
    else if (field === 'zone' && this.newZone !== this.user.zone) {
      this.userService.updateUserZone(this.newZone).subscribe(
        () => {
          this.user.zone = this.newZone;

          // Si no se ha cambiado el hospital, asignamos el hospital del médico
          if (this.newHospital === this.user.hospital && this.user.doctor && this.user.doctor.hospitalReferencia) {
            this.user.hospital = this.user.doctor.hospitalReferencia;
          }

          this.showPopup = true;  // Mostramos el pop-up aquí
          this.isEditingField = null;  // Restablecemos la edición de campos
        },
        (error) => {
          console.error('Error al actualizar la zona:', error);
        }
      );
    }
  }


  cancelEdit(): void {
    this.isEditingField = null;
  }

  closePopup(): void {
    this.showPopup = false;
  }

}
