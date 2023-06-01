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