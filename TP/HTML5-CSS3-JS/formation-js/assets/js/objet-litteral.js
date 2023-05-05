// Déclaration d'un objet litteral
let monObjet = {
  attr: "valeur",
  
  prenom: "Jérémy",
  age: 25,
  
  getNom: function() {
    console.log("get nom");
  },

  getNom2() {
    console.log("get nom 2");
  },

  getPrenom() {
    return this.prenom;
  }
};

// Manipuler l'objet

console.log(monObjet.age);
monObjet.getNom();
monObjet.getNom2();

monObjet.autreattr = "val";


console.log(monObjet['age']);
monObjet['getNom']();

console.log(monObjet.getPrenom());


