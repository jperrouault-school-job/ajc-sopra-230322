// Somme de deux entiers
int additionner(int a, int b) {
    return a + b;
}

additionner(5, 6);

// Somme de deux entiers positifs (retourner 0 sinon)
int additionner(int a, int b) {
    if (a <= 0 || b <= 0) {
        return 0;
    }

    return a + b;
}

additionner(0, 6);
additionner(5, 0);
additionner(5, 6);

// Multiplication simple de deux entiers avec additions seulement
int multiplier(int a, int b) {
    int resultat = 0;
    int i = 0;

    while (i < b) {
        resultat = resultat + a;
        i = i + 1;
    }

    return resultat;
}

multiplier(2, 4);
multiplier(2, 0);
multiplier(5, 8);

// Faire en sorte de pouvoir calculer une puissance n (2^4 = 2*2*2*2)
int puissance(int a, int b) {
    int res = 1;

    if (b == 0) {
        return 1;
    }

    if (a == 0) {
        return 0;
    }

    for (int i = 0; i < b; i = i + 1) {
        res = res * a;
    }

    return res;
}

puissance(2, 4);


// Calculer la somme des entiers contenus dans un tableau reçu en paramètre
int somme(int[] tab) {
    int res = 0;

    for (int i = 0; i < tab.length; i = i + 1) {
        res = res + tab[i];
    }

    return res;
}

int[] monTab = { 4, 5, 6 };
somme(monTab);


// Compter le nombre de caractères contenus dans un tableau de caractères
int nbCar(char[] tab) {
    int nb = 0;

    for (int i = 0; i < tab.length; i = i + 1) {
        if (tab[i] != 0) {
            nb = nb + 1;
        }
    }

    return nb;
}

char[] maPhrase = { 'u', 'n', 'e', ' ', 'p', 'h', 'r', 'a', 's', 'e' };
nbCar(maPhrase);


// Compter le nombre d’espaces (caractères espace) contenus dans un tableau de caractères
int nbEspaces(char[] tab) {
    int nb = 0;

    for (int i = 0; i < tab.length; i = i + 1) {
        if (tab[i] == ' ') {
            nb++;
        }
    }

    return nb;
}

char[] maPhrase = { 'u', 'n', 'e', ' ', 'p', 'h', 'r', 'a', 's', 'e' };
nbEspaces(maPhrase);


// Compter le nombre de mots contenus dans un tableau de caractères
int nbMots(char[] tab) {
    int nb = 0;
    boolean isWord = false;

    for (int i = 0; i < tab.length; i++) {
        if (tab[i] != ' ' && tab[i] != '!' && tab[i] != ',' && tab[i] != '.' && tab[i] != ';') {
            // if (isWord == false) {
            // if (isWord != true) {
            // On teste si isWord est FAUX (NON (!) VRAI)
            if (!isWord) {
                nb++;
                isWord = true;
            }
        }

        else {
        	isWord = false;
        }
    }

    return nb;
}

char[] maPhrase = { 'u', 'n', 'e', ' ', 'p', 'h', 'r', 'a', 's', 'e', '!' };
nbMots(maPhrase);


// Compter le nombre de voyelles contenues dans un tableau de caractères
int nbVoyelles(char[] tab) {
    int nb = 0;

    for (int i = 0; i < tab.length; i++) {
        if (tab[i] == 'a' || tab[i] == 'e' || tab[i] == 'i' || tab[i] == 'o' || tab[i] == 'u' || tab[i] == 'y') {
            nb++;
        }
    }

    return nb;
}

char[] maPhrase = { 'u', 'n', 'e', ' ', 'p', 'h', 'r', 'a', 's', 'e', '!' };
nbVoyelles(maPhrase);


// Ranger chaque caractère d’un tableau par ordre alphabétique
void trier(char[] tab) {
    for (int i = tab.length - 1; i >= 0; i = i - 1) {
        for (int j = i - 1; j >= 0; j = j - 1) {
            if (tab[i] < tab[j]) {
                char tmp = tab[i];
                tab[i] = tab[j];
                tab[j] = tmp;
            }
        }
    }
}

char[] maPhrase = { 'u', 'n', 'e', ' ', 'p', 'h', 'r', 'a', 's', 'e', '!' };
trier(maPhrase);
maPhrase;

// Insérer un nouvel entier dans un tableau (pas nécessairement plein) à un indice précis
int[] inserer(int[] tab, int valeur, int indice) {
    //Si on a une case libre
    if (tab[indice] == 0) {
        tab[indice] = valeur; //On affecte la valeur à la case du tableau
        return tab;
    }


    int tailleTab = tab.length;

    //Si la dernière case est pas vide, il faut redimentionner
    if (tab[tailleTab - 1] != 0) {
        //On cré un nouveau tableau avec une case en plus
        int[] tmpTab = new int[tailleTab + 1];

        //On transfert toutes les valeurs dans le nouveau tableau
        for (int i = 0; i < tailleTab; i++) {
            tmpTab[i] = tab[i];
        }

        //On change l'adresse mémoire de tab, pour pointer sur le nouveau tableau
        tab = tmpTab;

        //On modifie la taille, elle est un peu plus grande !
        tailleTab += 1;
    }


    //Comme on insère à un indice, on décale toutes les valeurs à partir de cet indice
    for (int i = tailleTab - 2; i >= indice; i--) {
        tab[i + 1] = tab[i];
    }

    //On affecte la valeur à la case du tableau
    tab[indice] = valeur;

    return tab;
}

int[] monTab = { 4, 8, 1, 0, 2 };
monTab = inserer(monTab, 10, 2);
monTab = inserer(monTab, 42, 0);
monTab = inserer(monTab, 18, 5);