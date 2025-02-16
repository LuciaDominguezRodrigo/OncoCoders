import { Component } from '@angular/core';
import { SectiontitleComponent } from '../../../components/tags/sectiontitle/sectiontitle.component';
import { AdviceComponent } from '../../../components/tags/advice/advice.component';

@Component({
  selector: 'app-recomendations',
  imports: [SectiontitleComponent, AdviceComponent],
  templateUrl: './recomendations.component.html'

})
export class RecomendationsComponent {

}
