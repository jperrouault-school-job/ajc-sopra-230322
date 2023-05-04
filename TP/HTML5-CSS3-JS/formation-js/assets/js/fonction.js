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


