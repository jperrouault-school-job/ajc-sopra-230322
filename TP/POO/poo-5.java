{
    class Joueur {
        int age = 5;
        static int ageStatic = 5;

        void pasStatique() {
            System.out.println("Pas statique ...");
        }

        static void statique() {
            System.out.println("Statique ...");
        }
    }
    
    Joueur j1 = new Joueur();
    Joueur j2 = new Joueur();

    Joueur.statique(); // Ca marche
    Joueur.pasStatique(); // Ca marche pas

    j1.statique(); // Ca marche
    j1.pasStatique(); // Ca marche
}