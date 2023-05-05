class Todo {
  id = 0;
  completed = false;

  // Constructeur
  constructor(id, title) {
    this.id = id;
    this.title = title;
  }

  getComplet() {
    return (this.completed) ? "Oui" : "Non";
  }
}

// On exporte la classe Todo
export default Todo;