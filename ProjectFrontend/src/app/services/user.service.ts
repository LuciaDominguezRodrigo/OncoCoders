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
      throw new Error('Email is required for unbanning the user');
    }

    return this.http.put<{ message: string }>(this.apiUrl + '/unban', { email });
  }

  banUser(email: string | undefined): Observable<{ message: string }> {
    if (!email) {
      throw new Error('Email is required for banning the user');
    }

    return this.http.put<{ message: string }>(this.apiUrl + '/ban', { email });
  }
}


