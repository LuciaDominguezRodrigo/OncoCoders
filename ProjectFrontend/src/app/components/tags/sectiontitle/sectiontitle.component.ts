import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sectiontitle',
  imports: [],
  templateUrl: './sectiontitle.component.html',
  styleUrl: './sectiontitle.component.css'
})
export class SectiontitleComponent {
  @Input() label!: string
}
