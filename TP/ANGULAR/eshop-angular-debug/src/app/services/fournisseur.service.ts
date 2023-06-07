import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fournisseur } from '../models/fournisseur';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>(`${ environment.apiUrl }/fournisseur`);
  }

  public add(fournisseur: any): Observable<Fournisseur> {
    return this.httpClient.post<Fournisseur>(`${ environment.apiUrl }/fournisseur`, fournisseur);
  }

  public edit(fournisseur: any): Observable<Fournisseur> {
    return this.httpClient.put<Fournisseur>(`${ environment.apiUrl }/fournisseur/${ fournisseur.id }`, fournisseur);
  }

  public delete(fournisseur: Fournisseur): Observable<void> {
    return this.httpClient.delete<void>(`${ environment.apiUrl }/fournisseur/${ fournisseur.id }`);
  }
}
