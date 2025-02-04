import { Component } from '@angular/core';
import {NavbarComponent} from '../../components/navbar/navbar.component';
import { SidebarComponent } from "../../components/common/sidebar/sidebar.component";
import { HomePageComponent } from "../home-page/home-page.component";

@Component({
  selector: 'app-homepage',
  standalone: true,
  templateUrl: './mainPage.component.html',
  imports: [
    NavbarComponent,
    HomePageComponent
],
  styleUrls: ['./mainPage.component.css']
})
export class MainPageComponent { }
