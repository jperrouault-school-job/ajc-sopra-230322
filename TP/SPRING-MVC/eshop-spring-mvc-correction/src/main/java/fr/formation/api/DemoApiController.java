package fr.formation.api;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.exception.ProduitNotValidException;
import fr.formation.model.Produit;
import jakarta.validation.Valid;

//@Controller
//@ResponseBody
@RestController // Combinaison de @Controller & @ResponseBody
@RequestMapping("/api/demo")
public class DemoApiController {
	
	// GET		Récupérer des informations : liste de produits, un produit en particulier
	// POST		Ajouter une information : ajouter un nouveau produit
	// PUT		Modifier une information : modifier un produit qui existe
	// DELETE	Supprimer une information : supprimer un produit qui existe
	
	@GetMapping
	public Produit demo() {
		return new Produit();
	}
	
	@PostMapping
	public Produit postDemo(@Valid @RequestBody Produit produit, BindingResult result) {
		System.out.println(produit.getNom());
		
		if (result.hasErrors()) {
			throw new ProduitNotValidException();
		}
		
		return produit;
	}
}
