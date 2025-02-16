import { Component } from '@angular/core';
import { SectiontitleComponent } from '../../../components/tags/sectiontitle/sectiontitle.component';
import { AdviceComponent } from '../../../components/tags/advice/advice.component';

@Component({
  selector: 'app-monitoring',
  imports: [SectiontitleComponent, AdviceComponent],
  templateUrl: './monitoring.component.html',
})
export class MonitoringComponent {

}
