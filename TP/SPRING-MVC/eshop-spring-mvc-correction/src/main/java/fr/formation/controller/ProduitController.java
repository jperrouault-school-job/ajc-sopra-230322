package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.repo.IProduitRepository;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private IProduitRepository repoProduit;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("produits", this.repoProduit.findAll());
		
		return "produit/liste";
	}
}
