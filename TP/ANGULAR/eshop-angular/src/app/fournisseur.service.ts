import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fournisseur } from './fournisseur';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>('http://localhost:8080/api/fournisseur');
  }
}
