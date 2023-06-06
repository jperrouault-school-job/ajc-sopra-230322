import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private todos!: Todo[];

  constructor() {
    this.todos = [
      new Todo(1, "Prendre son café", true),
      new Todo(2, "Corriger l'exercice", false),
      new Todo(3, "Voir les composants", false)
    ];
  }

  public findAll(): Todo[] {
    return this.todos;
  }
}
