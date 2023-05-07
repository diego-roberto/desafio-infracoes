import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Infracao } from '../model/Infracao';

interface InfracaoApiResponse {
  map(arg0: (jsonInfracao: any) => Infracao): any;
  infracao: any[];
}

@Injectable({
  providedIn: 'root'
})
export class InfracaoService {

  private endpointInfracao = 'http://localhost:8080/infracoes';
  
  constructor(
    private http: HttpClient
  ) { }
  
  getInfracaoList(): Observable<Infracao[]> {
    return this.http.get<InfracaoApiResponse>(`${this.endpointInfracao}/findAll`).pipe(
      map(response => {
        if (response) {
          return response.map(jsonInfracao => new Infracao().initializeWithJSON(jsonInfracao));
        } else {
          return [];
        }
      })
    );
  }
  
}