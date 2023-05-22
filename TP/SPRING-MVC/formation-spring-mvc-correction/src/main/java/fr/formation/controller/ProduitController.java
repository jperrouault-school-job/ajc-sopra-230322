package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Produit;

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
	public String postAdd(Produit produit) {
		System.out.println(produit.getNom());
		
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
