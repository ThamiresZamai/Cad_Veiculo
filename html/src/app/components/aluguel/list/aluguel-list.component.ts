import { Component, OnInit } from '@angular/core';
import { Veiculo } from '../../model/veiculo';
import { VeiculoService } from '../../service/veiculo.service';

@Component({
  selector: 'app-aluguel-list',
  templateUrl: './aluguel-list.component.html',
  styleUrls: ['./aluguel-list.component.css']
})
export class AluguelListComponent implements OnInit {

  veiculo : Veiculo;
  veiculos : Array<Veiculo>;
  constructor(private servicev : VeiculoService) { }

  ngOnInit() {
    this.veiculo = new Veiculo();
    this.veiculos = new Array();
    this.carragarTabela();
  }

  carragarTabela(){
    this.servicev.getVeiculo().subscribe(lstveiculo => this.veiculos = lstveiculo)
  }
}
