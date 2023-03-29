class Joueur {
    int age = 5;
    String nom;
}

Joueur demoReference(Joueur joueur) {
    joueur = new Joueur();
    joueur.age = 50;

    return joueur;
}

Joueur j1 = new Joueur();

j1.age = 20;
j1 = demoReference(j1);

System.out.println(j1.age);


// ---------------------------


void demoReference(Joueur joueur) {
    new Joueur();
    joueur.age = 50;
}

Joueur j1 = new Joueur();

j1.age = 20;
demoReference(j1);

System.out.println(j1.age);








