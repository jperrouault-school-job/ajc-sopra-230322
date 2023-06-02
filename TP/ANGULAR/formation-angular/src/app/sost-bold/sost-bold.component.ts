import { Component } from '@angular/core';

@Component({
  selector: 'sost-bold',
  templateUrl: './sost-bold.component.html',
  styleUrls: ['./sost-bold.component.css']
})
export class SostBoldComponent {
  compteur: number = 0;

  onClick() {
    this.compteur++;
  }
}
