package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.exception.FournisseurNotFoundException;
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
	
	@PostMapping({ "/fournisseur/ajouter", "/fournisseur/modifier/{id}" })
	public String add(@Valid Fournisseur fournisseur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("erreurs", result);
			return "fournisseur/form";
		}
		
		this.repoFournisseur.save(fournisseur);
		
		return "redirect:/fournisseur";
	}
	
	@GetMapping("/fournisseur/modifier/{id}")
	public String edit(@PathVariable int id, Model model) {
		Fournisseur fournisseur = this.repoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);
//		Fournisseur fournisseur = this.repoFournisseur.findById(id).orElseThrow(() -> new FournisseurNotFoundException());
		
		model.addAttribute("fournisseur", fournisseur);
		
		return "fournisseur/form";
	}
	
//	@PostMapping("/fournisseur/modifier/{id}")
//	public String edit(@Valid Fournisseur fournisseur, BindingResult result, Model model) {
//		System.out.println(fournisseur.getId());
//		if (result.hasErrors()) {
//			model.addAttribute("erreurs", result);
//			return "fournisseur/form";
//		}
//		
////		fournisseur.setId(id); // Plus nécessaire depuis SPRING 6
//		
//		this.repoFournisseur.save(fournisseur);
//		
//		return "redirect:/fournisseur";
//	}
	
	
	// /fournisseur/supprimer?id=4		-> Paramètre de requête, donc @RequestParam
	// /fournisseur/supprimer/4			-> Variable de chemin, donc @PathVariable
	@GetMapping("/fournisseur/supprimer/{id}")
	public String deleteById(@PathVariable int id) {
		try {
			this.repoFournisseur.deleteById(id);
		}
		
		catch (Exception ex) {
			return "redirect:/fournisseur?erreursup";
		}
		
		return "redirect:/fournisseur";
	}
}
