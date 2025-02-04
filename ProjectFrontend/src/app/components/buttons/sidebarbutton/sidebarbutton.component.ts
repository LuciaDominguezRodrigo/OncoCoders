import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sidebarbutton',
  imports: [],
  templateUrl: './sidebarbutton.component.html',
  styleUrl: './sidebarbutton.component.css'
})
export class SidebarbuttonComponent {
  @Input() label!: string;

  ngOnInit() {
    if (!this.label) {
      throw new Error('The "label" input is required for <app-sidebarbutton>');
    }
  }
}
