package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
	private IFournisseurRepository repoFournisseur;
	
	@GetMapping("/fournisseur")
	public String findAll(Model model) {
		model.addAttribute("fournisseurs", this.repoFournisseur.findAll());
		
		return "fournisseur/liste";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		return "fournisseur/form";
	}
	
	@PostMapping({ "/ajouter", "/modifier/{id}" })
	public String add(@Valid Fournisseur fournisseur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("erreurs", result);
			return "fournisseur/form";
		}
		
		this.repoFournisseur.save(fournisseur);
		
		return "redirect:/fournisseur";
	}
	
	@GetMapping("/modifier/{id}")
	public String edit(@PathVariable int id, Model model) {
		Fournisseur fournisseur = this.repoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);
		model.addAttribute("fournisseur", fournisseur);
		
		return "fournisseur/form";
	}
	
	@GetMapping("/supprimer/{id}")
	public String deleteById(@RequestParam int id) {
		try {
			this.repoFournisseur.deleteById(id);
		}
		
		catch (Exception ex) {
			return "redirect:/fournisseur?erreursup";
		}
		
		return "redirect:/fournisseur";
	}
}
