package fr.formation.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.formation.model.Produit;

@Component("panier")
@SessionScope
public class PanierSession {
	private List<Produit> produits = new ArrayList<>();

	public List<Produit> getProduits() {
		return produits;
	}

	public void add(Produit produit) {
		this.produits.add(produit);
	}

	public void remove(int id) {
		this.produits.removeIf(p -> p.getId() == id);
	}
}
