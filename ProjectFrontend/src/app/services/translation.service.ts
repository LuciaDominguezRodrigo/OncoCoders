import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TranslationService {

  constructor(private http: HttpClient) { }

  private apiUrl = 'https://localhost:5000/translate';
  private sourceLanguage = 'auto';
  private targetLanguage = 'es';

  translate(q: string): Observable<any> {
    const body = {q, 'source': this.sourceLanguage, 'target': this.targetLanguage, format: 'text'};
    return this.http.post<any>(this.apiUrl, body);
  }

  changeTargetLanguage(t: string) {
    this.targetLanguage = t;
  }
}
