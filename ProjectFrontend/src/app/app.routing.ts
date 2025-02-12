import { Routes } from '@angular/router';
import { RegisterComponent } from './screens/register/register.component';
import { LoginComponent } from './screens/login/login.component';
import { AboutComponent } from './screens/about/about.component';
import { ProfileComponent } from './sections/profile/profile.component';
import { DASHBOARD_SPECIALIST_SCREEN, DIAGNOSIS_SCREEN, FORUM_SCREEN, MONITORING_SCREEN, PENDING_PACIENTS_SCREEN, PROCESSED_PACIENTS_SCREEN, PROFILE_PATIENT_SCREEN, RECOMMENDATION_SCREEN, RECORDS_SCREEN as HISTORIAL_SCREEN, PROFILE_SPECIALIST_SCREEN, DASHBOARD_ADMIN_SCREEN, BAN_SCREEN, UNBAN_SCREEN, IA_CONFIGURATION_SCREEN, PROFILE_ADMIN_SCREEN } from './routes';
import { DiagnosisComponent } from './sections/pacient-user/diagnosis/diagnosis.component';
import { MonitoringComponent } from './sections/pacient-user/monitoring/monitoring.component';
import { RecommendationsComponent as RecommendationsPatientComponent } from './sections/pacient-user/recommendations/recommendations.component';
import { ForumComponent } from './sections/pacient-user/forum/forum.component';
import { DashboardComponent } from './sections/dashboard/dashboard.component';
import { PendingPacientsComponent } from './sections/specialist-user/pending-pacients/pending-pacients.component';
import { ProcessedPacientsComponent } from './sections/specialist-user/processed-pacients/processed-pacients.component';
import { HistorialComponent } from './sections/specialist-user/historial/historial.component';
import { BannedUsersComponent } from './sections/admin-user/banned-users/banned-users.component';
import { NotBannedUsersComponent } from './sections/admin-user/not-banned-users/not-banned-users.component';
import { IAModelConfigurationComponent } from './sections/admin-user/ia-model-configuration/ia-model-configuration.component';
import { MainPageComponent } from './screens/mainPage/mainPage.component';
import {UserformComponent} from './screens/userform/userform.component';

export const routes: Routes = [
    {
    path: '',
    component: MainPageComponent,
    title: "OncoCoders",
    pathMatch: 'full' ,
  },  // Redirige al índice
  {
    path: 'login',
    component: LoginComponent,
    title: "Iniciar Sesión",
  },
  {
    path: 'register',
    component: RegisterComponent,
    title: "Registrarse",
  },
  {
    path: 'about',
    component: AboutComponent,
    title: "Sobre Nosotros",
  },
  {
    path: 'profile',
    component: ProfileComponent,
    title: "Perfil"
   },
  {
    path: 'userform',
    component: UserformComponent,
    title: "User form"
  },
  {
    path: DIAGNOSIS_SCREEN,
    component: DiagnosisComponent,
    title: "Diagnóstico - Paciente"
  },
  {
    path: MONITORING_SCREEN,
    component: MonitoringComponent,
    title: "Seguimiento - Paciente"
  },
  {
    path: RECOMMENDATION_SCREEN,
    component: RecommendationsPatientComponent,
    title: "Recomendaciones - Paciente"
  },
  {
    path: FORUM_SCREEN,
    component: ForumComponent,
    title: "Foro - Paciente"
  },
  {
    path: PROFILE_PATIENT_SCREEN,
    component: ProfileComponent,
    title: "Perfil - Paciente"
  },
  {
    path: DASHBOARD_SPECIALIST_SCREEN,
    component: DashboardComponent,
    title: "Dashboard - Especialista"
  },
  {
    path: PENDING_PACIENTS_SCREEN,
    component: PendingPacientsComponent,
    title: "Pacientes Pendientes - Especialista"
  },
  {
    path: PROCESSED_PACIENTS_SCREEN,
    component: ProcessedPacientsComponent,
    title: "Pacientes Procesados - Especialista"
  },
  {
    path: HISTORIAL_SCREEN,
    component: HistorialComponent,
    title: "Historial - Especialista"
  },
  {
    path: PROFILE_SPECIALIST_SCREEN,
    component: ProfileComponent,
    title: "Perfil - Especialista"
  },
  {
    path: DASHBOARD_ADMIN_SCREEN,
    component: DashboardComponent,
    title: "Dashboard - Admin"
  },
  {
    path: BAN_SCREEN,
    component: NotBannedUsersComponent,
    title: "Usuarios No Baneados - Admin"
  },
  {
    path: UNBAN_SCREEN,
    component: BannedUsersComponent,
    title: "Usuarios Baneados - Admin"
  },
  {
    path: IA_CONFIGURATION_SCREEN,
    component: IAModelConfigurationComponent,
    title: "Configuración IA - Admin"
  },
  {
    path: PROFILE_ADMIN_SCREEN,
    component: ProfileComponent,
    title: "Perfil - Admin"
  },

  {
    path: '**',
    redirectTo: 'login'
  },  // Redirigir cualquier ruta no válida al índice

];
