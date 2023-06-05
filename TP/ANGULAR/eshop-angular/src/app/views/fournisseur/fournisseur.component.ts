import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/fournisseur';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.css']
})
export class FournisseurComponent implements OnInit {
  // Liste de fournisseurs
  fournisseurs!: Fournisseur[];
  
  ngOnInit(): void {
    this.fournisseurs = [
      new Fournisseur(1, "Le nom", "Le responsable"),
      new Fournisseur(2, "GoPRO", "Thierry")
    ];
  }

  onAjoutFournisseur(fournisseurToAdd: Fournisseur) {
    this.fournisseurs.push(fournisseurToAdd);
  }

  onSupprimerFournisseur(fournisseurToRemove: Fournisseur) {
    const position = this.fournisseurs.indexOf(fournisseurToRemove);
    this.fournisseurs.splice(position, 1);
  }
}
