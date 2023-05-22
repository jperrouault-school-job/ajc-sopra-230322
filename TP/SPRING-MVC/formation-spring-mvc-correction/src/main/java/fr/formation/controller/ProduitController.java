package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Produit;
import jakarta.validation.Valid;

@Controller
public class ProduitController {
	@GetMapping("/produit")
	public String getProduit(@RequestParam int id, Model model) {
		model.addAttribute("produitId", id);
		
		return "produit";
	}
	
	@GetMapping("/produit/{id}")
	public String getProduitPV(@PathVariable int id, Model model) {
		model.addAttribute("produitId", id);
		
		return "produit";
	}
	
	@GetMapping("/produit/ajouter")
	public String add() {
		return "form-produit";
	}
	
	@PostMapping("/produit/ajouter")
	// @Valid permet de demander à SPRING de valider l'instance Produit reçue
	// BindingResult qui suit permet de récupérer toutes les erreurs de validation
	public String postAdd(@Valid @ModelAttribute Produit produit, BindingResult result, Model model) {
		System.out.println(produit.getNom());
		
//		if (produit.getPrix() <= 0) { // Dans ce cas, le prix est pas bon
//			return "form-produit";
//		}
		if (result.hasErrors()) {
			// On injecte la liste des erreurs liés à la validation
			model.addAttribute("erreurs", result);
			return "form-produit";
		}
		
		return "redirect:/produit?id=1";
	}
	
//	@PostMapping("/produit/ajouter")
//	public String postAdd(@RequestParam String nom, @RequestParam float prix) {
//		Produit produit = new Produit();
//		
//		produit.setNom(nom);
//		produit.setPrix(prix);
//		
//		return "redirect:/produit?id=1";
//	}
}
