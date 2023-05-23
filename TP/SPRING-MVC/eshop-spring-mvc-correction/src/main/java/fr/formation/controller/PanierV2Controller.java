package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.exception.ProduitNotFoundException;
import fr.formation.repo.IProduitRepository;
import fr.formation.session.PanierSession;

//@Controller
@RequestMapping("/panier")
public class PanierV2Controller {
	@Autowired
	private IProduitRepository repoProduit;
	
	@Autowired
	private PanierSession panier;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("panier", panier.getProduits());
		
		return "panier/liste";
	}
	
	@GetMapping("/ajouter/{id}")
	public String add(@PathVariable int id) {
		panier.add(this.repoProduit.findById(id).orElseThrow(ProduitNotFoundException::new));
		
		return "redirect:/panier";
	}
	
	@GetMapping("/supprimer/{id}")
	public String deleteById(@PathVariable int id) {
		panier.remove(id);
		
		return "redirect:/panier";
	}
}
