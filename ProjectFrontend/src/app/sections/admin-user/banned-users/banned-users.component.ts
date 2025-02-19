import { Component } from '@angular/core';
import { SectiontitleComponent } from "../../../components/tags/sectiontitle/sectiontitle.component";
import { UserService } from '../../../services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-banned-users',
  imports: [SectiontitleComponent, CommonModule],
  templateUrl: './banned-users.component.html',
})
export class BannedUsersComponent {
  users: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void { // TODO Get All Users
    this.loadBannedUsers();
  }

  //TODO Unban Action
  private loadBannedUsers() {
    this.userService.getBannedUsers().subscribe(
      (data) => {
        this.users = data; // Cargar la lista de usuarios
      },
      (error) => { console.error('Error al obtener usuarios baneados', error); }
    );
  }
}
