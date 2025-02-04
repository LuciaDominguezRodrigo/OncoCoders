import { Component } from '@angular/core';
import {HomePageComponent} from '../home-page/home-page.component';
import {NavbarComponent} from '../../components/navbar/navbar.component';

@Component({
  selector: 'app-about',
  imports: [
    NavbarComponent
  ],
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent {

}
