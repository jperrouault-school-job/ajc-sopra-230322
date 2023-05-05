let prenoms = [ "Toto", "Tata", "Titi", "Tutu" ];


// Ajouter un nouvel élément au tableau
prenoms.push("Nouveau");

// Supprimer un élément du tableau
// > A partir de l'index 2, on supprime 1 élément
prenoms.splice(2, 1);

// Récupérer un index à partir d'une valeur
let indexASupprimer = prenoms.indexOf("Toto")
prenoms.splice(indexASupprimer, 1);


// Boucle for-of
for (let prenom of prenoms) {
  console.log(`Hello ${ prenom }`);
}

// Boucle forEach
prenoms.forEach(function(prenom) {
  console.log(`Bonjour ${ prenom }`);
});

prenoms.forEach(prenom => {
  console.log(`Bonjour ${ prenom }`);
});