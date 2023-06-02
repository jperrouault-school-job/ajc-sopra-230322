import { Component, Input } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'sost-list-todos',
  templateUrl: './sost-list-todos.component.html',
  styleUrls: ['./sost-list-todos.component.css']
})
export class SostListTodosComponent {
  @Input() todos!: Todo[];

  deleteTodo(todo: Todo) {
    const position = this.todos.indexOf(todo);
    this.todos.splice(position, 1);
  }
}
