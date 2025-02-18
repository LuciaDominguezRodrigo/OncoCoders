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

  //TODO Unban Action
}
