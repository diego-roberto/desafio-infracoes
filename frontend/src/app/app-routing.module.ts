import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/infracoes', pathMatch: 'full' },
  { path: 'infracoes', loadChildren: () => import('./view/infracao/infracao/infracao.module').then(m => m.InfracaoModule) },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }