import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import { SectiontitleComponent } from "../../components/tags/sectiontitle/sectiontitle.component";
import { AdviceComponent } from "../../components/tags/advice/advice.component";
import {BarChartModule, PieChartModule} from '@swimlane/ngx-charts';
import {UserService} from '../../services/user.service';
import {NgIf, NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [SectiontitleComponent, AdviceComponent, PieChartModule, BarChartModule, NgIf, NgOptimizedImage],
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit{

  bannedUsersCount = 0; // Contador de usuarios baneados
  nonBannedUsersCount = 0; // Contador de usuarios no baneados
  role: string | null = null;

  // Datos para la gráfica
  single = [
    { name: 'Banned users', value: this.bannedUsersCount },
    { name: 'Not banned users', value: this.nonBannedUsersCount },
  ];

  // Configuración de la gráfica
  view: [number, number] = [700, 400]; // Tamaño de la gráfica (anchura, altura)
  showLegend = true; // Mostrar leyenda
  showLabels = true; // Mostrar etiquetas
  explodeSlices = false; // Explosión de las porciones al hacer hover
  doughnut = false; // Gráfico tipo dona (falso para gráfico de torta)



  constructor(private userService: UserService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadUserRole();
    this.loadUserData();
  }

  loadUserData(): void {
    // Obtener los usuarios baneados
    this.userService.getBannedUsers().subscribe(
      (bannedUsers) => {
        this.bannedUsersCount = bannedUsers.length;
        this.updateChart();
      },
      (error) => {
        console.error('Error obtainning banned users', error);
      }
    );

    // Obtener los usuarios no baneados
    this.userService.getUnBannedUsers().subscribe(
      (unbannedUsers) => {
        this.nonBannedUsersCount = unbannedUsers.length;
        this.updateChart();
      },
      (error) => {
        console.error('Error obtaining unbanned users:', error);
      }
    );


  }

  isAdminUser = false;

  loadUserRole(): void {
    this.userService.getUserRole().subscribe(
      (response) => {
        this.role = response.trim();
        this.isAdminUser = this.role === 'ADMIN';
        this.cdr.detectChanges();
      },
      (error) => {
        console.error("Error obtaining user", error);
      }
    );
  }


  updateChart(): void {
    // Actualizar los datos de la gráfica
    this.single = [
      { name: 'Banned', value: this.bannedUsersCount },
      { name: 'Unbanned', value: this.nonBannedUsersCount },
    ];
  }
}
