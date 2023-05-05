// Avec la syntaxe "function"
// > Le contexte de la fonction est le contexte dans lequel la fonction s'exécute


// Avec la syntaxe "fléchée"
// > Le contexte de la fonction fléchée est le contexte dans lequel elle est déclarée

// Syntaxes

// Pas d'argument

const fncSansArg = () => {
  console.log("fonction sans argument ...");
}

fncSansArg();

// Un seul argument
const fncAvecUnArg = arg => {
  console.log(arg * 2);
}

fncAvecUnArg(20);

// Plus d'un seul argument
const fncPlusieursArgs = (arg1, arg2) => {
  console.log(arg1 + arg2);
}

fncPlusieursArgs(10, 20);


// Lorsqu'on a, comme ici, une seule instruction
// > Les accolades sont optionnelles, et le mot-clé "return" l'est aussi (il est implicite)
const additionV1 = (a, b) => {
  return a + b;
}

const additionV2 = (a, b) => a + b; 

const foisQuatre = a => a * 4;

console.log(foisQuatre(5));
