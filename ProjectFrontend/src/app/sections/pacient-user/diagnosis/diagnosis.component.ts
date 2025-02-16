import { Component } from '@angular/core';
import { SectiontitleComponent } from '../../../components/tags/sectiontitle/sectiontitle.component';
import { AdviceComponent } from '../../../components/tags/advice/advice.component';

@Component({
  selector: 'app-diagnosis',
  imports: [SectiontitleComponent, AdviceComponent],
  templateUrl: './diagnosis.component.html',
  styleUrl: './diagnosis.component.css'
})
export class DiagnosisComponent {

}
