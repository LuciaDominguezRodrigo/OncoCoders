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
  isEditing: boolean = false;
  newName: string = '';

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.getUserProfile().subscribe(
      (data) => {
        this.user = data;
      },
      (error) => {
        console.error('Error al obtener perfil del usuario:', error);
      }
    );
  }

  editName(): void {
    this.isEditing = true;
  }


  saveName(): void {
    if (this.newName && this.newName !== this.user.name) {
      this.userService.updateUserName(this.newName).subscribe(
        (response) => {
          this.user.name = this.newName;
          this.isEditing = false;
        },
        (error) => {
          console.error('Error al actualizar el nombre:', error);
        }
      );
    } else {
      this.isEditing = false;
    }
  }

  cancelEdit(): void {
    this.isEditing = false;
    this.newName = this.user.name;
  }
}
