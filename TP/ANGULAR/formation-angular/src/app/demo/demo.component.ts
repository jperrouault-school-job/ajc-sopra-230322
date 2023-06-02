import { Component, Input } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-demo,[app-demo]',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent {
  @Input() titre: string = "";
  @Input() todo!: Todo;
}
