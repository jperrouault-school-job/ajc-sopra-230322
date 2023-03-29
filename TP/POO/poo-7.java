// Correction sans statique
class Joueur {
    String nom;
    int age;
}

class Equipe {
    String nom;
    Joueur[] joueurs;
}


// Instancier les 4 joueurs
Joueur j1 = new Joueur();
Joueur j2 = new Joueur();
Joueur j3 = new Joueur();
Joueur j4 = new Joueur();

// Instancier les 2 equipes
Equipe equipeBleue = new Equipe();
Equipe equipeRouge = new Equipe();


// Donner le nom et les joueurs aux équipes
equipeBleue.nom = "Bleue";
equipeBleue.joueurs = new Joueurs[2];
equipeBleue.joueurs[0] = j1;
equipeBleue.joueurs[1] = j2;

equipeRouge.nom = "Rouge";
equipeRouge.joueurs = { j3, j4 };


// Correction avec statique
class Joueur {
    String nom;
    int age;
}

class Equipe {
    String nom;
    Joueur[] joueurs;

    static Equipe creerEquipe(String nom, Joueur j1, Joueur j2) {
        Equipe equipe = new Equipe();

        equipe.nom = nom;
        equipe.joueurs = { j1, j2 };

        return equipe;
    }
}


// Instancier les 4 joueurs
Joueur j1 = new Joueur();
Joueur j2 = new Joueur();
Joueur j3 = new Joueur();
Joueur j4 = new Joueur();

// Instancier les 2 equipes
Equipe equipeBleue = Equipe.creerEquipe("Bleue", j1, j2);
Equipe equipeRouge = Equipe.creerEquipe("Rouge", j3, j4);
