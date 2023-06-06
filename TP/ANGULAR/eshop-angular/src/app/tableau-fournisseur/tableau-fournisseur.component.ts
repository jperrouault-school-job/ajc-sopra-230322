import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { Fournisseur } from '../fournisseur';
import { FournisseurService } from '../fournisseur.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'tableau-fournisseur',
  templateUrl: './tableau-fournisseur.component.html',
  styleUrls: ['./tableau-fournisseur.component.css']
})
export class TableauFournisseurComponent implements OnInit {
  @Output() supprimer: EventEmitter<Fournisseur> = new EventEmitter<Fournisseur>();
  fournisseurs$!: Observable<Fournisseur[]>;

  constructor(private srvFournisseur: FournisseurService) { }

  ngOnInit(): void {
    this.fournisseurs$ = this.srvFournisseur.findAll();
  }

  supprimerFournisseur(fournisseur: Fournisseur) {
    // const position = this.fournisseurs.indexOf(fournisseur);
    // this.fournisseurs.splice(position, 1);
    this.supprimer.emit(fournisseur);
  }
}
