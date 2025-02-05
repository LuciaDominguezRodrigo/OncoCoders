import { Component, OnInit } from '@angular/core';  // Asegúrate de importar OnInit
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-profile',
  imports: [NavbarComponent, CommonModule, ReactiveFormsModule, FormsModule],
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
    if (field === 'name' && this.newName !== this.user.name) {
      this.userService.updateUserName(this.newName).subscribe(() => {
        this.user.name = this.newName;
        this.isEditingField = null;
      });
    } else if (field === 'hospital' && this.newHospital !== this.user.hospital) {
      this.userService.updateUserHospital(this.newHospital).subscribe(() => {
        this.user.hospital = this.newHospital;
        this.isEditingField = null;
      });
    } else if (field === 'zone' && this.newZone !== this.user.zone) {
      this.userService.updateUserZone(this.newZone).subscribe(() => {
        this.user.zone = this.newZone;
        this.isEditingField = null;
      });
    }
  }

  cancelEdit(): void {
    this.isEditingField = null;
  }
}
