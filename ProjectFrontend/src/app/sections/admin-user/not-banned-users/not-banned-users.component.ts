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

  constructor(private userService: UserService) {}

  ngOnInit(): void { // TODO Get All Users
    this.loadUnbannedUsers();
  }

  //TODO Ban Action
  private loadUnbannedUsers() {
    this.userService.getUnBannedUsers().subscribe(
      (data) => {
        this.users = data; // Cargar la lista de usuarios
      },
      (error) => { console.error('Error al obtener usuarios baneados', error); }
    );
  }
}
