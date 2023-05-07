import { NgModule } from '@angular/core';

import { SharedModule } from '../../../shared/shared.module'
import { OverviewComponent } from './overview/overview.component';
import { InfracaoListComponent } from './list/list.component';
import { InfracaoRoutingModule } from './infracao.routing.module';

@NgModule({
  imports: [
    SharedModule,
    InfracaoRoutingModule,
  ],
  declarations: [
    InfracaoListComponent,
    OverviewComponent
  ],
  entryComponents: [
    OverviewComponent,
  ]
})
export class InfracaoModule { }
