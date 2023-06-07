export class Produit {
  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

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

  public get modele(): string {
    return this._modele;
  }

  public set modele(value: string) {
    this._modele = value;
  }

  public get reference(): string {
    return this._reference;
  }

  public set reference(value: string) {
    this._reference = value;
  }

  public get fournisseurId(): number {
    return this._fournisseurId;
  }

  public set fournisseurId(value: number) {
    this._fournisseurId = value;
  }

  public get fournisseurNom(): number {
    return this._fournisseurNom;
  }

  public set fournisseurNom(value: number) {
    this._fournisseurNom = value;
  }
  
  constructor(
    private _id: number,
    private _nom: string,
    private _prix: number,
    private _modele: string,
    private _reference: string,
    private _fournisseurId: number,
    private _fournisseurNom: number) { }
}
