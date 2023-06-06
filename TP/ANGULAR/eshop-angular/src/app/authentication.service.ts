import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from './auth-response';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private _token: string = "";

  public get token(): string {
    return this._token;
  }
  
  public set token(value: string) {
    this._token = value;
  }

  constructor(private httpClient: HttpClient) {
    this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZXJlbXkiLCJpYXQiOjE2ODYwNTgwMzEsImV4cCI6MTY4NjA2MTYzMX0.13Px5rdrQag5VZQ5-ITLH8mwvvJNcNlVi4aRam4Tm3CL3-Bol7kRnJaSyZMY5nPrW15bJVvOL_w9okkhFaXLtA";
  }

  public login(username: string, password: string): Observable<AuthResponse> {
    return this.httpClient.post<AuthResponse>('http://localhost:8080/api/utilisateur/connexion', {
      username,
      password
    });
  }
}
