{
    class Joueur {
        int age = 5;
        String nom;
    }
    
    Joueur j1 = new Joueur();
    Joueur j2 = new Joueur();


    j1.age = 20;
    j2.age = 45;

    j1 = j2;

    j1.age = 10;
    j2.age = 30;

    System.out.println(j1.age);
    System.out.println(j2.age);
}