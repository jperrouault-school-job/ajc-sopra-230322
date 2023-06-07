import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { Fournisseur } from 'src/app/models/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.css']
})
export class FournisseurComponent implements OnInit {
  fournisseurs$!: Observable<Fournisseur[]>;
  fournisseurForm?: FormGroup | null;
  nomCtrl!: FormControl;
  responsableCtrl!: FormControl;
  editing: number = 0;

  constructor(title: Title, private srvFournisseur: FournisseurService, private formBuilder: FormBuilder) {
    title.setTitle("Liste des fournisseurs");
  }
  
  ngOnInit(): void {
    this.reload();
  }

  ajouter() {
    this.editing = 0;
    this.nomCtrl = this.formBuilder.control('', Validators.required);
    this.responsableCtrl = this.formBuilder.control('', Validators.required);

    this.fournisseurForm = this.formBuilder.group({
      nom: this.nomCtrl,
      responsable: this.responsableCtrl
    });
  }

  modifier(fournisseur: Fournisseur) {
    this.editing = fournisseur.id;
    this.nomCtrl = this.formBuilder.control(fournisseur.nom, Validators.required);
    this.responsableCtrl = this.formBuilder.control(fournisseur.responsable, Validators.required);

    this.fournisseurForm = this.formBuilder.group({
      nom: this.nomCtrl,
      responsable: this.responsableCtrl
    });
  }

  ajouterOuModifier() {
    let addOrEditObs: Observable<Fournisseur>;
    const fournisseur = {
      id: this.editing,
      nom: this.nomCtrl.value,
      responsable: this.responsableCtrl.value
    };

    if (this.editing) {
      addOrEditObs = this.srvFournisseur.edit(fournisseur);
    }

    else {
      addOrEditObs = this.srvFournisseur.add(fournisseur);
    }

    addOrEditObs.subscribe(() => this.reload());
    this.stopAjouterOuModifier();
  }

  stopAjouterOuModifier() {
    this.editing = 0;
    this.fournisseurForm = null;
  }

  supprimer(fournisseur: Fournisseur) {
    this.srvFournisseur
      .delete(fournisseur)
      .subscribe(() => this.reload());
  }

  private reload() {
    this.fournisseurs$ = this.srvFournisseur.findAll();
  }
}
