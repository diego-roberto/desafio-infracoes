import { Component, OnInit, Input } from '@angular/core';
import { Infracao } from 'src/app/shared/model/Infracao';
import { InfracaoService } from 'src/app/shared/service/infracao.service';


@Component({
    selector: 'overview-component',
    templateUrl: 'overview.component.html',
    styleUrls: ['./overview.component.scss'],
})
export class OverviewComponent implements OnInit {

    @Input() infracao: Infracao = new Infracao;

    ngOnInit(): void {}

    constructor(
        private infracaoService: InfracaoService
    ) { }

}
