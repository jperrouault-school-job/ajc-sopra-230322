package fr.formation;

import java.util.Optional;

import fr.formation.model.Produit;

public class ApplicationOptional {
	public static void main(String[] args) {
		
		// Dans le cas où le produit n'existe pas en base de données
		Produit produit = demoNotOptional();
		
		if (produit != null) {
			System.out.println(produit.getNom());
		}
		
		
		
		//La même chose avec un Optional
		Optional<Produit> optProduit = demoOptional();
		
		// Comme c'est Optional, potentiellement y'a rien dedans
		if (optProduit.isPresent()) {
			System.out.println(optProduit.get().getNom());
		}
		
		else {
			System.out.println("Pas de produit ..");
		}
		
		
		// Avec le Optional, on peut aller encore plus loin : par exemple, créer un produit par défaut
		// > Si le produit existe dans le Optional, on le récupère ; et s'il n'existe pas, on fabrique un nouveau produit
		Produit p = demoOptional().orElse(new Produit());
		System.out.println(p.getNom());
	}
	
	public static Produit demoNotOptional() {
		return null;
	}
	
	public static Optional<Produit> demoOptional() {
		return Optional.empty();
	}
	
}
