// Cette syntaxe fonctionnera dans ce cas
// > Le contexte de la fonction est le le contexte dans lequel elle s'exécute
// > Donc ici, "this" sera l'objet Todo, puisqu'on l'appelle avec le Todo
const getComplet = function() {
  return (this.completed) ? "Oui" : "Non";
}

// Attention, cette syntaxe ne fonctionnera pas dans ce cas
// > Le contexte de la fonction fléchée est le contexte dans lequel elle est déclarée
// > Donc ici, "this" ne sera pas l'objet Todo
const getCompletArrow = () => {
  return (this.completed) ? "Oui" : "Non";
}

const todos = [
  {
    id: 1,
    title: "Boire son café",
    completed: true,
    getComplet: getComplet
  },
  {
    id: 2,
    title: "Apprendre Javascript",
    completed: false,
    getComplet
  }
];

for (let todo of todos) {
  console.log(todo.title);
  console.log("Terminé : " + todo.getComplet());
}