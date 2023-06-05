import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TableauFournisseurComponent } from './tableau-fournisseur/tableau-fournisseur.component';
import { FormFournisseurComponent } from './form-fournisseur/form-fournisseur.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    TableauFournisseurComponent,
    FormFournisseurComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
