import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Modelo } from '../model/modelo';
import { HttpClient } from '@angular/common/http';

const URL : string = "http://localhost:8080/modelo"

@Injectable({
  providedIn: 'root'
})
export class ModeloService {

  constructor(private http : HttpClient) { }

  getModelo(id : number) : Observable<Modelo[]>{
    return this.http.get<Modelo[]>(URL + "/" + id)
  }

}
