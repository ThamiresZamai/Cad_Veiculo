import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fabricante } from '../model/fabricante';

const URL : string = "http://localhost:8080/fabricante"

@Injectable({
  providedIn: 'root'
})
export class FabricanteService {

  constructor(private http : HttpClient) { }

  getFabricante() : Observable<Fabricante[]>{
    return this.http.get<Fabricante[]>(URL)
  }

  getIDFabricante(id : number) : Observable<Fabricante>{
    return this.http.get<Fabricante>(URL + "/" + id)
  }
}
