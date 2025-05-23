import { Routes } from '@angular/router';
import { RegisterComponent } from './screens/register/register.component';
import { LoginComponent } from './screens/login/login.component';
import { AboutComponent } from './screens/about/about.component';
import { ProfileComponent } from './sections/profile/profile.component';
import {
  DASHBOARD_SPECIALIST_SCREEN,
  DIAGNOSIS_SCREEN,
  PACIENTS_SCREEN,

  PROFILE_PATIENT_SCREEN,
  RECOMMENDATION_SCREEN,
  PROFILE_SPECIALIST_SCREEN,
  DASHBOARD_ADMIN_SCREEN,
  BAN_SCREEN,
  UNBAN_SCREEN,
  IA_CONFIGURATION_SCREEN,
  PROFILE_ADMIN_SCREEN,
  USER_FORM_SCREEN,
  ABOUT_SCREEN,
  REGISTER_SCREEN,
  LOGIN_SCREEN,
  HOME_SCREEN,
  MAIN_SCREEN,
} from './routes';
import { DiagnosisComponent } from './sections/pacient-user/diagnosis/diagnosis.component';
import { DashboardComponent } from './sections/dashboard/dashboard.component';
import { PatientsComponent } from './sections/specialist-user/patients/patients.component';
import { BannedUsersComponent } from './sections/admin-user/banned-users/banned-users.component';
import { NotBannedUsersComponent } from './sections/admin-user/not-banned-users/not-banned-users.component';
import { ModelconfigurationComponent } from './sections/researcher-user/ia-model-configuration/Modelconfiguration.component';
import { MainComponent } from './screens/main/main.component';
import { UserformComponent } from './screens/userform/userform.component';
import { RecomendationsComponent } from './sections/pacient-user/recomendations/recomendations.component';
import { HomeComponent } from './screens/home/home.component';
import { ClinicformComponent } from './screens/clinicform/clinicform.component';
import { Clinicform2Component } from './screens/clinicform2/clinicform2.component';

export const routes: Routes = [
  {
    path: MAIN_SCREEN,
    component: MainComponent,
    title: "OncoCoders",
    pathMatch: 'full',
  },
  {
    path: HOME_SCREEN,
    component: HomeComponent,
    title: "OncoCoders",
  },
  {
    path: LOGIN_SCREEN,
    component: LoginComponent,
    title: "Log in",
  },
  {
    path: REGISTER_SCREEN,
    component: RegisterComponent,
    title: "Register",
  },
  {
    path: ABOUT_SCREEN,
    component: AboutComponent,
    title: "About us",
  },
  { // TODO Check this route
    path: 'profile',
    component: ProfileComponent,
    title: "Profile"
  },
  {
    path: USER_FORM_SCREEN,
    component: UserformComponent,
    title: "User form"
  },
  {
    path: 'clinicform',
    component: ClinicformComponent,
    title: "Clinic form"
  },
  {
    path: 'clinicformrelapse',
    component: Clinicform2Component,
    title: "Clinic form relapse"
  },
  {
    path: DIAGNOSIS_SCREEN,
    component: DiagnosisComponent,
    title: "Diagnosis- Patient"
  },
  {
    path: RECOMMENDATION_SCREEN,
    component: RecomendationsComponent,
    title: "Recommendations - Patient"
  },
  {
    path: PROFILE_PATIENT_SCREEN,
    component: ProfileComponent,
    title: "Profile - Patient"
  },
  {
    path: DASHBOARD_SPECIALIST_SCREEN,
    component: DashboardComponent,
    title: "Dashboard - Specialist"
  },
  {
    path: PACIENTS_SCREEN,
    component: PatientsComponent,
    title: "Pacients List"
  },

  {
    path: PROFILE_SPECIALIST_SCREEN,
    component: ProfileComponent,
    title: "Profile"
  },
  {
    path: DASHBOARD_ADMIN_SCREEN,
    component: DashboardComponent,
    title: "Dashboard - Admin"
  },
  {
    path: BAN_SCREEN,
    component: BannedUsersComponent,
    title: "Not Banned users - Admin"
  },
  {
    path: UNBAN_SCREEN,
    component: NotBannedUsersComponent,
    title: "Usuarios Banned - Admin"
  },
  {
    path: IA_CONFIGURATION_SCREEN,
    component: ModelconfigurationComponent,
    title: "IA Configuration - Admin"
  },
  {
    path: PROFILE_ADMIN_SCREEN,
    component: ProfileComponent,
    title: "Profile - Admin"
  },
  {
    path: '**',
    redirectTo: 'login'
  },  // Redirigir cualquier ruta no válida al índice

];
