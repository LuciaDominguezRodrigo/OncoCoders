import { Component, OnInit } from '@angular/core';  // Asegúrate de importar OnInit
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-profile',
  imports: [NavbarComponent, CommonModule, ReactiveFormsModule],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: any = {};

  constructor(private userService: UserService) {}

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
}
