import { Component, Input } from '@angular/core';

@Component({
  selector: 'sost-text-field',
  templateUrl: './sost-text-field.component.html',
  styleUrls: ['./sost-text-field.component.css']
})
export class SostTextFieldComponent {
  @Input() label: string = "";
}
