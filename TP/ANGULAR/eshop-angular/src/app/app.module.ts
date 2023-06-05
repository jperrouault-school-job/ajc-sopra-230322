import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TableauFournisseurComponent } from './tableau-fournisseur/tableau-fournisseur.component';
import { FormFournisseurComponent } from './form-fournisseur/form-fournisseur.component';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [
    AppComponent,
    TableauFournisseurComponent,
    FormFournisseurComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MatInputModule,
    MatIconModule,
    MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
