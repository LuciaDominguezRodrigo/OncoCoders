import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sectiontitle',
  imports: [],
  templateUrl: './sectiontitle.component.html',
})
export class SectiontitleComponent {
  @Input() label!: string
}
