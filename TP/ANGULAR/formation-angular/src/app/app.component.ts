import { Component } from '@angular/core';
import { Todo } from './todo';
import { Produit } from './produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'formation-angular';
  prenom: string = "Jérémy";
  couleur: string = "black";
  couleur2: string = "#FFFFFF";
  todo: Todo = new Todo(1, "Test");
  produit: Produit = new Produit("", 0);

  todos: Todo[] = [
    new Todo(1, "Prendre son café", true),
    new Todo(2, "Corriger l'exercice", false),
    new Todo(3, "Voir les composants", false)
  ];


  personne = {
    nom: "TOTO",
    prenom: "Albert"
  }

  leNomFonction() {
    alert('Alerte générale');
  }

  resetPrenom(event: any) {
    console.log(event);
    
    this.prenom = "par défaut";
  }

  onChangePrenom(event: any) {
    this.prenom = event.target.value;
  }

  ajouterProduit() {
    alert("Produit ajouté !");
  }

  resetProduit() {
    // Solution #1
    // this.produit.nom = "";
    // this.produit.prix = 0;

    // Solution #2
    this.produit = new Produit("", 0);
  }

  ajouterTodo() {
    this.todos.push(this.todo);
    this.todo = new Todo(42, "");
  }
}