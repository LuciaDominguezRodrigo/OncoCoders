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
  users: any[] = [{ name: "Paco Malaco", role: "MEDICUSER"}];

  constructor(private userService: UserService) {}

  ngOnInit(): void { // TODO Get All Users
    this.userService.getPatients().subscribe(
      (data) => {
        //this.users = data;
        //console.log(data);
      },
      (error) => { console.error('Error al obtener pacientes', error); }
    );
  }

  //TODO Ban Action
}
