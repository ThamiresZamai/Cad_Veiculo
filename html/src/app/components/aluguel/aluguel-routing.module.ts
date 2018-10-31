import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AluguelListComponent } from './list/aluguel-list.component';
import { AluguelFormComponent } from './form/aluguel-form.component';

const routes: Routes = [

  { path: 'list', component: AluguelListComponent}, 
  { path: 'form', component: AluguelFormComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AluguelRoutingModule { }
