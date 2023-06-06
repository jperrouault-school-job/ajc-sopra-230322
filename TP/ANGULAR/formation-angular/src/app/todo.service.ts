import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from './todo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private todos!: Todo[];

  constructor(private httpClient: HttpClient) {
    const obsTodos: Observable<Todo[]> =
      this.httpClient.get<Todo[]>('https://jsonplaceholder.typicode.com/todos');
    
    // Particularité des Observables : il faut s'inscrire et se désinscrire
    // !!! Tant qu'on ne s'inscrit pas, la fonction derrière l'Observable ne s'exécutera pas

    this.todos = [];
    console.log("ETAPE 1");
    
    obsTodos.subscribe(todos => {
      console.log("ETAPE 2");
      // On a reçu la liste des todos, que fait-on ?
      // console.log(todos);
      // this.todos = todos;
      for (let todo of todos) {
        this.todos.push(todo);
      }
    });

    // this.todos = [
    //   new Todo(1, "Prendre son café", true),
    //   new Todo(2, "Corriger l'exercice", false),
    //   new Todo(3, "Voir les composants", false)
    // ];
  }

  public findAll(): Todo[] {
    return this.todos;
  }
}
