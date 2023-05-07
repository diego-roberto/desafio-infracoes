import { Component, OnInit, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Infracao } from 'src/app/shared/model/Infracao';
import { InfracaoService } from 'src/app/shared/service/infracao.service';

@Component({
    selector: 'overview-component',
    templateUrl: 'overview.component.html',
    styleUrls: ['./overview.component.scss'],
})
export class OverviewComponent implements OnInit {
    
    infracoes!: Infracao[];
    dataSource!: MatTableDataSource<Infracao>;

    ngOnInit(): void {
      this.fetchInfracoes();      
    }
  
    constructor(private infracaoService: InfracaoService) {}
  
    fetchInfracoes() {
      this.infracaoService.getInfracaoList().subscribe((response) => {
        this.infracoes = response;
        this.dataSource = new MatTableDataSource<Infracao>(this.infracoes);
      });
    }

}
