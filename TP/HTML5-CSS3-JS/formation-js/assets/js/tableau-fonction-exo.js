let fonctions = [
  function() {
    console.log("Bonjour");
  },

  function() {
    console.log("Hello");
  }
];

// console.log(fonctions);

// console.log(fonctions[0]);

// fonctions[0]();

// Boucle for-or
for (let fnc of fonctions) {
  fnc();
}

// Boucle for-in
for (let i in fonctions) {
  fonctions[i]();
}

// Boucle forEach
fonctions.forEach(function(fnc) {
  fnc();
});

// Boucle forEach
fonctions.forEach(fnc => fnc());