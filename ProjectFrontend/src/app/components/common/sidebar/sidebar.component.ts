import { Component } from '@angular/core';
import { SidebarbuttonComponent } from "../../buttons/sidebarbutton/sidebarbutton.component";

@Component({
  selector: 'app-sidebar',
  imports: [SidebarbuttonComponent],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

}
