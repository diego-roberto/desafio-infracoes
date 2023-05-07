import { Injectable } from '@angular/core';
import { HttpClientService } from "./http-client.service";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Infracao } from '../model/Infracao';

interface InfracaoApiResponse {
  infracao: any[];
}

@Injectable({
  providedIn: 'root'
})
export class InfracaoService {  

  private endpointInfracao = '/infracoes';
  
  constructor(
    private service: HttpClientService,
    private http: HttpClient
  ) { }
  
  getInfracaoList(): Observable<Infracao[]> {
    return this.http.get<InfracaoApiResponse>(`${this.endpointInfracao}/findAll`).pipe(
      map(response => {
        if (response.infracao) {
          return response.infracao.map(jsonInfracao => new Infracao().initializeWithJSON(jsonInfracao));
        } else {
          return [];
        }
      })
    );
  }
  
}