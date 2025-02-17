import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BarChartModule, Color, ScaleType } from '@swimlane/ngx-charts';
import { RouterModule, Router } from '@angular/router';
import { ActionbuttonComponent } from "../../components/buttons/actionbutton/actionbutton.component";
import { LOGIN_SCREEN, REGISTER_SCREEN } from '../../routes';

@Component({
  selector: 'app-main',
  standalone: true,
  templateUrl: './main.component.html',
  imports: [CommonModule, RouterModule, BarChartModule, ActionbuttonComponent],
})
export class MainComponent {
  constructor(private router: Router) {}

  redirectToRegister() {
    this.router.navigate([REGISTER_SCREEN]);
  }

  redirectToLogin() {
    this.router.navigate([LOGIN_SCREEN]);
  }

  // Data for the chart
  single = [
    { name: 'Pacientes', value: 150 },
    { name: 'Investigadores', value: 50 },
    { name: 'Médicos', value: 80 }
  ];

  // Chart options
  view: [number, number] = [700, 400];

  // Color scheme
  colorScheme: Color = {
    name: 'custom',
    selectable: true,
    group: ScaleType.Ordinal,
    domain: ['#FF5733', '#33FF57', '#3357FF']
  };

  // Additional options
  showLegend = true;
  showLabels = true;
}
