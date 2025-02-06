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



  //NO QUITAR LOGS: Son debugueo, lo necesito para lo del hopsital
  saveField(field: string): void {
    if (field === 'zone' && this.newZone !== this.user.zone) {
      // Si el campo es 'zone' y la zona es diferente, actualizamos la zona
      this.userService.updateUserZone(this.newZone).subscribe(
        () => {
          console.log("Zona actualizada a:", this.newZone);

          this.userService.getUserProfile().subscribe(
            (data) => {
              console.log("Datos obtenidos tras actualizar zona:", data);

              this.user = data;
              this.doctor = data.doctor;

              let hospitalCambiado = false;

              if (data.doctorHospital) {
                console.log("Hospital actualizado a:", data.doctorHospital);
                this.user.hospital = data.doctorHospital;
                hospitalCambiado = true;
              } else if (data.doctor?.hospital) {
                console.log("Hospital actualizado a:", data.doctor.hospital);
                this.user.hospital = data.doctor.hospital;
                hospitalCambiado = true;
              } else {
                console.log("⚠ No se encontró hospital en los datos del doctor.");
              }

              if (hospitalCambiado) {
                this.userService.updateUserHospital(this.user.hospital).subscribe(
                  () => console.log("Hospital guardado en la base de datos."),
                  (error) => console.error("Error al guardar hospital:", error)
                );
              }

              this.showPopup = true;
              this.isEditingField = null;
            },
            (error) => {
              console.error('Error al obtener el perfil actualizado:', error);
            }
          );
        },
        (error) => {
          console.error('Error al actualizar la zona:', error);
        }
      );
    } else if (field === 'hospital' && this.newHospital !== this.user.hospital) {
      // Si el campo es 'hospital' y el hospital es diferente, actualizamos el hospital
      this.userService.updateUserHospital(this.newHospital).subscribe(
        () => {
          console.log("Hospital actualizado a:", this.newHospital);

          this.userService.getUserProfile().subscribe(
            (data) => {
              console.log("Datos obtenidos tras actualizar hospital:", data);

              this.user = data;
              this.doctor = data.doctor;

              let zoneCambiada = false;

              if (data.zone) {
                console.log("Zona actualizada a:", data.zone);
                this.user.zone = data.zone;
                zoneCambiada = true;
              } else {
                console.log("⚠ No se encontró zona en los datos del usuario.");
              }

              if (zoneCambiada) {
                this.userService.updateUserZone(this.user.zone).subscribe(
                  () => console.log("Zona guardada en la base de datos."),
                  (error) => console.error("Error al guardar zona:", error)
                );
              }

              this.showPopup = true;
              this.isEditingField = null;
            },
            (error) => {
              console.error('Error al obtener el perfil actualizado:', error);
            }
          );
        },
        (error) => {
          console.error('Error al actualizar el hospital:', error);
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
