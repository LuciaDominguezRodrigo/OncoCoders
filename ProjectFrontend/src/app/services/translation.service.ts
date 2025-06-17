import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {catchError, delayWhen, map, Observable, of, retryWhen, take, timer} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TranslationService  {

  constructor(private http: HttpClient) { }

  private apiUrl = 'https://localhost:5000/translate';
  private sourceLanguage = 'auto';
  private targetLanguage = 'es';

  checkServerStatus(): Observable<boolean> {
    const body = { q: 'Hello world!', source: 'en', target: 'es' };

    return this.http.post('http://localhost:5000/translate', body, {
      observe: 'response'
    }).pipe(
      map(response => response.status >= 200 && response.status < 300),
      retryWhen(errors =>
        errors.pipe(
          delayWhen(() => timer(2000)), // espera 2 segundos entre intentos
        )
      ),
      catchError(() => of(false)) // si después de 5 intentos falla, devuelve false
    );
  }


  translate(q: string): Observable<any> {
    const body = {q, 'source': this.sourceLanguage, 'target': this.targetLanguage, format: 'text'};
    return this.http.post<any>(this.apiUrl, body);
  }

  changeTargetLanguage(t: string) {
    this.targetLanguage = t;
  }
}
