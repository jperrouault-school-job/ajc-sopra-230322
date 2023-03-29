{
    class Joueur {
        int age = 5;
        static int ageStatic = 5;
    }
    
    Joueur j1 = new Joueur();
    Joueur j2 = new Joueur();


    j1.age = 20;
    j2.age = 45;

    // j2.ageStatic = 10; // Fonctionne
    Joueur.ageStatic = 12;
    // Joueur.age = 40; // Ne fonctionne pas

    System.out.println(j1.age);
    System.out.println(j2.age);
    System.out.println("-------------");
    System.out.println(j1.ageStatic);
    System.out.println(j2.ageStatic);
}