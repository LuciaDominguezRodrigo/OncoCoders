import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-sidebarbutton',
  imports: [
    CommonModule,
    RouterModule
  ],
  templateUrl: './sidebarbutton.component.html',
})
export class SidebarbuttonComponent {
  @Input() label!: string;
  @Input() router!: string;

  ngOnInit() {
    if (!this.label) {
      throw new Error('The "label" input is required for <app-sidebarbutton>');
    }
  }
}
