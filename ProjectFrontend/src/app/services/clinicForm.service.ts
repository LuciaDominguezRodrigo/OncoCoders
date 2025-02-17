import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClinicFormService {

  private apiUrl = 'https://localhost:8443/api/clinicForm/';

  constructor(private http: HttpClient) { }

  // Función para enviar la respuesta del formulario
  sendForm(token: string | null, formData: any): Observable<any> {

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`
    });
    return this.http.post<any>(this.apiUrl + 'saveResponse1', formData, {headers});
  }

  sendForm2(token: string | null, formData: any): Observable<any> {

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`
    });
    return this.http.post<any>(this.apiUrl + '/saveResponse2' , formData, {headers});
  }

}
