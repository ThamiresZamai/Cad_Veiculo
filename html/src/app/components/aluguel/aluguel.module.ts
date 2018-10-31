import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AluguelRoutingModule } from './aluguel-routing.module';
import { AluguelFormComponent } from './form/aluguel-form.component';
import { AluguelListComponent } from './list/aluguel-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    AluguelRoutingModule,
    FormsModule
  ],
  declarations: [AluguelFormComponent, AluguelListComponent]
})
export class AluguelModule { }
