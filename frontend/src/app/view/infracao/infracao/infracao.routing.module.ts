import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OverviewComponent } from './overview/overview.component';
import { InfracaoListComponent } from './list/list.component';


const ROUTER: Routes = [
    {
        path: '', component: OverviewComponent,
        children: [
            { path: '', redirectTo: '/infracoes', pathMatch: 'full' },
            { path: 'infracoes', component: InfracaoListComponent },
        ]
    },
];

@NgModule({
    imports: [
        RouterModule.forChild(ROUTER)
    ],
    exports: [
        RouterModule
    ]
})
export class InfracaoRoutingModule { }

