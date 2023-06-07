import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produit } from '../models/produit';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  constructor(private httpClient: HttpClient) { }

  public findAll(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${ environment.apiUrl }/produit`);
  }

  public add(produit: any): Observable<Produit> {
    return this.httpClient.post<Produit>(`${ environment.apiUrl }/produit`, produit);
  }

  public edit(produit: any): Observable<Produit> {
    return this.httpClient.put<Produit>(`${ environment.apiUrl }/produit/${ produit.id }`, produit);
  }

  public delete(produit: Produit): Observable<void> {
    return this.httpClient.delete<void>(`${ environment.apiUrl }/produit/${ produit.id }`);
  }
}
