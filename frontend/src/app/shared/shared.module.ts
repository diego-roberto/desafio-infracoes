import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        MatListModule,
        MatTabsModule,
        MatTableModule,
        MatCardModule,
        MatPaginatorModule
    ],
    exports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,        
        MatListModule,
        MatTabsModule,
        MatTableModule,
        MatCardModule,
        MatPaginatorModule
    ],
})
export class SharedModule { }
