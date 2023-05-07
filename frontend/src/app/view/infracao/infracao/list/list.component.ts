import { Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Infracao } from 'src/app/shared/model/Infracao';

@Component({
  selector: 'infracao-list',
  templateUrl: 'list.component.html',
  styleUrls: ['./list.component.scss']
})

export class InfracaoListComponent {

  @Input()
  infracoes!: Infracao[];

  @Input()
  dataSource!: MatTableDataSource<Infracao>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

constructor(
  private router: Router,
  private route: ActivatedRoute,
){}

  redirectTo(path: any) {
    this.router.navigate([path], { relativeTo: this.route });
  }

}
