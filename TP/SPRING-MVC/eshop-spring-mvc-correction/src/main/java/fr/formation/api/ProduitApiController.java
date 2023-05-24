package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.exception.ProduitNotFoundException;
import fr.formation.exception.ProduitNotValidException;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin("*")
public class ProduitApiController {
	@Autowired
	private IProduitRepository repoProduit;
	
	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> findAll() {
		return this.repoProduit.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ProduitDetail.class)
	public Produit findById(@PathVariable int id) {
		return this.repoProduit.findById(id).orElseThrow(ProduitNotFoundException::new);
	}
	
	@PostMapping
	@JsonView(Views.ProduitDetail.class)
	public Produit add(@Valid @RequestBody Produit produit, BindingResult result) {
		// On vérifie si on a des erreurs de validation
		if (result.hasErrors()) {
			throw new ProduitNotValidException();
		}
		
		return this.repoProduit.save(produit);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ProduitDetail.class)
	public Produit edit(@PathVariable int id, @Valid @RequestBody Produit produit, BindingResult result) {
		produit.setId(id);
		
		return this.add(produit, result);
	}
	
//	@PutMapping("/{id}")
//	@JsonView(Views.ProduitDetail.class)
//	public Produit edit(@PathVariable int id, @Valid @RequestBody Produit produit, BindingResult result) {
//		// On vérifie si on a des erreurs de validation
//		if (result.hasErrors()) {
//			throw new ProduitNotValidException();
//		}
//		
//		produit.setId(id);
//		
//		return this.repoProduit.save(produit);
//	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		this.repoProduit.deleteById(id);
	}
}
