{
// Créer une classe Joueur
// > Age
class Joueur {
    int age = 5;
    String nom;
}

// Instancier un nouveau Joueur
Joueur joueur = new Joueur();
Scanner sc = new Scanner(System.in);

System.out.println("Saisir le nom :");
joueur.nom = sc.nextLine();

System.out.println("Saisir l'age :");
joueur.age = sc.nextInt();

// Afficher son âge
System.out.println("Son nom est " + joueur.nom + ", et son age est " + joueur.age);
}