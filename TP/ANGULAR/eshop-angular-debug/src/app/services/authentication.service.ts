import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from '../models/auth-response';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private _token: string = "";

  public get token(): string {
    return this._token;
  }
  
  public set token(value: string) {
    // Stockage du jeton dans le navigateur pour le retrouver au refresh de l'appli (et éviter des déconnexions à répétition)
    localStorage.setItem('token', value);

    this._token = value;
  }

  constructor(private httpClient: HttpClient) {
    // Récupération du jeton stocké dans le navigateur
    this.token = localStorage.getItem('token') ?? "";
  }

  public isLogged() {
    return !!(this.token && this.token != "");
  }

  public login(username: string, password: string, options: any) {
    this.httpClient.post<AuthResponse>(`${ environment.apiUrl }/utilisateur/connexion`, {
      username,
      password
    }).subscribe({
      next: result => {
        this.token = result.token;

        if (options.next) {
          options.next(result);
        }
      },

      error: () => {
        if (options.error) {
          options.error();
        }
      }
    });
  }
}
