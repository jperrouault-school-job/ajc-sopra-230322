export class Produit {
  public get nom(): string {
    return this._nom;
  }
  
  public set nom(value: string) {
    this._nom = value;
  }
  
  public get prix(): number {
    return this._prix;
  }
  
  public set prix(value: number) {
    this._prix = value;
  }

  constructor(private _nom: string, private _prix: number) { }
}
