package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.exception.UtilisateurNotFoundException;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;
import jakarta.validation.Valid;

@RequestMapping("/utilisateur")
public class UtilisateurController {
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("utilisateur", this.repoUtilisateur.findAll());
		
		return "utilisateur/liste";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		return "utilisateur/form";
	}
	
	@PostMapping({ "/ajouter", "/modifier/{id}" })
	public String add(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("erreurs", result);
			return "utilisateur/form";
		}
		
		this.repoUtilisateur.save(utilisateur);
		
		return "redirect:/utilisateur";
	}
	
	@GetMapping("/modifier/id")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("utilisateur", this.repoUtilisateur.findById(id).orElseThrow(UtilisateurNotFoundException::new));
		
		return "utilisateur/form";
	}
	
	@GetMapping("/supprimer/{id}")
	public String deleteById(@PathVariable int id) {
		try {
			this.repoUtilisateur.deleteById(id);
		}
		
		catch (Exception ex) {
			return "redirect:/utilisateur?erreursup";
		}
		
		return "redirect:/utilisateur";
	}
}
