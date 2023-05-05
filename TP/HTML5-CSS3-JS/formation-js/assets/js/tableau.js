// Déclaration d'un tableau
let monTab = [ 42, 5, "test", "aucun problème" ];

// Parcourir le tableau

// console.log(monTab);

// Pour classique
for (let i = 0; i < monTab.length; i++) {
  console.log(monTab[i]);
}

// Boucle for-in
for (let i in monTab) {
  console.log(monTab[i]);
}

// Boucle for-of
for (let val of monTab) {
  console.log(val);
}

// Boucle forEach
monTab.forEach(function(val, i) {
  console.log(i, val);
});


// forEach réécrit pour mieux appréhender

Array.prototype.forEach = function(fncCallback) {
  for (let i = 0; i < this.length; i++) {
    // Pour chaque case du tableau
    fncCallback(this[i], i);
  }
}

monTab.forEach(function(val, i) {
  console.log(i, val);
});

