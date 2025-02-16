import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FormService {

  private apiUrl = 'https://localhost:8443/api/form/formResponse';

  constructor(private http: HttpClient) {}

  sendForm(data: any, token: string | null): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`
    });

    return this.http.post(this.apiUrl, data, { headers});
  }

  downloadExcel(token: string | null, urlt:string) {
    const url = 'https://localhost:8443/api/excels/' + urlt;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`
    });

    return this.http.get(url, { headers, responseType: 'blob' });  // Especificamos que la respuesta es un blob
  }


}


