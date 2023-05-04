// Affichage dans la console du navigateur
console.log("Hello world!");


// var = déclarer une variable globale, à éviter
// let = déclarer une variable locale, à privilégier par rapport à var
// const = comme let, mais en constante

let a = 5;

if (true) {
  // const a = 10;
  let a = 10;
  console.log(a);
  console.log(typeof a);

  a = "Bonjour";
  console.log(a);
  console.log(typeof a);
}

console.log(a);

// Concaténation
console.log("5" + 5);

let phrase1 = "Un début de phrase";
let phrase2 = "une fin de phrase."

console.log(phrase1 + ", " + phrase2);
console.log(`${ phrase1 }, ${ phrase2 }`);


// Equivalences
if ("5" == 5) {
  console.log("VRAI !");
}

if ("5" === 5) {
  console.log("VRAI !");
}

// Exercice Hello
for (let i = 1; i <= 10; i++) {
  // console.log("Hello " + i);
  console.log(`Hello ${ i }`);
}