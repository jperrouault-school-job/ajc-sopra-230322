// #1 - Programme "Somme de 2 nombres"
Entier additionner(Entier a, Entier b) {
    Entier resultat = a + b;
    Retour resultat;
}

// Utilisation de additionner
additionner(40, 2);


// #2 - Programme "Somme de 2 entiers positifs"
Entier additionnerPositifs(Entier a, Entier b) {
    Si (a <= 0 OU b <= 0) {
        Retour 0; // Dès qu'on croise un "Retour", le sous-programme s'arrête là
    }

    Retour a + b;
}


// #3 - Programme "Multiplier 2 entiers"
Entier multiplier(Entier a, Entier b) {
    Entier resultat = 0;

    // Pour (Entier i = 0; i < b; i = i + 1) {
    Pour (Entier i = 0; i < b; i++) {
        // resultat = resultat + a;
        resultat += a;
    }

    Retour resultat;
}


// #3 - Programme "Multiplier 2 entiers" (bis)
Entier multiplier(Entier a, Entier b) {
    Entier resultat = 0;

    Tantque (b > 0) {
        resultat = resultat + a;
        b = b - 1;
    }

    Retour resultat;
}


