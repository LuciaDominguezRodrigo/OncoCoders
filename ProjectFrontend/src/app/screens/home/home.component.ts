import { Component } from '@angular/core';
import { Color, ScaleType } from '@swimlane/ngx-charts';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
})
export class HomeComponent {

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
