class Fournisseur {
    _id;
    _nom;
    _responsable;
    get nom() {
        return this._nom;
    }
    constructor(_id, _nom, _responsable) {
        this._id = _id;
        this._nom = _nom;
        this._responsable = _responsable;
    }
}
let fournisseur = new Fournisseur(1, "GoPRO", "Roger");
console.log(fournisseur.nom);
