import { Component } from '@angular/core';
import { Fournisseur } from './fournisseur';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // Liste de fournisseurs
  fournisseurs: Fournisseur[] = [
    new Fournisseur(1, "Le nom", "Le responsable"),
    new Fournisseur(2, "GoPRO", "Thierry")
  ];

  onAjoutFournisseur(fournisseurToAdd: Fournisseur) {
    this.fournisseurs.push(fournisseurToAdd);
  }

  onSupprimerFournisseur(fournisseurToRemove: Fournisseur) {
    const position = this.fournisseurs.indexOf(fournisseurToRemove);
    this.fournisseurs.splice(position, 1);
  }
}
