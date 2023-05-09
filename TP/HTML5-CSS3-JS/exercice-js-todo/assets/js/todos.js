
const onLoadClick = () => {
  // Réinitialiser le tableau
  document.querySelector('table tbody').innerHTML = "";

  // Pour charger les todos
  fetch('https://jsonplaceholder.typicode.com/todos')
    .then(resp => resp.json())
    .then(todos => {
      for (let todo of todos) {
        const row = document.createElement('tr');
        const colTitle = document.createElement('td');
        const colCompleted = document.createElement('td');
        const colButton = document.createElement('td');
        const spanCompleted = document.createElement('span');
        const buttonSupprimer = document.createElement('a');

        // Ajouter les colonnes à la ligne
        row.append(colTitle);
        row.append(colCompleted);
        row.append(colButton);

        // Texte du title
        colTitle.innerText = todo.title;

        // Texte du span
        spanCompleted.innerText = (todo.completed) ? "Oui" : "Non";

        // Ajouter le span à la colonne
        colCompleted.append(spanCompleted);

        // Ajouter du style au span
        spanCompleted.classList.add('badge', 'rounded-pill');

        if (todo.completed) {
          spanCompleted.classList.add('text-bg-success');
        }
        
        else {
          spanCompleted.classList.add('text-bg-danger');
        }

        // Ajouter le bouton à la colonne
        colButton.append(buttonSupprimer);

        // Mettre en forme le bouton
        buttonSupprimer.classList.add('btn', 'btn-danger');
        buttonSupprimer.innerText = "Supprimer";

        // Le clique sur le bouton
        buttonSupprimer.addEventListener('click', () => {
          row.remove();
        });

        // Exemple avec innerHTML
        // colButton.innerHTML = '<a class="btn btn-danger">Supprimer</a>';

        // colButton.querySelector('a').addEventListener('click', () => {
        //   row.remove();
        // });

        // row.innerHTML = '<td>' + todo.title + '</td><td>?</td><td>?</td>';

        document.querySelector('table tbody').append(row);
      }
    });
};

// Utiliser la fonction onLoadClick sur le clique sur bouton "charger"
document.querySelector('a.btn').addEventListener('click', onLoadClick);