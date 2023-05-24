import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  

  produits = [
    { "nom": "Le produit 1" },
    { "nom": "Le produit 2" },
    { "nom": "Le produit 3" }
  ]

  chargerProduits() {
    fetch('http://localhost:8080/eshop-spring-mvc-correction/api/produit')
      .then(resp => resp.json())
      .then(produits => this.produits = produits);
  }

  supprimerProduit(produit: any) {
    fetch(`http://localhost:8080/eshop-spring-mvc-correction/api/produit/${ produit.id }`, {
      method: 'DELETE'
    }).then(() => this.chargerProduits());
  }

}
