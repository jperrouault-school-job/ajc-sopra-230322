import { Produit } from './../../models/produit';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ProduitService } from 'src/app/services/produit.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { Fournisseur } from 'src/app/models/fournisseur';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {
  produits$!: Observable<Produit[]>;
  fournisseurs$!: Observable<Fournisseur[]>;
  produitForm?: FormGroup | null;
  nomCtrl!: FormControl;
  prixCtrl!: FormControl;
  modeleCtrl!: FormControl;
  referenceCtrl!: FormControl;
  fournisseurIdCtrl!: FormControl;
  editing: number = 0;

  constructor(title: Title, private srvProduit: ProduitService, private srvFournisseur: FournisseurService, private formBuilder: FormBuilder) {
    title.setTitle("Liste des produits");
  }

  ngOnInit(): void {
    this.reload();
  }

  ajouter() {
    this.editing = 0;
    this.fournisseurs$ = this.srvFournisseur.findAll();

    this.nomCtrl = this.formBuilder.control('', Validators.required);
    this.prixCtrl = this.formBuilder.control(0, Validators.min(1));
    this.modeleCtrl = this.formBuilder.control('', Validators.required);
    this.referenceCtrl = this.formBuilder.control('', Validators.required);
    this.fournisseurIdCtrl = this.formBuilder.control(0, Validators.min(1));

    this.produitForm = this.formBuilder.group({
      nom: this.nomCtrl,
      prix: this.prixCtrl,
      modele: this.modeleCtrl,
      reference: this.referenceCtrl,
      fournisseurId: this.fournisseurIdCtrl
    });
  }

  modifier(produit: Produit) {
    this.editing = produit.id;
    this.fournisseurs$ = this.srvFournisseur.findAll();

    this.nomCtrl = this.formBuilder.control(produit.nom, Validators.required);
    this.prixCtrl = this.formBuilder.control(produit.prix, Validators.min(1));
    this.modeleCtrl = this.formBuilder.control(produit.modele, Validators.required);
    this.referenceCtrl = this.formBuilder.control(produit.reference, Validators.required);
    this.fournisseurIdCtrl = this.formBuilder.control(produit.fournisseurId, Validators.min(1));

    this.produitForm = this.formBuilder.group({
      nom: this.nomCtrl,
      prix: this.prixCtrl,
      modele: this.modeleCtrl,
      reference: this.referenceCtrl,
      fournisseurId: this.fournisseurIdCtrl
    });
  }

  ajouterOuModifier() {
    let addOrEditObs: Observable<Produit>;
    const produit = {
      id: this.editing,
      nom: this.nomCtrl.value,
      prix: this.prixCtrl.value,
      modele: this.modeleCtrl.value,
      reference: this.referenceCtrl.value,
      fournisseurId: this.fournisseurIdCtrl.value
    };

    if (this.editing) {
      addOrEditObs = this.srvProduit.edit(produit);
    }

    else {
      addOrEditObs = this.srvProduit.add(produit);
    }

    addOrEditObs.subscribe(() => this.reload());
    this.stopAjouterOuModifier();
  }

  stopAjouterOuModifier() {
    this.editing = 0;
    this.produitForm = null;
  }

  supprimer(produit: Produit) {
    this.srvProduit.delete(produit)
      .subscribe(() => this.reload());
  }

  private reload() {
    this.produits$ = this.srvProduit.findAll();
  }
}
