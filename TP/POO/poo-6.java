{
    class Joueur {
        // Partie SANS INSTANCE
        static int idStatic = 1;

        // Partie AVEC INSTANCE (dès qu'on fait new Joueur())
        int id = idStatic++;
        int age = 0;
    }

    Joueur j1 = new Joueur();
    Joueur j2 = new Joueur();

    System.out.println(j1.id);
    System.out.println(j2.id);

    j2.idStatic = 40;

    System.out.println(j1.idStatic);
    System.out.println(j2.idStatic);

    // System.out.println(j1.idStatic);
    // System.out.println(j2.idStatic);
    // System.out.println(Joueur.idStatic);
}