package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
}
