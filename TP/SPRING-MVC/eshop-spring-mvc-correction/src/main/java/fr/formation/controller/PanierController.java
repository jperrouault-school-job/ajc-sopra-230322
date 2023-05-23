package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import jakarta.servlet.http.HttpSession;

//@Controller
@RequestMapping("/panier")
public class PanierController {
	@Autowired
	private IProduitRepository repoProduit;
	
	@GetMapping
	public String findAll() {
		return "panier/liste";
	}
	
	@GetMapping("/ajouter/{id}")
	public String add(@PathVariable int id, HttpSession session) {
		List<Produit> panier = (List<Produit>)session.getAttribute("panier");
		
		if (panier == null) {
			panier = new ArrayList<>();
			session.setAttribute("panier", panier);
		}
		
		panier.add(this.repoProduit.findById(id).orElseThrow(ProduitNotFoundException::new));
		
		return "redirect:/panier";
	}
	
	@GetMapping("/supprimer/{id}")
	public String deleteById(@PathVariable int id, HttpSession session) {
		List<Produit> panier = (List<Produit>)session.getAttribute("panier");
		
		if (panier != null) {
			panier.removeIf(p -> p.getId() == id);
		}
		
		return "redirect:/panier";
	}
}
