import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Fournisseur } from '../fournisseur';

@Component({
  selector: 'tableau-fournisseur',
  templateUrl: './tableau-fournisseur.component.html',
  styleUrls: ['./tableau-fournisseur.component.css']
})
export class TableauFournisseurComponent {
  @Input() fournisseurs!: Fournisseur[];
  @Output() supprimer: EventEmitter<Fournisseur> = new EventEmitter<Fournisseur>();

  supprimerFournisseur(fournisseur: Fournisseur) {
    // const position = this.fournisseurs.indexOf(fournisseur);
    // this.fournisseurs.splice(position, 1);
    this.supprimer.emit(fournisseur);
  }
}
