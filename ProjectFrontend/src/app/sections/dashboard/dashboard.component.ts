import { Component } from '@angular/core';
import { SectiontitleComponent } from "../../components/tags/sectiontitle/sectiontitle.component";
import { AdviceComponent } from "../../components/tags/advice/advice.component";

@Component({
  selector: 'app-dashboard',
  imports: [SectiontitleComponent, AdviceComponent],
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent {

}
