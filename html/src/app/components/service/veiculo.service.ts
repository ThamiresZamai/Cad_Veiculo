import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Veiculo } from '../model/veiculo';
import { HttpClient } from '@angular/common/http';

const URL : string = "http://localhost:8080/veiculo"

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  constructor(private http : HttpClient) { }

  postVeiculo(veiculo : Veiculo) : Observable<Veiculo>{
    return this.http.post<Veiculo>(URL , veiculo)
  }

  getVeiculo() : Observable<Veiculo[]>{
    return this.http.get<Veiculo[]>(URL)
  }

  getDuplo(placa : string) : Observable<Veiculo>{
    return this.http.get<Veiculo>(URL + "/" + placa)
  }
}
