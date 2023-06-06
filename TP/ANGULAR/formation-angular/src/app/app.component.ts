import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Todo } from './todo';
import { Produit } from './produit';
import { DemoService } from './demo.service';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title: string = 'formation-angular';
  prenom: string = "Jérémy";
  couleur: string = "black";
  couleur2: string = "#FFFFFF";
  todo: Todo = new Todo(1, "Test");
  produit: Produit = new Produit("", 0);

  todos!: Todo[];

  personne = {
    nom: "TOTO",
    prenom: "Albert"
  }

  constructor(
    private srvDemo: DemoService,
    private srvTodo: TodoService) {
    this.srvDemo.hello();
  }

  ngOnInit(): void {
    console.log("ETAPE 3");
    
    this.todos = this.srvTodo.findAll();
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

  resetTodos() {
    this.todos.splice(3);
  }
}