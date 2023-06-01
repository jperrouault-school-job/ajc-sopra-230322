import { Component } from '@angular/core';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'formation-angular';
  prenom: string = "Jérémy";
  couleur: string = "black";
  couleur2: string = "#FFFFFF";

  personne = {
    nom: "TOTO",
    prenom: "Albert"
  }

  leNomFonction() {
    alert('Alerte générale');
  }

  resetPrenom(event: any) {
    console.log(event);
    
    this.prenom = "par défaut";
  }

  onChangePrenom(event: any) {
    this.prenom = event.target.value;
  }
}