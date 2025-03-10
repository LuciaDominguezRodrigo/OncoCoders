import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map, Observable} from 'rxjs';


interface UserRoleResponse {
  role: string;
}
interface User {
  id: number;
  name: string;
  roles: string[];  // Es un array de strings
  banned: boolean;
  email: string;
  comunidadAutonoma: string;
  hospitalReferencia: string;
  consentFirm: boolean;
  pacientes: User[]; // Puede contener otros usuarios si es un MEDICUSER
  role: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'https://localhost:8443/api/user';

  constructor(private http: HttpClient) {
  }

  getToken(): string | null {
    return localStorage.getItem('token') || '';
  }

  getUserRole(): Observable<string> {
    return this.http.get<UserRoleResponse>(`${this.apiUrl}/role`, {
      headers: new HttpHeaders({
        'Authorization': `Bearer ${this.getToken()}`
      })
    }).pipe(
      map(response => response.role)
    );

  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('token')}`,
      'Content-Type': 'application/json'
    });
  }

  getUserProfile(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });
    return this.http.get<any>(`${this.apiUrl}/profile`, { headers });
  }

  updateUserName(newName: string): Observable<any> {
    return this.http.put(`${this.apiUrl}/profile/name`, { newName }, { headers: this.getHeaders() });
  }

  updateUserHospital(newHospital: string): Observable<any> {
    return this.http.put(`${this.apiUrl}/profile/hospital`, { newHospital }, { headers: this.getHeaders() });
  }

  updateUserZone(newZone: string): Observable<any> {
    return this.http.put(`${this.apiUrl}/profile/zone`, { newZone }, { headers: this.getHeaders() });
  }

  getPatients(): Observable<any[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<any[]>(this.apiUrl + '/patients', { headers });
  }


  getBannedUsers() {
    return this.http.get<any[]>(this.apiUrl + '/banned-users');
  }

  getUnBannedUsers() {
    return this.http.get<any[]>(this.apiUrl + '/unbanned-users');
  }

  unbanUser(email: string | undefined): Observable<{ message: string }> {
    if (!email) {
      throw new Error('El email es requerido para desbanear un usuario');
    }

    return this.http.put<{ message: string }>(this.apiUrl + '/unban', { email });
  }

  banUser(email: string | undefined): Observable<{ message: string }> {
    if (!email) {
      throw new Error('El email es requerido para desbanear un usuario');
    }

    return this.http.put<{ message: string }>(this.apiUrl + '/ban', { email });
  }

  getCurrentUser(token: string | null) : Observable<User>{

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`
    });

    return this.http.get<User>(this.apiUrl + '/current', { headers});
  }

  getLatestCompleteDiagnosis(idToUse: number): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('token')}`,
      'Content-Type': 'application/json'
    });

    // Hacer la solicitud HTTP GET a la API
    return this.http.get<any>(`https://localhost:8443/api/diagnosis/latest-complete?userId=${idToUse}
`, { headers });
  }
}


