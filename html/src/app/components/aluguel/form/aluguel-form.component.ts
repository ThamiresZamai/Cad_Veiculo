import { Component, OnInit } from '@angular/core';
import { Modelo } from '../../model/modelo';
import { Veiculo } from '../../model/veiculo';
import { ModeloService } from '../../service/modelo.service';
import { FabricanteService } from '../../service/fabricante.service';
import { Fabricante } from '../../model/fabricante';
import { VeiculoService } from '../../service/veiculo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aluguel-form',
  templateUrl: './aluguel-form.component.html',
  styleUrls: ['./aluguel-form.component.css']
})
export class AluguelFormComponent implements OnInit {

  veiculo : Veiculo;
  modelos : Array<Modelo>;
  fabricantes : Array<Fabricante>;
  placa : string;
  id : number;
  constructor( 
    private router : Router,
    private servicem : ModeloService,
    private servicef : FabricanteService,
    private servicev : VeiculoService
    ) { }

  ngOnInit() {
    this.veiculo = new Veiculo();
    this.modelos = new Array();
    this.fabricantes = new Array();
    this.veiculo.modelodto = new Modelo();
    this.veiculo.modelodto.fabricantedto = new Fabricante();
    //this.carregaModelo();
    this.servicef.getFabricante().subscribe(lstfabricantes => this.fabricantes = lstfabricantes)
  }

  carregaModelo(){
    this.servicem.getModelo(this.veiculo.modelodto.fabricantedto.id).subscribe(lstmodelos => this.modelos = lstmodelos)
  }

  salvar(){
    this.servicev.postVeiculo(this.veiculo).subscribe(()=>{
     this.router.navigate(['/aluguel/list']);
  }, (err) => {
      alert(err.error.message)
  });
  }
}
