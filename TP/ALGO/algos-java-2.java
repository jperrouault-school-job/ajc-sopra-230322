
// Déclarer une variable "a" qui vaut 30.
int a = 30;

// Afficher un message "Hello, world!" (utiliser System.out.println("...")).
System.out.println("Hello, world!");

// Déclarer une variable "b" qui vaut 42. Lui ajouter 10. Afficher sa valeur.
int b = 42;
b = b + 10;
// OU
b += 10;
System.out.println("Le résultat est " + b);


// Déclarer une variable "c" qui vaut 52. Lui ajouter 20. Si sa valeur est > 70, afficher "trop grand". Sinon afficher sa valeur.
int c = 52;
c = c + 20;

if (c > 70) {
    System.out.println("Trop grand");
}

else {
    System.out.println(c);
}



// Déclarer une variable "min" qui vaut 20 et une variable "max" qui vaut 10
// Les ranger
int min = 20;
int max = 10;

int tmp = min;

min = max;
max = tmp;

System.out.println("min vaut " + min + " et max vaut " + max);



// On dispose de trois variables min (20), max (10) et med(25).
// Faites-en sorte de les remettre dans l’ordre
void rangerMinMaxMed() {
    int min = 20;
    int max = 10;
    int med = 25;

    if (min > med) {
        int tmp = min;
        min = med;
        med = tmp;
    }

    if (min > max) {
        int tmp = min;
        min = max;
        max = tmp;
    }

    if (med > max) {
        int tmp = med;
        med = max;
        max = tmp;
    }
    
    System.out.println("min vaut " + min + ", med vaut " + med + " et max vaut " + max);
}

// On appelle ce sous-programme
rangerMinMaxMed();





// Écrire un algorithme qui demande un nombre à l’utilisateur, et l’informe ensuite si ce nombre est positif ou négatif (on laisse de côté le cas où le nombre vaut zéro).
{
    // Pour demander à l'utilisateur, il faut un Scanner
    Scanner sc = new Scanner(System.in);

    System.out.println("Saisir un nombre : ");

    // pour demander un entier
    int saisie = sc.nextInt();

    if (saisie > 0) {
        System.out.println("Positif !");
    }

    else if (saisie < 0) {
        System.out.println("Négatif !");
    }
}



// Écrire un algorithme qui demande à l’utilisateur un nombre compris entre 1 et 3 jusqu’à ce que la réponse convienne.
{
    // Pour demander à l'utilisateur, il faut un Scanner
    Scanner sc = new Scanner(System.in);

    System.out.println("Saisir un chiffre entre 1 et 3");
    int saisie = sc.nextInt();
    
    while (saisie < 1 || saisie > 3) {
        System.out.println("Saisir un chiffre entre 1 et 3");
        saisie = sc.nextInt();
    }

    System.out.println("Votre saisie est " + saisie);
}

// Variante
{
    // Pour demander à l'utilisateur, il faut un Scanner
    Scanner sc = new Scanner(System.in);
    int saisie = 0;
    
    do {
        System.out.println("Saisir un chiffre entre 1 et 3");
        saisie = sc.nextInt();
    } while (saisie < 1 || saisie > 3);

    System.out.println("Votre saisie est " + saisie);
}




// Écrire un algorithme qui demande à l’utilisateur un nombre compris entre 10 et 20 jusqu’à ce que la réponse convienne.
{
    // Pour demander à l'utilisateur, il faut un Scanner
    Scanner sc = new Scanner(System.in);

    System.out.println("Saisir un chiffre entre 10 et 20");
    int saisie = sc.nextInt();
    
    while (saisie < 10 || saisie > 20) {
        if (saisie < 10) {
            System.out.println("Plus grand !");
        }

        else {
            System.out.println("Plus petit !");
        }

        System.out.println("Saisir un chiffre entre 10 et 20");
        saisie = sc.nextInt();
    }

    System.out.println("Votre saisie est " + saisie);
}


// Écrire un algorithme qui déclare et remplit un tableau de 6 valeurs numériques en les mettant toutes à 15.
int[] monTab = { 15, 15, 15, 15, 15, 15 };
// OU
int monTab[] = { 15, 15, 15, 15, 15, 15 };
// OU
int[] monTab = new int[] { 15, 15, 15, 15, 15, 15 };
// OU
int[] monTab = new int[6];

for (int i = 0; i < monTab.length; i++) {
    monTab[i] = 15;
}


// Ecrire un algorithme qui affiche les valeurs d'un tableau (6 cases, valeurs aléatoires à placer).
int[] monTab = { 41, 50, 465, 85, 14, 74 };

// Parcourir le tableau
for (int i = 0; i < monTab.length; i++) {
    System.out.println(monTab[i]);
}


// Écrire un algorithme calculant la somme des valeurs d’un tableau (on suppose que le tableau a été préalablement initialisé).
int[] monTab = { 41, 50, 465, 85, 14, 74 };

// Option #1
int total = monTab[0] + monTab[1] + monTab[2] + monTab[3] + monTab[4] + monTab[5];

// Option #2
int total = 0;
for (int i = 0; i < monTab.length; i++) {
    total = total + monTab[i];
}
System.out.println("Le total est " + total);


// Imprimer dans la console la matrice suivante

// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |

// # Option 1
{
    int[][] matrice = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };

    // Sachant que System.out.print() -> pas de retour à la ligne
    // Sachant que System.out.println() -> retour à la ligne

    System.out.print("| " + matrice[0][0] + " | " + matrice[0][1] + " | " + matrice[0][2] + " |");
    System.out.println("");
    System.out.print("| " + matrice[1][0] + " | " + matrice[1][1] + " | " + matrice[1][2] + " |");
    System.out.println("");
    System.out.print("| " + matrice[2][0] + " | " + matrice[2][1] + " | " + matrice[2][2] + " |");
    System.out.println("");
}

// # Option 2
{
    int[][] matrice = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };

    for (int i = 0; i < matrice.length; i++) {
        System.out.print("| " + matrice[i][0] + " | " + matrice[i][1] + " | " + matrice[i][2] + " |");
        System.out.println("");
    }
}

// # Option 3
{
    int[][] matrice = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };

    for (int i = 0; i < matrice.length; i++) {
        for (int j = 0; j < matrice[i].length; j++) {
            System.out.print(" | " + matrice[i][j]);
        }

        System.out.println(" |");
    }
}
