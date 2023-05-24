package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

@RestController
@RequestMapping("/api/produit")
public class ProduitApiController {
	@Autowired
	private IProduitRepository repoProduit;
	
	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> findAll() {
		return this.repoProduit.findAll();
	}
}
