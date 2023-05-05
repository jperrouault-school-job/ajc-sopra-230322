// AJAX : Asynchronous Javascript And XML


fetch('https://jsonplaceholder.typicode.com/albums')
  .then(result => result.json()) // Dès qu'on a reçu le résultat, on fait ça
  .then(albums => {
    for (let album of albums) {
      const paragraphe = document.createElement('p');

      paragraphe.innerText = album.title;

      document.querySelector('body').append(paragraphe);
    }

    console.log("TERMINE !");
  }); // Dès que la transformation JSON sera fini


console.log("TERMINE ?");