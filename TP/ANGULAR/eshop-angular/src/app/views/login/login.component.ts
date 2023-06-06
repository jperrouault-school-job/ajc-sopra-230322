import { Component } from '@angular/core';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = "";
  password: string = "";
  erreur: boolean = false;

  constructor(private srvAuth: AuthenticationService) { }

  seConnecter() {
    this.erreur = false;

    this.srvAuth.login(this.username, this.password)
      .subscribe({
        next: response => {
          this.srvAuth.token = response.token;
        },

        error: error => {
          this.erreur = true;
        }
      });
  }
}
