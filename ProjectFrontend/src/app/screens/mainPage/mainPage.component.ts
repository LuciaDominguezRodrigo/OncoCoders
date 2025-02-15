import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BarChartModule, Color, ScaleType} from '@swimlane/ngx-charts';

@Component({
  selector: 'app-main-page',
  standalone: true,
  templateUrl: './mainPage.component.html',
  imports: [CommonModule, BarChartModule],
})
export class MainPageComponent {
  // Datos para la gráfica
  single = [
    { name: 'Pacientes', value: 150 },
    { name: 'Investigadores', value: 50 },
    { name: 'Médicos', value: 80 }
  ];

  // Opciones de la gráfica
  view: [number, number] = [700, 400];

  // Colores
  colorScheme: Color = {
    name: 'custom',
    selectable: true,
    group: ScaleType.Ordinal,
    domain: ['#FF5733', '#33FF57', '#3357FF']
  };

  // Opciones adicionales
  showLegend = true;
  showLabels = true;
}
