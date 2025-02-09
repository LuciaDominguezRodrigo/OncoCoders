import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map, Observable} from 'rxjs';


interface UserRoleResponse {
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


}


