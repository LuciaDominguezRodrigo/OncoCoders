import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClinicFormService {

  private apiUrl = 'https://localhost:8443/api/clinicForm/saveResponse1';

  constructor(private http: HttpClient) { }

  // Función para enviar la respuesta del formulario
  sendForm(formData: any): Observable<any> {

    return this.http.post<any>(this.apiUrl, formData);
  }

}
