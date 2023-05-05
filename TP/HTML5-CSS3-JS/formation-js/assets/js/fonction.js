function hello() {
  console.log("HELLO !!!");
}

hello();


function helloReturn() {
  return "Hello !";
}

// console.log(helloReturn);

let demoFonctionDuDemon = helloReturn;
console.log(demoFonctionDuDemon());

console.log(typeof helloReturn);
console.log(typeof demoFonctionDuDemon);

let demoFonction = function() {
  console.log("OH !");
}

demoFonction();



// Fonction avec paramètres
function maths(a, b) {
  console.log("a = " + a);
  console.log("b = " + b);

  if (b === null) {
    console.log("EGAL NULL");
  }

  if (b === undefined) {
    console.log("EGAL UNDEFINED");
  }

  return a + b;
}

// Appelle de cette fonction avec les 2 paramètres
console.log(maths(5, 4));

// Appelle de cette fonction avec 3 paramètres
console.log(maths(5, 4, "test"));

// Appelle de cette fonction avec 1 paramètre
console.log(maths(5, null));


