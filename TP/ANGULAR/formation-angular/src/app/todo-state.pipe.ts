import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoState'
})
export class TodoStatePipe implements PipeTransform {
  transform(value: boolean, ...args: string[]): string {
    if (args[0] == "string") {
      // if (value) {
      //   return "OUI";
      // }
  
      // return "NON";
      return (value) ? "OUI" : "NON";
    }

    return (value) ? "hsl(153 48% 49%)" : "hsl(341 79% 53%)";

    // if (value) {
    //   return "hsl(153 48% 49%)";
    // }

    // return "hsl(341 79% 53%)";
  }
}
