export class Fournisseur {
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

  public get responsable(): string {
    return this._responsable;
  }
  
  public set responsable(value: string) {
    this._responsable = value;
  }
  
  constructor(
    private _id: number,
    private _nom: string,
    private _responsable: string) { }
}
