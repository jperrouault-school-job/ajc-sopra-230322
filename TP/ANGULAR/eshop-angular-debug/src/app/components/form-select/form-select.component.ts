import { Component, Input, forwardRef } from '@angular/core';
import { ControlValueAccessor, FormControl, NG_VALUE_ACCESSOR } from '@angular/forms';

@Component({
  selector: 'sost-form-select',
  templateUrl: './form-select.component.html',
  styleUrls: ['./form-select.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => FormSelectComponent),
      multi: true
    }
  ]
})
export class FormSelectComponent implements ControlValueAccessor {
  @Input() id!: string;
  @Input() label!: string;
  @Input() items?: any[] | null;
  @Input() itemValue: string = "id";
  @Input() itemLabel: string = "label";
  @Input() formControl?: FormControl;
  @Input('message-when-not-valid') invalidMessage!: string;

  value: string = "";
  disabled: boolean = false;

  onChange = (value: string) => {};
  onTouched = () => {};

  writeValue(obj: any): void {    
    this.value = obj;
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    this.disabled = isDisabled;
  }
}
