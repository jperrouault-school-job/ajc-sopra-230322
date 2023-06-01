
class Fournisseur {
  public get nom(): string {
    return this._nom;
  }

  constructor(private _id: number, private _nom: string, private _responsable: string) { }
}

let fournisseur: Fournisseur = new Fournisseur(1, "GoPRO", "Roger");

console.log(fournisseur.nom);