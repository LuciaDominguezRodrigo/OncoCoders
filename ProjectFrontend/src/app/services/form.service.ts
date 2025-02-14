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

  downloadExcel() {
    const url = '/api/excels/download-excel/Modelo2_autopredicción_paciente';
    this.http.get(url, { responseType: 'blob' as 'json', withCredentials: true }).subscribe((response: any) => {
      const blob = new Blob([response], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      const downloadURL = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = downloadURL;
      link.download = 'Modelo2_autopredicción_paciente.xlsx';
      link.click();
    });
  }

}


