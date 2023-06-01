import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'formation-angular';
  prenom: string = "Jérémy";

  personne = {
    nom: "TOTO",
    prenom: "Albert"
  }

}