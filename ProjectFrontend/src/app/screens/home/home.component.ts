import {Component, OnInit} from '@angular/core';
import { SectiontitleComponent } from "../../components/tags/sectiontitle/sectiontitle.component";
import { DIAGNOSIS_SCREEN, MONITORING_SCREEN, RECOMMENDATION_SCREEN, USER_FORM_SCREEN, PROFILE_PATIENT_SCREEN, DASHBOARD_SPECIALIST_SCREEN, PACIENTS_SCREEN, RECORDS_SCREEN, PROFILE_SPECIALIST_SCREEN, DASHBOARD_ADMIN_SCREEN, BAN_SCREEN, UNBAN_SCREEN, IA_CONFIGURATION_SCREEN, PROFILE_ADMIN_SCREEN } from '../../routes';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';
import { convertToUserRole, UserRole } from '../../models/userRole.enum';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [SectiontitleComponent, CommonModule],
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit{
  public isLogged!: boolean
  public username!: string
  public userRole!: UserRole
  public descriptions!: any[]

  private sectionsDescription = {
    "USER": [
      { section: "Diagnosis", description: "You can view your latest diagnosis made by both your physician and the AI model." },
      { section: "Follow-up", description: "It shows your development over time. You have different metrics and observations." },
      { section: "Recomendations", description: "It contains a series of recommendations and guidelines to take care of your health regarding breast cancer." },
      { section: "Form", description: "Access to the form so that a specialist and the AI model can make a diagnosis." },
      { section: "Profile", description: "Page where you can find information about your user, along with the possibility to edit your profile." },
    ],
    "MEDICUSER": [
      { section: "Dashboard", description: "Physician control panel. You have access to different metrics related to your profession." },
      { section: "Pacients", description: "Access to patients associated with the physician. You can interact with patients and view relevant information." },
      { section: "Record", description: "Access to the specialist's patient history. You can interact with patients and view relevant information." },
      { section: "Profile", description: "Page where you can find information about your user, along with the possibility to edit your profile." },
    ],
    "ADMIN": [
      { section: "Dashboard", description: "Administrator control panel. You have access to different metrics related to the application." },
      { section: "Ban", description: "Access to the list of unbanned users. You can see the user's role along with the possibility to ban the user." },
      { section: "Unban", description: "Access to the list of banned users. You can see the user's role along with the possibility to unban the user." },
      { section: "Model configuration", description: "You can access the configuration of the AI model used to perform part of the diagnostics." },
      { section: "Profile", description: "Page where you can find information about your user, along with the possibility to edit your profile." },
    ],
    "RESEARCHERUSER": [{ section: "Model Configuration", description: "section to be able to upload the excels of model results" },
      { section: "Profile", description: "Page where you can find information about your user, along with the possibility to edit your profile." },
      ],
    "PUBLIC": []
  }

    constructor(
      private authService: AuthService,
      private userService: UserService,
    ) { }

    async ngOnInit() {
      this.isLogged = !!this.authService.getToken();

      if (!this.isLogged){
        return
      }

      this.userService.getUserRole().subscribe(
        role => {
          this.userRole = convertToUserRole(role);
          this.descriptions = this.sectionsDescription[this.userRole]
        },
        error => {
          console.error('Error retrieving user role', error);
        }
      );

      this.userService.getUserProfile().subscribe(
        userProfile => {
          this.username = userProfile.name
        },
        error => {
          console.error('Error retrieving user profile', error);
        }
      )
    }

}


