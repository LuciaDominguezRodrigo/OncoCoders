import { Component } from '@angular/core';
import { SidebarbuttonComponent } from "../../buttons/sidebarbutton/sidebarbutton.component";
import { CommonModule } from '@angular/common';
import { BAN_SCREEN, DASHBOARD_ADMIN_SCREEN, DASHBOARD_SPECIALIST_SCREEN, DIAGNOSIS_SCREEN, IA_CONFIGURATION_SCREEN, MONITORING_SCREEN, PACIENTS_SCREEN, PROFILE_ADMIN_SCREEN, PROFILE_PATIENT_SCREEN, PROFILE_SPECIALIST_SCREEN, RECOMMENDATION_SCREEN, RECORDS_SCREEN, UNBAN_SCREEN, USER_FORM_SCREEN } from '../../../routes';
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
      { label: "Diagnosis", router: DIAGNOSIS_SCREEN },
      { label: "Follow-up", router: MONITORING_SCREEN },
      { label: "Recomendations", router: RECOMMENDATION_SCREEN },
      { label: "Form", router: USER_FORM_SCREEN },
      { label: "Profile", router: PROFILE_PATIENT_SCREEN },
    ],
    "MEDICUSER": [
      { label: "Dashboard", router: DASHBOARD_SPECIALIST_SCREEN },
      { label: "Pacients", router: PACIENTS_SCREEN },
      { label: "Record", router: RECORDS_SCREEN },
      { label: "Profile", router: PROFILE_SPECIALIST_SCREEN }
    ],
    "ADMIN": [
      { label: "Dashboard", router: DASHBOARD_ADMIN_SCREEN },
      { label: "Ban", router: BAN_SCREEN },
      { label: "Unban", router: UNBAN_SCREEN },
      { label: "Model configuration", router: IA_CONFIGURATION_SCREEN },
      { label: "Profile", router: PROFILE_ADMIN_SCREEN }
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
