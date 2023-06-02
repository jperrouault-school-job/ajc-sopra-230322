import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'demo'
})
export class DemoPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): string {
    if (args[0] == false) {
      return "C'était pas vrai";
    }

    if (value.startsWith("P")) {
      return value + args[0];
    }

    return value;
  }
}
