function bonjour(prenom) {
  console.log("Bonjour " + prenom);
}

const hello = function(prenom) {
  console.log(`Hello ${ prenom }, how are you?`);
}

// bonjour("Noé");
// hello("Marine");


// Fonction de callback ..

const sayMyName = function(fncCallback) {
  fncCallback("Heisenberg");
}

sayMyName(hello);

// Fonction de callback, anonyme
sayMyName(function(prenom) {
  console.log(`Guten tag ${ prenom }`);
});

// Fonction de callback, anonyme et lambda
sayMyName((prenom) => {
  console.log(`Hola ${ prenom }! ¿Como estas?`);
});
