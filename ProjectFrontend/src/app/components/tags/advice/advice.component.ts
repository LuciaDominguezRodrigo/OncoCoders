import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-advice',
  imports: [],
  templateUrl: './advice.component.html',
})
export class AdviceComponent {
  @Input() title!: string
  @Input() text!: string
}
