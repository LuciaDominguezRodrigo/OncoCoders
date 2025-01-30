import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https:/localhost:8443/api/auth/login';  // Cambia por la URL real de tu backend

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<User> {
    return this.http.post<User>(this.apiUrl, { email, password }).pipe(
      catchError(error => {
        console.error('Error en la solicitud de login', error);
        throw error;  // Lanza el error para que el componente pueda manejarlo si es necesario
      })
    );
  }
}
