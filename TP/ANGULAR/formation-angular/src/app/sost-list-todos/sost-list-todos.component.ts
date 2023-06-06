import { Observable } from 'rxjs';
import { Component, Input, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'sost-list-todos',
  templateUrl: './sost-list-todos.component.html',
  styleUrls: ['./sost-list-todos.component.css']
})
export class SostListTodosComponent implements OnInit {
  @Input() todos!: Todo[];
  todos$!: Observable<Todo[]>;

  constructor(private srvTodo: TodoService) { }

  ngOnInit(): void {
    this.todos$ = this.srvTodo.findAllObs();
  }


  deleteTodo(todo: Todo) {
    const position = this.todos.indexOf(todo);
    this.todos.splice(position, 1);
  }
}
