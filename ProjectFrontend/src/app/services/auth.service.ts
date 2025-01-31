import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://localhost:8443/api/auth/';  // Cambia por la URL real de tu backend

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<User> {
    let url;
    url = this.apiUrl + 'login';
    return this.http.post<User>(url, { email, password }).pipe(
      catchError(error => {
        console.error('Error en la solicitud de login', error);
        alert('Las credenciales no son correctas o no está autenticado. Por favor, verifique que sus datos son los ' +
          'correctos.');
        throw error;  // Lanza el error para que el componente pueda manejarlo si es necesario
      })
    );
  }

  register(name: string, email: string, password: string, role: string): Observable<any> {
    const url = this.apiUrl + 'register';
    const body = { name, email, password, role };

    return this.http.post<any>(url, body).pipe(
      catchError((error) => {
        console.error('❌ Error en la solicitud de registro:', error);
        return throwError(() => error);
      })
    );
  }

}
