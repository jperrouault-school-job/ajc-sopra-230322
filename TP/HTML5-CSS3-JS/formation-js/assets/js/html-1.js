// On a besoin d'accéder au DOM : Document Object Model
// Pour accéder au DOM depuis JS, on utilise document

// console.log(document);

// const paragraphe = document.getElementById('paragraphe');
// const paragraphe = document.querySelector('p#paragraphe');
const paragraphe = document.querySelector('p');
const paragraphes = document.querySelectorAll('p');

console.log(paragraphes);
console.log(paragraphe.innerHTML);

paragraphe.innerHTML += " ... autre <strong>chose</strong>";

for (let p of paragraphes) {
  p.innerHTML += " ... OK !";
}