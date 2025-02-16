import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-actionbutton',
  templateUrl: './actionbutton.component.html',
  styleUrls: ['./actionbutton.component.css']
})
export class ActionbuttonComponent {
  @Input() label!: string;
  @Input() action!: () => void;

  ngOnInit() {
    if (!this.label) {
      throw new Error('The "label" input is required for <app-actionbutton>');
    }
  }
}
