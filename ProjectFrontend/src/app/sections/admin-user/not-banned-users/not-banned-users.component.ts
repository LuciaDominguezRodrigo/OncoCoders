import { Component } from '@angular/core';
import { SectiontitleComponent } from "../../../components/tags/sectiontitle/sectiontitle.component";
import { CommonModule } from '@angular/common';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-not-banned-users',
  imports: [SectiontitleComponent, CommonModule],
  templateUrl: './not-banned-users.component.html',
})
export class NotBannedUsersComponent {
  users: any[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit(): void { // TODO Get All Users
    this.loadUnbannedUsers();
  }


  private loadUnbannedUsers() {
    this.userService.getUnBannedUsers().subscribe(
      (data) => {
        this.users = data; // Cargar la lista de usuarios
      },
      (error) => {
        console.error('Error obtaining unbanned users', error);
      }
    );
  }

  banUser(email: string | undefined): void {
    if (!email) {
      console.error('Email not valid');
      return;
    }

    this.userService.banUser(email).subscribe(
      response => {
        alert(response.message);
        this.loadUnbannedUsers(); // Recargar lista de usuarios después de banear
      },
      error => {
        console.error('Error banning user', error);
      }
    );
  }
}
