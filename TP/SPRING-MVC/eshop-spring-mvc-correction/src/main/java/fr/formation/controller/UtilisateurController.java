package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/utilisateur") // Permet de préfixer tous les mappings de la classe de "/utilisateur"
public class UtilisateurController {
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("utilisateurs", this.repoUtilisateur.findAll());
		
		return "utilisateur/liste";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		return "utilisateur/form";
	}
	
	@PostMapping("/ajouter")
	public String add(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("erreurs", result);
			return "utilisateur/form";
		}
		
		this.repoUtilisateur.save(utilisateur);
		
		return "redirect:/utilisateur";
	}
}
