import { FormGroup } from '@angular/forms';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'sost-form-card',
  templateUrl: './form-card.component.html',
  styleUrls: ['./form-card.component.css']
})
export class FormCardComponent {
  @Input() title!: string;
  @Input('ok-label') okLabel!: string;
  @Input() cancellable: boolean = false;
  @Input() formGroup!: FormGroup;
  @Output() ok: EventEmitter<void> = new EventEmitter<void>();
  @Output() cancel: EventEmitter<void> = new EventEmitter<void>();

  doOk() {
    this.ok.emit();
  }

  doCancel() {
    this.cancel.emit();
  }
}
