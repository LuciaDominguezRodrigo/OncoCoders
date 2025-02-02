import { Component } from '@angular/core';
import {NavbarComponent} from '../navbar/navbar.component';

@Component({
  selector: 'app-homepage',
  standalone: true,
  templateUrl: './mainPage.component.html',
  imports: [
    NavbarComponent
  ],
  styleUrls: ['./mainPage.component.css']
})
export class MainPageComponent { }
