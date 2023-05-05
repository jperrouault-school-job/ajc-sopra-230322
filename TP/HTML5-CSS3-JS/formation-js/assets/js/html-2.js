// Pour créer un nouvel élément HTML, qu'on incluera après dans le DOM
const btn = document.createElement('button');

// Modifier le texte du bouton
btn.innerHTML = "OK !";

// Changer le style (couleur)
btn.style.color = "red";

// Ajouter une classe CSS
btn.classList.add('la-classe');

// Ajouter le bouton au body, à la fin
document.querySelector('body').append(btn);


// On va écouter un évènement en particulier, click
btn.addEventListener('click', (evt) => {
  console.log(evt);
  alert("L'utilisateur a cliqué ici !!!");
});

