import { Component } from '@angular/core';
import { SidebarbuttonComponent } from "../../buttons/sidebarbutton/sidebarbutton.component";
import { CommonModule } from '@angular/common';
import { BAN_SCREEN, DASHBOARD_ADMIN_SCREEN, DASHBOARD_SPECIALIST_SCREEN, DIAGNOSIS_SCREEN, FORUM_SCREEN, IA_CONFIGURATION_SCREEN, MONITORING_SCREEN, PENDING_PACIENTS_SCREEN, PROCESSED_PACIENTS_SCREEN, PROFILE_ADMIN_SCREEN, PROFILE_PATIENT_SCREEN, PROFILE_SPECIALIST_SCREEN, RECOMMENDATION_SCREEN, RECORDS_SCREEN, UNBAN_SCREEN } from '../../../routes';
import { Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { UserService } from '../../../services/user.service';
import { convertToUserRole, UserRole } from '../../../models/userRole.enum';

@Component({
  selector: 'app-sidebar',
  imports: [CommonModule, SidebarbuttonComponent],
  templateUrl: './sidebar.component.html'
})

export class SidebarComponent {

  public isLogged!: boolean
  public userRole!: UserRole
  public sideBarOptions!: any[]


  private roleSideBarOptions = {
    "USER": [
      { label: "Diagnóstico", router: DIAGNOSIS_SCREEN },
      { label: "Seguimiento", router: MONITORING_SCREEN },
      { label: "Recomendaciones", router: RECOMMENDATION_SCREEN },
      { label: "Foro", router: FORUM_SCREEN },
      { label: "Perfil", router: PROFILE_PATIENT_SCREEN },
    ],
    "MEDICUSER": [
      { label: "Dashboard", router: DASHBOARD_SPECIALIST_SCREEN },
      { label: "Pacientes Pendientes", router: PENDING_PACIENTS_SCREEN },
      { label: "Pacientes Procesados", router: PROCESSED_PACIENTS_SCREEN },
      { label: "Historial", router: RECORDS_SCREEN },
      { label: "Perfil", router: PROFILE_SPECIALIST_SCREEN }
    ],
    "ADMIN": [
      { label: "Dashboard", router: DASHBOARD_ADMIN_SCREEN },
      { label: "Banear", router: BAN_SCREEN },
      { label: "Desbanear", router: UNBAN_SCREEN },
      { label: "Configuración IA", router: IA_CONFIGURATION_SCREEN },
      { label: "Perfil", router: PROFILE_ADMIN_SCREEN }
    ],
    "RESEARCHERUSER": [],
    "PUBLIC": []
  }


  constructor(
    private authService: AuthService,
    private userService: UserService,
    private routerService: Router,
  ) { }

  async ngOnInit() {
    this.isLogged = !!this.authService.getToken();

    if (!this.isLogged){
      return
    }

    this.userService.getUserRole().subscribe(
      role => {
        this.userRole = convertToUserRole(role);
        this.sideBarOptions = this.roleSideBarOptions[this.userRole]
      },
      error => {
        console.error('Error retrieving user role', error);
      }
    );
  }



}
