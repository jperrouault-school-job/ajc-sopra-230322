
document.querySelector('button').addEventListener('click', () => {


  fetch('https://jsonplaceholder.typicode.com/todos')
    .then(result => result.json())
    .then(todos => {

      for (let todo of todos) {
        const paragraphe = document.createElement('p');
        paragraphe.innerHTML = todo.title;

        document.querySelector('body').append(paragraphe);
      }

    });

});
