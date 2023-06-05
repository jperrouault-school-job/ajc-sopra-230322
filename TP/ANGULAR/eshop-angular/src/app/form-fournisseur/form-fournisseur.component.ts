import { Component, Output, EventEmitter } from '@angular/core';
import { Fournisseur } from '../fournisseur';

@Component({
  selector: 'form-fournisseur',
  templateUrl: './form-fournisseur.component.html',
  styleUrls: ['./form-fournisseur.component.css']
})
export class FormFournisseurComponent {
  formFournisseur: Fournisseur = new Fournisseur(0, "", "");
  // @Input() fournisseurs!: Fournisseur[];
  @Output() ajout = new EventEmitter<Fournisseur>();

  ajouterFournisseur() {
    // this.fournisseurs.push(this.formFournisseur);
    this.ajout.emit(this.formFournisseur);
    this.formFournisseur = new Fournisseur(0, "", "");
  }
}
