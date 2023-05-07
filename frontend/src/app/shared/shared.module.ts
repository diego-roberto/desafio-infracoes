import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { NavbarComponent } from '../navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        MatListModule,
        MatTabsModule,
        MatTableModule,
        MatCardModule,
        MatToolbarModule
    ],
    exports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,        
        MatListModule,
        MatTabsModule,
        MatTableModule,
        MatCardModule,
        NavbarComponent,
        MatToolbarModule
    ],
    declarations: [
        NavbarComponent
    ]
})
export class SharedModule { }
