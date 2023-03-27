int additionner(int a, int b) {
    int resultat = a + b * 2;
    return resultat;
}

// Utilisation de additionner
additionner(40, 2);



// Ici, on tente d'affecter 10 dans "c" qui n'existe pas
c = 10; // Ca donne une erreur, la variable n'existe pas


// Pour que ça fonctionne, il FAUT déclarer la variable
// TOUJOURS type nomVariable
int c;
c = 10;

c = c + 5; // Il va calculer 10 + 5, et donner 15 à c



c = c + 1;
// equivalent de 
c += 1;
// equivalent de
c++;


if (c == 21) {
    c = 5;
}

if (c != 21) {
    c = 5;
}


// Pour un entier i = 0, tant que i < 5, et à chaque itération on incrémente i
for (int i = 0; i <= 5; i++) {
    c = 10 + i;
}


c = 10;
for (int i = 0; i < 5; i++) {
    c++;
}



// On test la valeur de "a", et si elle est égale à 0, alors ..
if (a == 0) {
    // On fait ça
}

// Exemple conditions ET
if (a == 0 && b == 0) {

}

// Exemple conditions OU
if (a == 0 || b == 0) {
    
}



int a = 5 * 2 + 8 * 3;
int b = 8 * 2 + 6 * 3;
int c = 10 * 2 + 5 * 3;


// Déclarer le sous-programmation
int additionBizarre(int a, int b) {
    int resultat = a * 2 + b * 3;

    if (resultat > 100) {
        return 100; // Le retour va arrêter le sous-programme
    }

    // Return est important pour 2 raisons
    // 1- parce que le sous-programme DOIT retourner un entier
    // 2- parce que l'utilisateur du sous-programme induit la valeur de retour
    return resultat;
}

// Appeler un sous-programme
// Le faire avec son nom, les parenthèses, et les paramètres
int a = additionBizarre(5, 8);
int b = additionBizarre(a, 6);
int c = additionBizarre(additionBizarre(5, 8), 5);

