package fr.formation.api;

public interface Views {
	public static interface Common { }
	
	public static interface Produit extends Common { }
	public static interface ProduitDetail extends Produit { }
	
	public static interface Personne extends Common { }
	public static interface Fournisseur extends Personne { }
}
