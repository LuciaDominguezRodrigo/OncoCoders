import {Component, OnInit} from '@angular/core';
import { SectiontitleComponent } from "../../../components/tags/sectiontitle/sectiontitle.component";
import { UserService } from '../../../services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-banned-users',
  imports: [CommonModule, SectiontitleComponent],
  templateUrl: './banned-users.component.html',
})
export class BannedUsersComponent implements OnInit {
  users: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadBannedUsers();
  }


  private loadBannedUsers() {
    this.userService.getBannedUsers().subscribe(
      (data) => {
        this.users = data; // Cargar la lista de usuarios
      },
      (error) => { console.error('Error obtaining banned user', error); }
    );
  }

  unbanUser(email: string | undefined): void {
    if (!email) {
      console.error('Not valid email');
      return;
    }

    this.userService.unbanUser(email).subscribe(
      response => {
        alert(response.message);
        this.loadBannedUsers(); // Recargar lista de usuarios después de desbanear
      },
      error => {
        console.error('Error unbanning user', error);
      }
    );
  }

}
