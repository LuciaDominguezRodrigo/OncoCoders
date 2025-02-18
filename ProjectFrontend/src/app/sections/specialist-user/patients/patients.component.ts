import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {NgForOf, NgIf} from '@angular/common';
import {SectiontitleComponent} from '../../../components/tags/sectiontitle/sectiontitle.component';

@Component({
  selector: 'app-pending-pacients',
  imports: [
    NgForOf,
    NgIf,
    SectiontitleComponent
  ],
  templateUrl: './patients.component.html'
})
export class PatientsComponent implements OnInit {

  patients: any[] = [];
  expandedPatient: any = null;


  constructor(private patientService: UserService) {}

  ngOnInit(): void {
    this.patientService.getPatients().subscribe(
      (data) => { this.patients = data; console.log(data); },
      (error) => { console.error('Error al obtener pacientes', error); }
    );
  }

  toggleDetails(patient: any): void {
    this.expandedPatient = this.expandedPatient === patient ? null : patient;
  }
}
