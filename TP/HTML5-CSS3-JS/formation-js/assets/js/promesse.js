// setTimeout(() => {
//   console.log("Différé ...");
  
//   setTimeout(() => {
//     console.log("Différé 2 ...");

//     setTimeout(() => {
//       console.log("Différé 3 ...");
//     }, 1000);

//   }, 1000);

// }, 1000);


// Le principe d'une promesse
// Objet Promise

const p = new Promise((resolve, reject) => {
  setTimeout(() => {
    // OK c'est bon, on a le résultat
    resolve("La valeur vient de là");

    // En imaginant qu'on a une erreur
    // reject("Une erreur est survenue ...");
  }, 1000);
});


const differe1 = (valeur) => {
  console.log(valeur);

  // Simulation à un appel asynchrone qui prend du temps
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(valeur + " ... différé 2");
    }, 1000);
  });
}


const differe2 = (valeur) => {
  console.log(valeur);

  // Simulation à un appel asynchrone qui prend du temps
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(valeur + " ... différé 3");
    }, 1000);
  });
}


console.log("AVANT .THEN");

p .then(differe1)
  .then(differe2)
  .then(console.log)
  .catch(err => console.error(err));

console.log("APRES .THEN");