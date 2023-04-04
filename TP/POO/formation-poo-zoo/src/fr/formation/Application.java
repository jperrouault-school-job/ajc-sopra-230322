package fr.formation;

import java.util.ArrayList;
import java.util.List;

import fr.formation.zoo.Chat;
import fr.formation.zoo.Cheval;
import fr.formation.zoo.IChassable;
import fr.formation.zoo.IChasseur;
import fr.formation.zoo.ISoignable;
import fr.formation.zoo.Leopard;
import fr.formation.zoo.Loup;
import fr.formation.zoo.Soigneur;
import fr.formation.zoo.Zebre;

public class Application {
	public static void main(String[] args) {
		Soigneur monSoigneur = new Soigneur();

		Chat albert = new Chat();
		ISoignable pica = new Chat();
		ISoignable zoro = new Cheval();
		Cheval neo = new Cheval();
		

//		monSoigneur.soigner(albert);
//		monSoigneur.soigner(pica);
//		monSoigneur.soigner((Chat) pica);
//		monSoigneur.soigner(zoro);
//		monSoigneur.soigner(neo);
		
		
		
		
		// Couplage faible
		List<ISoignable> soignables = new ArrayList<>();

		soignables.add(albert);
		soignables.add(pica);
		soignables.add(zoro);
		soignables.add(neo);
		
//		for (ISoignable s : soignables) {
//			monSoigneur.soigner(s);
//		}
		
		monSoigneur.soigner(soignables);
	}
	
	
	
	
	
	
	public static void main4(String[] args) {
		// Chasseurs
		IChasseur albert = new Chat("Albert");
		IChasseur leo = new Leopard();
		IChasseur loulou = new Loup();
		
		
		// Proies
		IChassable chev = new Cheval();
		IChassable bobby = new Zebre();
		IChassable peureux = new Chat("Peureux");
		
		
		albert.chasser(peureux);
//		peureux.defendre(albert);
		leo.chasser(chev);
//		chev.defendre(leo);
		loulou.chasser(bobby);
//		bobby.defendre(loulou);
	}
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		IChasseur leo = new Leopard();
//		
//		Leopard leopole = new Leopard();
//		leopole.dormir();
//		
//		IChasseur albert = new Chat();
//		albert.chasser();
//	}
//	
//	
//	
//	
//	
//	
//	public static void main2(String[] args) {
//		Felide chat = new Chat();
//		Felide leopard = new Leopard();
//		
//		chat.dormir();
//		leopard.dormir();
//		
//		System.out.println("------");
//		
//		chat.courir();
//		leopard.courir();
//		
//		System.out.println("------");
//		
//		
//		ArrayList<Animal> animaux = new ArrayList<>();
//
//		animaux.add(new Leopard());
//		animaux.add(new Chat());
//		
//		
//		for (Animal a : animaux) {
//			a.dormir();
//			
//			if (a instanceof Leopard) {
//				((Leopard) a).chasser();
//			}
//			
//			if (a instanceof Leopard l) {
//				l.chasser();
//			}
//		}
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public static void main1(String[] args) {
//		Chat albert = new Chat("Albert");
//		
//		System.out.println("Le nom du chat est " + albert.getNom());
//		
//		albert.setNom("Albertino");
//		System.out.println("Le nom du chat est " + albert.getNom());
//		
//		albert.dormir();
//		
//		System.exit(0);
//		
//		
//		System.out.println(albert);
//
//		
//		Object pica = new Chat("Pica");
//		
//		System.out.println(pica);
//		
//		// On peut utiliser le Cast
////		Chat picaChat = (Chat) pica;
//		((Chat) pica).setNom("Picassiette");
//		
//		System.out.println("FIN ");
//	}
}
