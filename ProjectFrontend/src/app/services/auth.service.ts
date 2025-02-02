import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {LoginResponse} from './LoginResponse';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  private apiUrl = 'https://localhost:8443';

  login(email: string, password: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.apiUrl + '/api/auth/login', { email, password });
  }

  saveToken(token: string) {
    localStorage.setItem('token', token);
  }

  register(name: string, email: string, password: string, comunidadAutonoma: string, hospitalRef: string): Observable<any> {
    const body = { name, email, password, comunidadAutonoma, hospitalRef };
    return this.http.post<any>(this.apiUrl + '/api/auth/register', body);
  }
}
