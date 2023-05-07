import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class HttpClientService {

  private url = "http://localhost:8080";
  private dockerizedUrl = "https://backend.docker.localhost";

  constructor(private http: HttpClient) { }

  private standardHeaders(): HttpHeaders {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    headers.set('X-Authorization', '');

    return headers;
  }

  private blankHeaders(): HttpHeaders {
    return new HttpHeaders({
      'X-Authorization': ""
    });
  }

  get(path: string): Observable<any> {
    return this.http.get<any>(`${this.url}${path}`, { headers: this.standardHeaders() });
  }

  getAbsolutePath(path: string): string {
    return `${this.url}${path}`;
  }

}

