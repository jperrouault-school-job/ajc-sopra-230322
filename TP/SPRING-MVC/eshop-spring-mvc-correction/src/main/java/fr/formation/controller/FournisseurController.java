package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import jakarta.validation.Valid;

@Controller
public class FournisseurController {
	@Autowired
	private IFournisseurRepository repoFournisseur;
	
	@GetMapping("/fournisseur")
	public String findAll(Model model) {
		model.addAttribute("fournisseurs", this.repoFournisseur.findAll());
		
		return "fournisseur/liste";
	}
	
	@GetMapping("/fournisseur/ajouter")
	public String add() {
		return "fournisseur/form";
	}
	
	@PostMapping("/fournisseur/ajouter")
	public String add(@Valid Fournisseur fournisseur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("erreurs", result);
			return "fournisseur/form";
		}
		
		this.repoFournisseur.save(fournisseur);
		
		return "redirect:/fournisseur";
	}
}
