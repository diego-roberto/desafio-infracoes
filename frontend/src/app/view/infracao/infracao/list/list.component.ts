import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Infracao } from 'src/app/shared/model/Infracao';
import { InfracaoService } from 'src/app/shared/service/infracao.service';


@Component({
  selector: 'infracao-list',
  templateUrl: 'list.component.html',
  styleUrls: ['./list.component.scss']
})

export class InfracaoListComponent implements OnInit {

  @Input()
  infracao!: Infracao;
  infracoes!: Infracao[];

constructor(
  private router: Router,
  private route: ActivatedRoute,
  private infracaoService: InfracaoService
){}

  ngOnInit() {
    this.fetchInfracoes();
  }

  fetchInfracoes() {
    this.infracaoService.getInfracaoList().subscribe((response) => {
      this.infracoes = response;
    });
  }

  redirectTo(path: any) {
    this.router.navigate([path], { relativeTo: this.route });
  }

}
